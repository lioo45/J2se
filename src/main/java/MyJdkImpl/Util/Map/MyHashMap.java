package MyJdkImpl.Util.Map;

/**
 * Created by pro on 16/12/6.
 */
public class MyHashMap<K,V> implements Map<K,V> {

    //初始大小
    private int size=100;

    private Entry<K,V> entities[];
    //容量因子
    private float factor;

    public MyHashMap(){
        entities=new Entry[size];
    }

    public MyHashMap(int size){
        this.size=size;
        entities=new Entry[size];
    }


    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
    class Entry<K,V>{
        private K key;
        private V value;

        private int hash;

        public int hashcode(){
            return 0;
        }

        public Entry(V value, K key) {
            this.value = value;
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
