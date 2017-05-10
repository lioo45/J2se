package pratice.第一次上机.内容三;

import java.util.Set;

/**
 * Created by pro on 17/4/10.
 */
public class Undergraduate extends Student {

    @Override
    public void scoreToLevel() {
        if(score>=80)
            scoresLevel="A";
        else if(score>=70)
            scoresLevel="B";
        else if(score>=60)
            scoresLevel="C";
        else if(score>=50)
            scoresLevel="D";
        else
            scoresLevel="E";
    }
}
