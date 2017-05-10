package pratice.第一次上机.List;

/**
 * Created by pro on 17/4/10.
 */
public class Test {
    public static void main(String[] args) {
        Link link=new Link();
        for (int i = 0; i <10 ; i++) {
            link.insertHeadNode(i);
        }
        link.displayLink();

    }
}
