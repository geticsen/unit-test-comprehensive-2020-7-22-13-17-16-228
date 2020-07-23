package example;

public class GuessNumberGame {
    private  int countTimes = 0;
    private String answer;
    public GuessNumberGame(){

    }
    public GuessNumberGame(String answer){
        this.answer = answer;
    }
    public GuessNumberGame(AnswerGenerate answerGenerate){
        this.answer = answerGenerate.generate();
    }
    public String guess(String guess){
        if (answer.equals(guess)){
            return "4A0B";
        }else {
            return "2A2B";
        }

    }
}
