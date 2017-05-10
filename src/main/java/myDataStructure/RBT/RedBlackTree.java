package myDataStructure.RBT;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {

    public  TreeNode root;

    private TreeNode NIL;

    private int size;

    private List<Integer> orderArray;
    //用于统计旋转次数
    private int numOfSpin=0;
    enum Color{
        red,black
    };
    enum Situation{
        LL,LR,RR,RL,M,N,
        leftBlackBlcak,leftRedBlack,leftBlackRed,
        rightBlackBlack,rightRedBlack,rightBlackRed,NotNeddFixUp
    };

    public int getNumOfSpin() {
        return numOfSpin;
    }



    void init(int value){
        NIL=new TreeNode();
        NIL.c=Color.black;
        NIL.father=NIL.lchild=NIL.rchild=NIL;
        root=new TreeNode(value,NIL,NIL,NIL,Color.black);
        size=1;
    }

    public int size(){
        return size;
    }

    public int getHigh(){
        return root.getHigh(root);
    }

    class TreeNode{
        int data;
        TreeNode lchild;
        TreeNode rchild;
        TreeNode father;
        Color c;

        public TreeNode(int data, TreeNode lchild, TreeNode rchild, TreeNode father, Color c) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
            this.father = father;
            this.c = c;
        }

        public TreeNode(int data,Color c) {
            this.data = data;
            this.c=c;
        }

        public TreeNode(){}

        void traval(){
            if(this!=NIL){
                this.lchild.traval();
                System.out.println("data:"+this.data+"   color:"+this.c);
                this.rchild.traval();
            }
        }
        void travalAndSign(int[] a,int[] index){
            if(this!=NIL){
                this.lchild.travalAndSign(a,index);
                a[index[0]]=this.data;
                index[0]++;
                this.rchild.travalAndSign(a,index);
            }
        }

        void travalAndSign(List<Integer> list){
            if(this!=NIL){
                this.lchild.travalAndSign(list);
                list.add(this.data);
                this.rchild.travalAndSign(list);
            }
        }

        int getHigh(TreeNode node){
            int l,r;
            if(node==NIL||node==null)
                return 0;
            l=getHigh(node.lchild)+1;
            r=getHigh(node.rchild)+1;
            if(l>r)
                return l;
            else
                return r;
        }

        boolean isLchild(TreeNode t){
            if(t==t.father.lchild)
                return true;
            return false;
        }
        TreeNode getBrother(){
            if(this==NIL)
                return null;
            else{
                if(this==this.father.lchild)
                    return this.father.rchild;
                else
                    return this.father.lchild;
            }
        }
        TreeNode getUncle(){
            return this.father.getBrother();
        }

        public TreeNode getNode(int value){
            if(root==null)
                return null;
            TreeNode node=this;
            while(node!=NIL){
                if(node.data==value)
                    return node;
                else if(node.data>value)
                    node=node.lchild;
                else
                    node=node.rchild;

            }
            return NIL;
        }

        boolean findAndInsert(TreeNode t){
            TreeNode ct=root;
            TreeNode father;
            int data=t.data;
            while(ct!=NIL){
                if(data<ct.data){
                    father=ct;
                    ct=ct.lchild;
                    if(ct==NIL){
                        father.lchild=t;
                        t.father=father;
                        break;
                    }
                    continue;
                }
                else if(data>ct.data){
                    father=ct;
                    ct=ct.rchild;
                    if(ct==NIL){
                        father.rchild=t;
                        t.father=father;
                        break;
                    }
                    continue;
                }
                else{
//			printf("树中已存在相同的元素:%d",data);
                    return false;
                }

            }
            return true;
        }
        Situation judgeInsertSituation(TreeNode t){
            if(t==null){
                System.out.println("t==null");
            }
            if(t.father==null) {
                System.out.println("t.father==null");
                System.out.println(t.data);
                System.out.println(size);
            }
            if(t.father.c==Color.black)
                return Situation.N;
            else{
                if(t.getUncle().c==Color.black){
                    numOfSpin++;
                    if(isLchild(t)){
                        if(isLchild(t.father))
                            return Situation.LL;
                        else
                            return Situation.RL;
                    }
                    else{
                        if(isLchild(t.father))
                            return Situation.LR;
                        else
                            return Situation.RR;
                    }
                }
                else{
                    return Situation.M;
                }

            }
        }

        void changeColorWithFather(TreeNode t){
            Color c=t.father.c;
            t.father.c=t.c;
            t.c=c;
        }
        TreeNode delete(int value){
            //二分查找要删除的节点
            TreeNode node=getNode(value);
            if(node==NIL||node==null)
                return null;
            //替换要删除的节点
            node=searchAndReplaceNode(node);
            //调整
            deleteFixUp(node);

            if(isLchild(node)){
                node.father.lchild=NIL;
            } else{
                node.father.rchild=NIL;
            }
            node.father=NIL;
            size--;
            return node;
        }

        void deleteFixUp(TreeNode node){
            boolean flag=true;
            while(flag) {
                flag=false;
                Situation situation=judgeDeleteSituation(node);
                switch (situation) {
                    case leftBlackBlcak:
                        if (node.getBrother().lchild.c == Color.black &&
                                node.getBrother().rchild.c == Color.black) {
                            node.father.rchild.c=Color.red;
                            node=node.father;
                            flag=true;
                        } else {
                            if(node.getBrother().rchild.c== Color.black) {
                                changeColorWithFather(node.father.rchild.lchild);
                                rightSpin(node.father);
                            }
                            node.getBrother().rchild.c=Color.black;
                            deleteLeftSpin(node.father);
                        }
                        break;
                    case leftBlackRed:
                        changeColorWithFather(node.getBrother());
                        deleteLeftSpin(node.father);
                        flag=true;
                        break;
                    case leftRedBlack:
                        if(node.getBrother().lchild.c == Color.black &&
                                node.getBrother().rchild.c == Color.black){
                            changeColorWithFather(node.getBrother());
                        } else {
                            if(node.getBrother().rchild.c == Color.black){
                                changeColorWithFather(node.father.rchild.lchild);
                                rightSpin(node.father);
                            }
                            changeColorWithFather(node.getBrother());
                            node.getBrother().rchild.c = Color.black;
                            deleteLeftSpin(node.father);
                        }
                        break;
                    case rightBlackBlack:
                        if (node.getBrother().lchild.c == Color.black &&
                                node.getBrother().rchild.c == Color.black) {
                            node.father.lchild.c=Color.red;
                            node=node.father;
                            flag=true;
                        } else {
                            if(node.getBrother().lchild.c== Color.black) {
                                changeColorWithFather(node.father.lchild.rchild);
                                leftSpin(node.father);
                            }
                            node.getBrother().lchild.c=Color.black;
                            deleteRightSpin(node.father);
                        }
                        break;
                    case rightBlackRed:
                        changeColorWithFather(node.getBrother());
                        deleteRightSpin(node.father);
                        flag=true;
                        break;
                    case rightRedBlack:
                        if(node.getBrother().lchild.c == Color.black &&
                                node.getBrother().rchild.c == Color.black){
                            changeColorWithFather(node.getBrother());
                        } else {
                            if(node.getBrother().lchild.c == Color.black){
                                changeColorWithFather(node.father.lchild.rchild);
                                leftSpin(node.father);
                            }
                            changeColorWithFather(node.getBrother());
                            node.getBrother().lchild.c = Color.black;
                            deleteRightSpin(node.father);
                        }
                        break;
                }
            }

        }


        Situation judgeDeleteSituation(TreeNode node){
            if(node.c==Color.red)
                return Situation.NotNeddFixUp;
            if(isLchild(node)){
                if(node.father.c==Color.black){
                    if(node.getBrother().c==Color.black)
                        return Situation.leftBlackBlcak;
                    else
                        return Situation.leftBlackRed;
                }
                else
                    return Situation.leftRedBlack;

            }else {
                if(node.father.c==Color.black){
                    if(node.getBrother().c==Color.black)
                        return Situation.rightBlackBlack;
                    else
                        return Situation.rightBlackRed;
                }
                else
                    return Situation.rightRedBlack;
            }
        }

        //找到被删除节点的后继节点并替换之,返回一个叶子节点
        TreeNode searchAndReplaceNode(TreeNode node){
            TreeNode next=findNext(node);
            node.data=next.data;
            //如果原来的node节点的右子树为NIL
            //那么左子树不为NIL的话 必为红色的,且它没有孩子
            if(node==next) {
                if(node.lchild!=NIL) {
                    node.data=node.lchild.data;
                    return node.lchild;
                }
            }
            //原来node的后继节点next有右孩子的话
            //那么 这个右孩子必为红色节点 且没有孩子
            if(next.rchild!=NIL){
                node=next;
                node.data=next.rchild.data;
                return node.rchild;

            }
            return next;
        }
        //返回node的后继节点 如果node无右孩子则返回node
        TreeNode findNext(TreeNode node){
            TreeNode next = node.rchild;
            if(next==NIL)
                return node;
            while (next.lchild != NIL)
                next = next.lchild;
            return next;
        }


        void leftSpin(TreeNode rbt){
            TreeNode l,lr;
            l=rbt.lchild;
            lr=l.rchild;
            l.rchild=lr.lchild;
            lr.lchild.father=l;
            lr.lchild=l;
            l.father=lr;
            lr.father=rbt;
            rbt.lchild=lr;
        }

        void rightSpin(TreeNode rbt){

            TreeNode l,r,lr;
            r=rbt.rchild;
            lr=r.lchild;
            r.lchild=lr.rchild;
            lr.rchild.father=r;
            lr.rchild=r;
            r.father=lr;
            rbt.rchild=lr;
            lr.father=rbt;
        }

        void  lsAndChangeColor(TreeNode t){
            TreeNode r,l;
            r=t.rchild;
            r.c=Color.black;
            t.c=Color.red;
            t.rchild=r.lchild;
            r.lchild.father=t;
            r.lchild=t;
            r.father=t.father;
            if(isLchild(t))
                t.father.lchild=r;
            else
                t.father.rchild=r;
            t.father=r;
            if(root==t)
                root = r;
        }

        void deleteLeftSpin(TreeNode t){
            TreeNode r;
            r=t.rchild;
            t.rchild=r.lchild;
            r.lchild.father=t;
            r.lchild=t;
            r.father=t.father;
            if(isLchild(t))
                t.father.lchild=r;
            else
                t.father.rchild=r;
            t.father=r;
            if(root==t)
                root = r;
        }

        void deleteRightSpin(TreeNode t){
            TreeNode l;
            l=t.lchild;
            t.lchild=l.rchild;
            l.rchild.father=t;
            l.rchild=t;
            l.father=t.father;
            if(isLchild(t))
                t.father.lchild=l;
            else
                t.father.rchild=l;
            t.father=l;
            if(root==t)
                root = l;
        }

        void rsAndChangeColor(TreeNode t){
            TreeNode l;
            l=t.lchild;
            t.c=Color.red;
            l.c=Color.black;
            t.lchild=l.rchild;
            l.rchild.father=t;
            l.rchild=t;
            l.father=t.father;
            if(isLchild(t))
                t.father.lchild=l;
            else
                t.father.rchild=l;
            t.father=l;
            if(root==t)
                root = l;

        }
        void dealM(TreeNode t){
            numOfSpin++;
            t.father.c=Color.black;
            t.getUncle().c=Color.black;
            t.father.father.c=Color.red;
        }

        void InsertFixUp(TreeNode t){
            Situation st=judgeInsertSituation(t);
            TreeNode gf=t.father.father;
//	if(st!=N)
//		numOfSpin++;
            switch(st){
                case LL:
                    rsAndChangeColor(gf);
                    break;
                case LR:
                    leftSpin(gf);
                    rsAndChangeColor(gf);
                    break;
                case RR:
                    lsAndChangeColor(gf);
                    break;
                case RL:
                    rightSpin(gf);
                    lsAndChangeColor(gf);
                    break;
                case M:
                    dealM(t);
                    if(gf.father!=NIL)
                        InsertFixUp(gf);
                    else
                        gf.c=Color.black;
                    break;
                case N:
                    break;
            }
        }
        boolean RBInsert(TreeNode t){
            if(size==0){
                t.father=NIL;
                root=t;
                t.c=Color.black;
            }
            else{
                if(findAndInsert(t)==false)
                    return false;
                else{
                    InsertFixUp(t);
                }
            }
            size++;
            return true;
        }

    }


    public void put(int value){
        if(root==null) {
            init(value);
            return ;
        }
        if(root==null){
            System.out.println(value);
        }
        root.RBInsert(new TreeNode(value,NIL,NIL,NIL,Color.red));
    }

    public boolean contains(int value){
        TreeNode node=root.getNode(value);
        if(node==null ||node == NIL)
            return false;
        return true;
    }

    public int remove(int value){
        TreeNode node=root.delete(value);
        if(null==node||node==NIL) {
            System.out.println("不存在值为"+value+"的节点");
            if(!allContains(value)){
                System.out.println("不存在值为"+value+"的节点");
                System.out.println("~~~~~");
            }
            return 0;
        }
        return node.data;
    }
    void traval(){
        root.traval();
    }



    List<Integer> getOrderArray(){
        orderArray=new ArrayList<Integer>(size);
        root.travalAndSign(orderArray);
        return orderArray;
    }

    boolean allContains(int value){
        orderArray=getOrderArray();
        for(Integer i:orderArray){
            if(i==value)
                return true;
        }
        return false;
    }
    boolean isCorrect(){
        int[] a=new int[size];
        int[] index={0};
        root.travalAndSign(a,index);
        for (int i = 1; i <a.length ; i++) {
            if(a[i]<a[i-1])
                return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        RedBlackTree tree=new RedBlackTree();
//
//        tree.formatL_BR_RR();
//        tree.remove(150);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_RB_RB();
//        tree.remove(125);
//        System.out.println(tree.root.data);
//        tree.traval();


//        tree.formatL_RB_RR();
//        tree.remove(125);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_RB_BR();
//        tree.remove(125);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_RB_BB();
//        tree.remove(125);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_BB_BB();
//        tree.remove(50);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_BB_RB();
//        tree.remove(50);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_BB_RR();
//        tree.remove(50);
//        System.out.println(tree.root.data);
//        tree.traval();

//        tree.formatL_BB_BR();
//        tree.remove(50);
//        System.out.println(tree.root.data);
//        tree.traval();
//    }
//
//    void formatL_BB_RR(){
//        init(100);
//        root.lchild=new TreeNode(50,NIL,NIL,root,Color.black);
//        root.rchild=new TreeNode(150,NIL,NIL,root,Color.black);
//        TreeNode r=root.rchild;
//        r.lchild=new TreeNode(125,NIL,NIL,r,Color.red);
//        r.rchild=new TreeNode(175,NIL,NIL,r,Color.red);
//    }
//
//    void formatL_BB_BR(){
//        init(100);
//        root.lchild=new TreeNode(50,NIL,NIL,root,Color.black);
//        root.rchild=new TreeNode(150,NIL,NIL,root,Color.black);
//        TreeNode r=root.rchild;
//        r.rchild=new TreeNode(175,NIL,NIL,r,Color.red);
//    }
//
//    void formatL_BB_RB(){
//        init(100);
//        root.lchild=new TreeNode(50,NIL,NIL,root,Color.black);
//        root.rchild=new TreeNode(150,NIL,NIL,root,Color.black);
//        TreeNode r=root.rchild;
//        r.lchild=new TreeNode(125,NIL,NIL,r,Color.red);
//    }
//
//    void formatL_BB_BB(){
//        init(100);
//        root.lchild=new TreeNode(50,NIL,NIL,root,Color.black);
//        root.rchild=new TreeNode(150,NIL,NIL,root,Color.black);
//        TreeNode r=root.rchild;
//    }
//
//    void formatL_RB_BB(){
//        init(200);
//        root.lchild=new TreeNode(150,NIL,NIL,root,Color.red);
//        root.rchild=new TreeNode(300,NIL,NIL,root,Color.black);
//        TreeNode l=root.lchild;
//        l.lchild=new TreeNode(125,NIL,NIL,l,Color.black);
//        l.rchild=new TreeNode(175,NIL,NIL,l,Color.black);
//    }
//
//
//    void formatL_RB_BR(){
//        init(200);
//        root.lchild=new TreeNode(150,NIL,NIL,root,Color.red);
//        root.rchild=new TreeNode(300,NIL,NIL,root,Color.black);
//        TreeNode l=root.lchild;
//        l.lchild=new TreeNode(125,NIL,NIL,l,Color.black);
//        l.rchild=new TreeNode(175,NIL,NIL,l,Color.black);
//        TreeNode node=l.rchild;
//        node.rchild=new TreeNode(180,NIL,NIL,node,Color.red);
//    }
//
//    void formatL_RB_RR(){
//        init(200);
//        root.lchild=new TreeNode(150,NIL,NIL,root,Color.red);
//        root.rchild=new TreeNode(300,NIL,NIL,root,Color.black);
//        TreeNode l=root.lchild;
//        l.lchild=new TreeNode(125,NIL,NIL,l,Color.black);
//        l.rchild=new TreeNode(175,NIL,NIL,l,Color.black);
//        TreeNode node=l.rchild;
//        node.rchild=new TreeNode(180,NIL,NIL,node,Color.red);
//        node.lchild=new TreeNode(170,NIL,NIL,node,Color.red);
//    }
//
//    void formatL_RB_RB(){
//        init(200);
//        root.lchild=new TreeNode(150,NIL,NIL,root,Color.red);
//        root.rchild=new TreeNode(300,NIL,NIL,root,Color.black);
//        TreeNode l=root.lchild;
//        l.lchild=new TreeNode(125,NIL,NIL,l,Color.black);
//        l.rchild=new TreeNode(175,NIL,NIL,l,Color.black);
//        TreeNode node=l.rchild;
//        node.lchild=new TreeNode(170,NIL,NIL,node,Color.red);
//    }
//
//    void formatL_BR_RR(){
//        init(200);
//        root.lchild=new TreeNode(150,NIL,NIL,root,Color.black);
//        root.rchild=new TreeNode(300,NIL,NIL,root,Color.black);
//        TreeNode node=root.rchild;
//        node.lchild=new TreeNode(250,NIL,NIL,node,Color.black);
//        node.rchild=new TreeNode(350,NIL,NIL,node,Color.black);
//        TreeNode l=root.lchild;
//        l.lchild=new TreeNode(125,NIL,NIL,l,Color.black);
//        l.rchild=new TreeNode(175,NIL,NIL,l,Color.red);
//        node=l.rchild;
//        node.lchild=new TreeNode(170,NIL,NIL,node,Color.black);
//        node.rchild=new TreeNode(180,NIL,NIL,node,Color.black);
//
//    }
}