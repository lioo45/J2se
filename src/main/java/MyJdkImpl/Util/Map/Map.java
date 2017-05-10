package MyJdkImpl.Util.Map;


/**
 * Created by pro on 16/12/6.
 */
public interface Map<K,V> {

    void clear();


    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    V put(K key,V value);

    V remove(K key);

    int size();



}
