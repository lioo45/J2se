package pratice.第一次上机.List;

/**
 * Created by pro on 17/4/10.
 */
public class Link {
    private Node first;


    public Link () {
        this.first=null;
    }

    public boolean isEmpty(){
        return first==null?true:false;
    }


    public void insertHeadNode(int value){
        Node node=new Node(value);
        if(first==null)
            first=node;
        else{
            node.next=first;
            first=node;
        }
    }

    public Node deleteHeadNode(){
        if(first==null)
            return null;
        Node node=first;
        first=first.next;
        return node;
    }

    public boolean findNode(int value){
        if(first==null)
            return false;
        Node node=first;
        while(node!=null){
            if(value==node.getData())
                return true;
            node=node.next;
        }
        return false;
    }

    public void displayLink (){
        if(first==null)
            return ;
        Node node=first;
        while(node!=null){
            System.out.print(node.getData());
            node=node.next;
        }

    }

}
