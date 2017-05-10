package pratice.第一次上机.内容二;

/**
 * Created by pro on 17/4/10.
 */
public class Teacher extends Person{
    //职称
    private String title;

    private String apartment;


    public Teacher(String id, String name,String title, String apartment) {
        super(id,name);
        this.title = title;
        this.apartment = apartment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
