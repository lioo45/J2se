package pratice.第一次上机.List;

/**
 * Created by pro on 17/4/10.
 */
public class Node {

    private int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next=null;
    }
    public void NodeDisplay(){
                System.out.println ("{"+data+"}");
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}