package designPattern.observer;

/**
 * Created by pro on 17/3/31.
 */
public interface Lifecycle {

    void addListener(Listener listener);

    void removeListener(Listener listener);

    void notifyAlls(Event event);



}
