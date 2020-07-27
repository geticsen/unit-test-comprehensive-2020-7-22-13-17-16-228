package example;

import java.util.LinkedList;
import java.util.List;

public class AnswerGenerateImp implements AnswerGenerate {
    private List<Integer> noRepeatNumbers = new LinkedList<Integer>();

    @Override
    public String generate() {
        String answer = "";
        while (noRepeatNumbers.size() < 4) {
            int randomInt = ((int) (Math.random() * 10)) % 10;
            if (!noRepeatNumbers.contains(randomInt)) {
                noRepeatNumbers.add(randomInt);
                answer += randomInt;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        AnswerGenerateImp answerGenerateImp = new AnswerGenerateImp();
        System.out.println(answerGenerateImp.generate());
    }
}
