package myDataStructure.SkipList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by pro on 17/3/13.
 *
 * 初始化:向最低一层加入结点,
 * 之后通过随机算法判断是否向上一层添加该结点.
 *
 * 查找:
 *  输入:要找到的value
 *  输出:true or false
 *
 * 插入:
 *  先调用查找的辅助方法,查看方法的返回节点是否等于value,若不等于则插入这个节点的后一个位置,
 *  如果需要的话会依次更新上层链表 同时更新heads.
 *
 *  删除:
 */
public class SkipList {

    //heads[i]表示第i层链表
    //heads[i]保存着所有的元素
    private List<Node> heads;

    private int size;
    //用于产生随机数
    private Random random;

    //add()方法里会调用查找的方法,在查找到元素的过程中按照后进先出的顺序记录每一个需要向下走的节点
    //当插入完成,如果需要向i+1层链表插入此value时,只需要从pathStack中pop一个节点,这个节点就是元素value的前驱节点.
    private Stack<Node> pathStack;

    private void init(){
        heads=new ArrayList<Node>();
        heads.add(new Node(-1,null,null));
        random=new Random();
        pathStack=new Stack<Node>();
    }

    public int size(){
        return size;
    }

    public boolean contains(int value){
        if(heads==null)
            return false;
        Node node=helpContains(value,heads.get(heads.size()-1),false);
        if(node==heads.get(0))
            return false;
        return node.value==value?true:false;
    }

    //从最高层开始,从前往后遍历,小于向右,大于回退一个节点向下,然后重复,直到找到value.
    //当找不到时,返回一个节点,这个node.val<value,这个node.next.val>value(如果存在的话)
    //无论如何这个节点总是处于第0层链表即heads[0]
    private Node helpContains(int value,Node currentNode,boolean formatStack){
        if(currentNode==null)
            return null;
        Node node=currentNode;
        //向右走
        Node lastNode=currentNode;
        while (node.hasNext()) {
            lastNode=node;
            node=node.next;
            if(node.value<value)
                continue;
            else if (value == node.value)
                break;
            else {
                //此时应该回退一格 向下递归 value<node.value
                if (lastNode.hasDown()) {
                    if(formatStack)
                            pathStack.push(lastNode);
                    return helpContains(value, lastNode.down, formatStack);
                }
                else {
                    //当前是最底层 且value<node.value
                        node = lastNode;
                        break;
                }
            }
        }
        //node是尾节点且有down,则执行这个递归
        if(node.hasDown()) {
            if(formatStack)
                pathStack.push(node);
            return helpContains(value, node.down, formatStack);
        }
        return node;
    }

    //测试每一层heads[i],若每个链表都是升序,则返回true 否则false

    public boolean add(int value){
        if(heads==null)
            init();
        pathStack.clear();
        Node node=helpContains(value,heads.get(heads.size()-1),true);
        //如果已经存在value则直接返回
        if(node!=heads.get(0)) {
            if (node.value == value) {
                return true;
            }
        }
        //先在最低层插入节点
        Node insertNode=new Node(value,node.next,null);
        node.next=insertNode;
        Node origin=insertNode;
        //可能需要往上构造
        boolean need = (random.nextInt(10000000) & 1)== 0 ? true : false;
        while(need){
            if(!pathStack.isEmpty()) {
                //沿着查看时在pathStack中记录的路径向上构造
                Node upNodePre = pathStack.pop();
                Node upNode = new Node(value, upNodePre.next, origin);
                upNodePre.next = upNode;
                origin = upNode;
            }else{
                //这种情况下会增加一层链表
                Node upNode=new Node(value,null,origin);
                Node head=new Node(-1, null, null);
                head.down=heads.get(heads.size()-1);
                heads.add(head);
                heads.get(heads.size()-1).next=upNode;
                break;
            }
            need = (random.nextInt(10000000) & 1)== 0 ? true : false;
        }
        ++size;
        return true;
    }

    class Node{
        int value;
        Node next;
        Node down;

        public boolean hasNext(){
            return next==null?false:true;
        }
        public boolean hasDown(){
            return down==null?false:true;
        }

        public Node(int value, Node next, Node down) {
            this.value = value;
            this.next = next;
            this.down = down;
        }
    }

    public boolean testAll(){
        for (int i = 0; i <heads.size() ; i++) {
            Node node=heads.get(i);
            Node first=node.next;
            int index=1;
            while(first.hasNext()){
                Node second=first.next;
                if(second.value<first.value) {
                    System.out.println("第" + (i+1) + "层:" + second.value + "<" + first.value);
                    System.out.println("第"+index+"个元素与第"+(index+1)+"个元素比较失败");
                    return false;
                }
                first=first.next;
                ++index;
            }
        }
        return true;
    }

    //输出每一层链表的长度
    public void printHeadsIndex(int index){
        Node node=heads.get(index);
        int len=0;
        while(node.hasNext()){
            node=node.next;
            len++;
        }
        System.out.println(len);
    }

    public void printAllLen(){
        for (int i = 0; i <heads.size() ; i++) {
            printHeadsIndex(i);
        }
    }

}
