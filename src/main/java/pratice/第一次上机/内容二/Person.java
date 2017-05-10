package pratice.第一次上机.内容二;

/**
 * Created by pro on 17/4/10.
 */
public class Person {
    private String id;

    private String name;

    public Person(){}
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
