package utilRead.comment;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by pro on 16/12/12.


//指定初始化容量和负载因子
public HashMap(int initialCapacity, float loadFactor)
//指定初始化容量负载因子和默认的0.75 不过在实际初始化中的容量cap>=initialCapacity且cap=2^n
public HashMap(int initialCapacity)
//默认容量16,默认负载因子0.75
public HashMap()
//显然 没有什么好说的.
public HashMap(Map<? extends K, ? extends V> m)


@SuppressWarnings("ReadHashmap")
public class ReadHashmap<K,V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;
    //只是为了不报错
    public ReadHashmap(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    //内部桶的表示
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
    transient Node<K,V>[] table;

    transient Set<Map.Entry<K,V>> entrySet;

    transient int size;

    transient int modCount;

    int threshold;

    final float loadFactor;



    //返回一个数num,其中num>=cap,且num=2^n
    //思路:将二进制表示中最高位为1的位的右边全置为1
    static final int tableSizeFor(int cap) {
        int n = cap - 1;//如果cap本身就是 a power of two
        n |= n >>> 1;//将最高位为1的右边1位置为1
        n |= n >>> 2;//右边3位置为1,if exist
        n |= n >>> 4;//右边7位置为1,if exist
        n |= n >>> 8;//右边14位置为1,if exist
        n |= n >>> 16;//右边31为置为1,if exist
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //如果容器未初始化 则先初始化
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        //如果hash值对应的桶未被使用 其中(n-1)&hash 得出的值:0<=i<=n-1
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
            //对应的桶已经存在元素
        else {
            Node<K,V> e; K k;
            //如果出现同样的key则替换旧的
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            //如果该桶的结点已经转换成红黑树 则调用红黑树的插入
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                //用链地址法处理冲突 如果链表的长度大于树化阀值 可能会转换成红黑树
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    //链表中存在着与待插入结点 key和hash相同的结点.
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // 如果出现同样的key则替换旧的  返回旧的value
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                //LinkHashMap继承Hashmap 用于实现记录顺序
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        //如果当前已使用的桶大于阀值则再散列
        if (++size > threshold)
            resize();
        //LinkHashMap继承Hashmap 用于实现记录顺序
        afterNodeInsertion(evict);
        return null;
    }



    //扩容或者初始化HashMap
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        //对应正常情况,已在使用的容器进行扩容,设置新的容量和阀值 一般为之前的两倍
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        //对应 new Hashmap(cap) 第一次调用put时 设置容量
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        //对应new Hashmap() 第一次使用(调用put)的初始化 设置容量和阀值
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        //对应 new Hashmap(cap) 设置阀值
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        //这个属性为阀值
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        //如果oldTab为null的话直接返回,即容器第一次使用 不然将oldTap的结点copy到newTab
        if (oldTab != null) {
            //遍历oldTab中的每个结点
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                //如果该结点不为null
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    //该桶只有一个结点
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    //该桶装的是红黑树 则调用
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    //该桶装的是链表 链表中的各个元素的hash值可能不同
                    else { // preserve order  分类构造两个链表 是为了保证链表在新容器中的顺序
                        //将链表结点分为两类:
                        //一类为新下标<oldCap. 另一类为新下标>=oldCap
                        //第一类结点的头指针和尾指针
                        Node<K,V> loHead = null, loTail = null;
                        //第二类结点的头指针和尾指针
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            //第一类结点 hash&oldCap=0 的结点 新下标<oldCap
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                }
                                else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            }
                            //第二类结点 hash&oldCap!=0 的结点 新下标>=oldCap
                            else {
                                if (hiTail == null) {
                                    hiHead = e;
                                }
                                else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        //第一类结点 因为oldCap=2^n 所以hash值的第n位一定为0
                        // 所以这一类结点在新容器中的下标与老容器中的一样(用位操作证明)
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        //第二类结点 即hash值的第n位一定为1
                        // 所以这一类结点在新容器中的下标=j+oldCap
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                        //我想吐槽一下这里的实现 用hash&oldCap==0?来分类.
                        //换成这样会不会更好? (hash&newCap)>=oldCap?
                    }
                }
            }
        }
        return newTab;
    }
    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        //如果桶的容量小于 最小树化要求的容量则不会转成红黑树
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            //将原来桶对应的链表转换成树结点 并用设置结点的prev和next属性来保持链表的顺序
            //使得转成红黑树后也可以退化成链表
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            //将桶的结点转换成树的结点 并调用treefy来完成红黑树的构造
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }

    //传入tab参数是为了将转换后的红黑树的根节点放到对应的桶中
    final void treeify(Node<K,V>[] tab) {
        TreeNode<K,V> root = null;
        //root是树根结点 x是待插入结点
        for (TreeNode<K,V> x = this, next; x != null; x = next) {
            next = (TreeNode<K,V>)x.next;
            x.left = x.right = null;
            //将根节点的parent置为null
            if (root == null) {
                x.parent = null;
                x.red = false;
                root = x;
            }
            else {
                K k = x.key;
                int h = x.hash;
                Class<?> kc = null;
                //二分查找合适的插入位置
                for (TreeNode<K,V> p = root;;) {
                    int dir, ph;
                    K pk = p.key;
                    //位于同一个桶中的结点的hash值可能不同
                    //优先依靠hash值来比较大小 dir为比较结果
                    if ((ph = p.hash) > h)
                        dir = -1;
                    else if (ph < h)
                        dir = 1;
                        //x.hash=p.hash
                        //如果待插入结点x的key没有实现了Comparable接口或者
                        //已经实现Comparable接口但是,x的key与父结点的key不是同一个类的实例
                        //则dir为 内定的比较规则计算得出的结果
                        //否则dir为待插入结点key与父结点key的比较结果(即正常情况 key都为同一个类的实例且实现Comparable接口)
                    else if ((kc == null &&
                            (kc = comparableClassFor(k)) == null) ||
                            (dir = compareComparables(kc, k, pk)) == 0)
                        dir = tieBreakOrder(k, pk);

                    TreeNode<K,V> xp = p;
                    //找到要插入的位置后 进行红黑树的插入
                    if ((p = (dir <= 0) ? p.left : p.right) == null) {
                        x.parent = xp;
                        if (dir <= 0)
                            xp.left = x;
                        else
                            xp.right = x;
                        //红黑树的插入 有兴趣自己看
                        root = balanceInsertion(root, x);
                        break;
                    }
                }
            }
        }
        //将已经平衡的红黑树的根节点放入桶
        moveRootToFront(tab, root);
    }
    //在putVal方法中 如果要插入的桶结点为树结点 那么就会调用此方法来完成树的插入
    //要先看前边的treeify()再看这个会好理解些
    final TreeNode<K,V> putTreeVal(HashMap<K,V> map, Node<K,V>[] tab,
                                   int h, K k, V v) {
        Class<?> kc = null;
        boolean searched = false;
        //如果该节点(this)不是树根结点 则调用root(),令root为树根结点
        TreeNode<K,V> root = (parent != null) ? root() : this;
        //接下来的插入规则与treeify()如出一辙
        //二分查找合适的插入位置
        for (TreeNode<K,V> p = root;;) {
            int dir, ph; K pk;
            //dir为比较的结果,比较的值为hash值
            if ((ph = p.hash) > h)
                dir = -1;
            else if (ph < h)
                dir = 1;
            //即树中已经存在相同元素 则直接返回
            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                return p;
                //x.hash=p.hash
                //如果待插入结点x的key没有实现了Comparable接口或者
                //已经实现Comparable接口但是,x的key与父结点的key不是同一个类的实例
                //则dir为 内定的比较规则计算得出的结果
                //否则dir为待插入结点key与父结点key的比较结果(即正常情况 key都为同一个类的实例且实现Comparable接口)
            else if ((kc == null &&
                    (kc = comparableClassFor(k)) == null) ||
                    (dir = compareComparables(kc, k, pk)) == 0) {
                if (!searched) {
                    TreeNode<K,V> q, ch;
                    searched = true;
                    //即树中已经存在相同元素 则直接返回
                    if (((ch = p.left) != null &&
                            (q = ch.find(h, k, kc)) != null) ||
                            ((ch = p.right) != null &&
                                    (q = ch.find(h, k, kc)) != null))
                        return q;
                }
                //采用内定的方法计算比较结果
                dir = tieBreakOrder(k, pk);
            }

            TreeNode<K,V> xp = p;
            //找到要插入的位置后 进行红黑树的插入
            if ((p = (dir <= 0) ? p.left : p.right) == null) {
                Node<K,V> xpn = xp.next;
                TreeNode<K,V> x = map.newTreeNode(h, k, v, xpn);
                if (dir <= 0)
                    xp.left = x;
                else
                    xp.right = x;
                //next与prev用于保证 当红黑树退化时,能够还原成原来的链表(保证顺序)
                xp.next = x;
                x.parent = x.prev = xp;
                if (xpn != null)
                    ((TreeNode<K,V>)xpn).prev = x;
                moveRootToFront(tab, balanceInsertion(root, x));
                return null;
            }
        }
    }
    //在resize()扩容,从oldTab迁移到newTab时,当要迁移的结点为树结点
    //则调用此方法完成迁移 这里假设你已经读完了resize()方法.
    final void split(HashMap<K,V> map, Node<K,V>[] tab, int index, int bit) {
        //首先将树节点 链接成两个链表(树的结构不变) 因为TreeNode继承了Node 所以也可以表示为链表而树结构不变
        //按照resize()中链表的分类法来构造这个两个链表
        TreeNode<K,V> b = this;
        // Relink into lo and hi lists, preserving order
        TreeNode<K,V> loHead = null, loTail = null;
        TreeNode<K,V> hiHead = null, hiTail = null;
        //lc为第一类链表的元素个数 hc为第二类链表的元素个数
        //用法详见后续说明
        int lc = 0, hc = 0;
        for (TreeNode<K,V> e = b, next; e != null; e = next) {
            next = (TreeNode<K,V>)e.next;
            e.next = null;
            if ((e.hash & bit) == 0) {
                if ((e.prev = loTail) == null)
                    loHead = e;
                else
                    loTail.next = e;
                loTail = e;
                ++lc;
            }
            else {
                if ((e.prev = hiTail) == null)
                    hiHead = e;
                else
                    hiTail.next = e;
                hiTail = e;
                ++hc;
            }
        }
        //lc和hc的作用显现在这里
        if (loHead != null) {
            //如果链表长度lc<=6(UNTREEIFY_THSHOLD) 那么
            //将红黑树退化成链表
            if (lc <= UNTREEIFY_THRESHOLD)
                //untreeify()很简单不展开了
                tab[index] = loHead.untreeify(map);
            else {
                tab[index] = loHead;
                if (hiHead != null) // (else is already treeified)
                    loHead.treeify(tab);
            }
        }
        //如果链表长度hc<=6(UNTREEIFY_THSHOLD) 那么
        //将红黑树退化成链表
        if (hiHead != null) {
            if (hc <= UNTREEIFY_THRESHOLD)
                tab[index + bit] = hiHead.untreeify(map);
            else {
                tab[index + bit] = hiHead;
                if (loHead != null)
                    hiHead.treeify(tab);
            }
        }
    }
}

 */