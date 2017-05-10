package designPattern.observer;

/**
 * Created by pro on 17/3/31.
 */
public interface Listener {

    void register(Lifecycle lifecycle);

    void update(Event event);

}
