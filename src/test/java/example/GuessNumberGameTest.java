package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuessNumberGameTest {
    @Test
    public  void  should_return_4A0B_when_guess_1234_given_1234(){
        //given
        String answer = "1234";
        String guessNumber = "1234";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        //when
        String actual = guessNumberGame.guess(guessNumber);
        //then
        Assertions.assertEquals(answer,actual);
    }
}
