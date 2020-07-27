package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GuessNumberGame {
    private static final String GAME_OVER_MESSAGE = "game over";
    private int countTimes = 0;

    public String getAnswer() {
        return answer;
    }

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
            output= "Wrong Input,Input again";
            this.countTimes--;
        }
        return output;
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
    public static void main(String []args) throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerGenerateImp().generate());
        String answer = guessNumberGame.getAnswer();
        System.out.println("answer is:" + answer);
        String guess = "";
        String output = "";
        while (!output.equals("game over")){
            System.out.print("Input guess:");
            guess = br.readLine();
            output = guessNumberGame.play(guess);
            System.out.println(output);

        }
    }
}
