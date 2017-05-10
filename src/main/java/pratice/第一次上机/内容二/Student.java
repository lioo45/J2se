package pratice.第一次上机.内容二;

/**
 * Created by pro on 17/4/10.
 */
public class Student extends Person {

    private String classId;

    private double score;

    public Student(String id, String name,String classId, double score) {
        super(id,name);
        this.classId = classId;
        this.score = score;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
