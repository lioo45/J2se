package designPattern.observer;

/**
 * Created by pro on 17/3/31.
 */
public class Client {
    public static void main(String[] args) {
        Server server=new Server();
        Listener listener=new LifeCycleListner();
        server.addListener(listener);

        server.start();
        server.shutdown();
    }
}
