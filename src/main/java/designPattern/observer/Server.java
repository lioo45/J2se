package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 17/3/31.
 */
public class Server implements Lifecycle {

    List<Listener> listeners=new ArrayList<Listener>();


    public void start(){
        //逻辑
        notifyAlls(Event.startEvent);
    }

    public void shutdown(){
        //逻辑
        notifyAlls(Event.shutdownEvent);
    }

    public void interrupt(){
        //逻辑

        notifyAlls(Event.interruptEvent);
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void notifyAlls(Event event) {
        for(Listener listener:listeners){
            listener.update(event);
        }
    }
}
