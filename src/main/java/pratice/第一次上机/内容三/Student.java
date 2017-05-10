package pratice.第一次上机.内容三;

import java.util.List;
import java.util.Map;

/**
 * Created by pro on 17/4/10.
 */
public class Student implements Comparable<Student>{


    protected String name;

    //所学课程
    protected String course;

    //成绩
    protected float score;

    protected String scoresLevel;


    public Student(){}

    public Student(String name) {
        this.name = name;
    }

    public   void scoreToLevel(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getScoresLevel() {
        return scoresLevel;
    }

    public void setScoresLevel(String scoresLevel) {
        this.scoresLevel = scoresLevel;
    }

    public String levelToString(){
        switch (scoresLevel){
            case "A":
                return "优秀";
            case "B":
                return "良好";
            case "C":
                return "一般";
            case "D":
                return "及格";
            default:
                return "不及格";
        }
    }
    @Override
    public int compareTo(Student o) {
        return scoresLevel.compareTo(o.scoresLevel);
    }
}
