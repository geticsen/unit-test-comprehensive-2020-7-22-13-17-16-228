package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GuessNumberGameTest {
    @Test
    public void should_return_4A0B_when_guess_1234_given_1234() {
        //given
        String answer = "1234";
        String guessNumber = "1234";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.guess(guessNumber);

        //then
        Assertions.assertEquals("4A0B", actual);
    }

    @Test
    public void should_return_2A2B_when_guess_1234_given_1243() {
        //given
        String answer = "1234";
        String guessNumber = "1243";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.guess(guessNumber);

        //then
        Assertions.assertEquals("2A2B", actual);
    }

    @Test
    public void should_return_1A2B_when_guess_1234_given_1623() {
        //given
        String answer = "1234";
        String guessNumber = "1623";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.guess(guessNumber);

        //then
        Assertions.assertEquals("1A2B", actual);
    }

    @Test
    public void should_return_0A4B_when_guess_1234_given_4321() {
        //given
        String answer = "1234";
        String guessNumber = "4321";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.guess(guessNumber);

        //then
        Assertions.assertEquals("0A4B", actual);
    }

    @Test
    public void should_return_0A1B_when_guess_1234_given_5178() {
        //given
        String answer = "1234";
        String guessNumber = "5178";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.guess(guessNumber);

        //then
        Assertions.assertEquals("0A1B", actual);
    }

    @Test
    public void should_return_0A0B_when_guess_1234_given_5678() {
        //given
        String answer = "1234";
        String guessNumber = "5678";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.guess(guessNumber);

        //then
        Assertions.assertEquals("0A0B", actual);
    }

    @Test
    public void should_return_wrong_message_when_guess_1234_given_1111() {
        //given
        String answer = "1234";
        String guessNumber = "1111";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        String actual = guessNumberGame.play(guessNumber);

        //then
        Assertions.assertEquals("Wrong Input,Input again", actual);
    }

    @Test
    public void should_return_game_over_when_guess_1234_given_over_6_times() {
        //given
        String answer = "1234";
        String guessNumber = "1567";
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);

        //when
        for (int i = 0; i < 6; i++) {
            String actual = guessNumberGame.play(guessNumber);
        }
        String actual = guessNumberGame.play(guessNumber);

        //then
        Assertions.assertEquals("game over", actual);
    }
}
