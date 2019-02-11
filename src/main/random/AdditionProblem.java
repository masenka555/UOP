package random;

import java.util.Random;

public class AdditionProblem {
    private int x,y,answer;
    private Random ran = new Random();

    public AdditionProblem() {
        x = (int)(10 + 40*Math.random());
        y = (int)(30 * Math.random());
        answer = x + y;
    }

    public String getProblem() {
        return "Compute the sum: " + x + " + " + y;
    }

    public int getAnswer() {
        return answer;
    }

    public String getNextProblem() {
        x = ran.nextInt(50);
        y = ran.nextInt(30);
        answer = x + y;
        return getProblem();
    }

}


