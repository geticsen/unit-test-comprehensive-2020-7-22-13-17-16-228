package example;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AnswerGenerateImp implements AnswerGenerate {
    private List<Integer> noRepeatNumbers = new LinkedList<Integer>();

    @Override
    public String generate() {
        String answer = "";
        Random random = new Random();
        while (noRepeatNumbers.size() < 4) {
            int randomInt = random.nextInt(10);;
            if (!noRepeatNumbers.contains(randomInt)) {
                noRepeatNumbers.add(randomInt);
                answer += randomInt;
            }
        }
        return answer;
    }

}
