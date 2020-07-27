package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuessNumberGame {
    private static final String GAME_OVER_MESSAGE = "game over";
    public static final String WRONG_INPUT_MESSAGE = "Wrong Input,Input again";
    public static final String ALL_RIGHT = "A";
    private int countTimes = 0;



    public void setAnswer(String answer) {
        this.answer = answer;
    }

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
    public String play(String guess){

        String output = "";
        if(this.countTimes<6){
            output= guess(guess);
        }else {
            output= GAME_OVER_MESSAGE;
        }
        return output;
    }
    public boolean checkInput(String guess){
        String splitGuess[] = guess.split("");
        guessSplitList.clear();
        for (String s : splitGuess) {
            if(!guessSplitList.contains(s)){
                guessSplitList.add(s);
            }
        }
        if (guessSplitList.size()==4){
            return true;
        }else {
            return false;
        }
    }
    public String guess(String guess) {
        this.countTimes++;
        String output = "";
        if(checkInput(guess)){
            String locationRight = locationRightAndNumberRight();
            String numberRight = locationErrorButNumberRight();
            output=  locationRight + numberRight;
        }else {
            output= WRONG_INPUT_MESSAGE;
            this.countTimes--;
        }
        return output;
    }

    public String locationRightAndNumberRight() {
        int count = 0;
        for (int i = 0; i < guessSplitList.size(); i++) {
            if (islocationRight(guessSplitList.get(i), i)) {
                count++;
            }
        }
        return count + ALL_RIGHT;
    }

    public String locationErrorButNumberRight() {
        int count = 0;
        for (int i = 0; i < guessSplitList.size(); i++) {
            if (!islocationRight(guessSplitList.get(i), i) && isNumberRight(guessSplitList.get(i))) {
                count++;
            }
        }
        return count + "B";
    }

    public boolean islocationRight(String s, int location) {
        return answerSplitList.get(location).equals(s);
    }

    public boolean isNumberRight(String num) {
        return answerSplitList.contains(num);
    }

}
