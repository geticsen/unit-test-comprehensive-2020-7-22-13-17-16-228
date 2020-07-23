package example;

import java.util.LinkedList;
import java.util.List;

public class AnswerGenerateImp implements AnswerGenerate{
    private List<Integer> noRepeatNumber = new LinkedList<Integer>();
    @Override
    public String generate() {
        String answer = "";
        while(noRepeatNumber.size()<4){
            int randomInt = ((int)(Math.random()*10))%10;
            if(!noRepeatNumber.contains(randomInt)){
                noRepeatNumber.add(randomInt);
                answer +=randomInt;
            }
        }
        return answer;
    }
    public static void  main(String[]args){
        AnswerGenerateImp answerGenerateImp = new AnswerGenerateImp();
        System.out.println(answerGenerateImp.generate());
    }
}
