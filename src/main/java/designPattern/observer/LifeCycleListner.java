package designPattern.observer;

/**
 * Created by pro on 17/3/31.
 */

public class LifeCycleListner implements Listener {

    @Override
    public void register(Lifecycle lifecycle) {

    }

    @Override
    public void update(Event event) {
        switch (event){
            case startEvent:
                System.out.println("start......");
                break;
            case interruptEvent:
                System.out.println("interrupt.....");
                break;
            case shutdownEvent:
                System.out.println("shutdown......");
                break;
        }
    }
}
