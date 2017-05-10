package test.effectiveJava.TestP234;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by pro on 17/1/1.
 */
public class Test234Syn {
    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }

    private Set<Integer> set=new HashSet<>();

    public void add(int i){
        synchronized (set) {
            set.add(i);
            System.out.println(i);
            if(i==23)
                set.remove(i);
        }
    }

    public void remove(int i){
        synchronized (set){
            set.remove(i);
        }
    }

}
