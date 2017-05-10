package pratice.第一次上机.内容三;

/**
 * Created by pro on 17/4/10.
 */
public class Postgraduate extends Student {

    @Override
    public void scoreToLevel() {

        if(score>=90)
            scoresLevel="A";
        else if(score>=80)
            scoresLevel="B";
        else if(score>=70)
            scoresLevel="C";
        else if(score>=60)
            scoresLevel="D";
        else
            scoresLevel="E";

    }
}
