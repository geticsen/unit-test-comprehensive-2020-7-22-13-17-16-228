package example;

import java.util.ArrayList;
import java.util.List;

public class GuessNumberGame {
    private int countTimes = 0;
    private String answer;
    private List<String> answerSplitList = new ArrayList<String>();
    private List<String> guessSplitList = new ArrayList<String>();

    public GuessNumberGame() {

    }

    public GuessNumberGame(String answer) {
        this.answer = answer;
        String splitAnswer[] = answer.split("");
        for (String s : splitAnswer) {
            answerSplitList.add(s);
        }
    }

    public GuessNumberGame(AnswerGenerate answerGenerate) {
        this.answer = answerGenerate.generate();
    }

    public String guess(String guess) {
        String splitGuess[] = guess.split("");
        for (String s : splitGuess) {
            guessSplitList.add(s);
        }
        String locationRight = locationRightAndNumberRight();
        String numberRight = locationErrorButNumberRight();
        return locationRight + numberRight;
    }

    public String locationRightAndNumberRight() {
        int coutLocationRightAndNumberRight = 0;
        for (int i = 0; i < guessSplitList.size(); i++) {
            if (islocationRight(guessSplitList.get(i), i)) {
                coutLocationRightAndNumberRight++;
            }
        }
        return coutLocationRightAndNumberRight + "A";
    }

    public String locationErrorButNumberRight() {
        int coutlocationErrorButNumberRight = 0;
        for (int i = 0; i < guessSplitList.size(); i++) {
            if (!islocationRight(guessSplitList.get(i), i) && isNumberRight(guessSplitList.get(i))) {
                coutlocationErrorButNumberRight++;
            }
        }
        return coutlocationErrorButNumberRight + "B";
    }

    public boolean islocationRight(String s, int location) {
        return answerSplitList.get(location).equals(s);
    }

    public boolean isNumberRight(String num) {
        return answerSplitList.contains(num);
    }

}
