package de.hdm_stuttgart.mi.classes;


import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.gameModeFactory.GamemodeFactory;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game implements IGamemode {
    private final Logger log = LogManager.getLogger(Game.class);
    private static int[] questionsIndices;

    /* Constructor */
    public Game() {
        XMLParser parser = new XMLParser();
        Quiz quiz = parser.createQuestions();
        setQuestionsIndices(quiz);

    }

    //Class var
    private int roundCount;
    private int timeToAnswer;
    private int remainingJoker;
    private int rightAnswerCounter;
    private int wrongAnswerCounter;

    /* Logger */



    /* Game methods */
    void start() {
        log.info("game started");
    }

    public void stop() {
        log.info("game over");
    }


    /* Getter and Setter methods */

    public void setGamemode(int gamemode) {
        try {
            switch (gamemode){
                case 0: GamemodeFactory.createGameMode(Gamemodes.LEICHT);
                    break;
                case 1: GamemodeFactory.createGameMode(Gamemodes.MITTEL);
                    break;
                case 2: GamemodeFactory.createGameMode(Gamemodes.SCHWER);
                    break;
            }
        } catch (IllegalFactoryArgument illegalFactoryArgument) {
            illegalFactoryArgument.printStackTrace();
        }
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public void setNextRound() {
        if (roundCount < 10) {
            roundCount++;
        }
    }

    public int getQuestionIndex(int index) {
        return questionsIndices[index];
    }

    public int getRemainingJoker() {
        return remainingJoker;
    }

    private void setRemainingJoker(int remainingJoker) {
        this.remainingJoker = remainingJoker;
    }

    public int getTimeToAnswer() {
        return timeToAnswer;
    }

    private void setTimeToAnswer(int timeToAnswer) {
        this.timeToAnswer = timeToAnswer;
    }

    public int getRightAnswerCounter() {
        return rightAnswerCounter;
    }

    public void setRightAnswerCounter() {
        this.rightAnswerCounter++;
    }

    public int getWrongAnswerCounter() {
        return wrongAnswerCounter;
    }

    public void setWrongAnswerCounter() {
        this.wrongAnswerCounter++;
    }

    Player createNewPlayer(String nickname) {

        Player player = new Player(nickname);
        log.info("player: " + player.getId() + " was created");
        return player;
    }

    private void setQuestionsIndices(Quiz quiz) {
        questionsIndices = quiz.getQuestionIndices();
    }

    public void setNewGame() {
        roundCount = 0;
        wrongAnswerCounter = 0;
        rightAnswerCounter = 0;
        setQuestionsIndices(new Quiz());
    }

    /* Interface methods */

    @Override
    public int getJokerCounter() {
        return 0;
    }

    @Override
    public int getRemainingTime() {
        return 0;
    }
}

