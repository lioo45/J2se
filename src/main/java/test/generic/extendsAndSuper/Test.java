package test.generic.extendsAndSuper;

/**
 * Created by pro on 16/12/13.
 */
public class Test implements Comparable<Test> {

    private int num;

    public Test(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    public Test(){

    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Test o) {
        if(num>o.num)
            return 1;
        else if(num==o.num)
            return 0;
        else
            return -1;
    }

}
