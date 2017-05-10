package test.TestAutoBox;

import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by pro on 17/3/3.
 */
public class M {
    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        //t
        System.out.println(c==d);
        //f
        System.out.println(e==f);
        //t
        System.out.println(c==(a+b));
        //t
        System.out.println((c.equals(a+b)));
        //t
        System.out.println(g==(a+b));
        //f
        System.out.println(g.equals(a+b));

    }
}
