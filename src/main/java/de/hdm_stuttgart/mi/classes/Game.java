package de.hdm_stuttgart.mi.classes;


import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.gameModeFactory.GamemodeFactory;
import de.hdm_stuttgart.mi.interfaces.IGamemode;
import de.hdm_stuttgart.mi.interfaces.IJoker;
import de.hdm_stuttgart.mi.jokerFactory.JokerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game implements IGamemode {
    private final Logger log = LogManager.getLogger(Game.class);
    private static int[] questionsIndices;
    public static Quiz quiz;
    public static Joker joker = new Joker();
    public IJoker fifty = JokerFactory.createJoker(IJoker.AvailableJoker.FIFTYFIFTY);
    public IJoker extraTime = JokerFactory.createJoker(IJoker.AvailableJoker.TIME);
    public IJoker skipQuestion = JokerFactory.createJoker(IJoker.AvailableJoker.SKIP);


    /* Constructor */
    public Game() throws IllegalFactoryArgument {
        XMLParser parser = new XMLParser();
        quiz = parser.createQuestions();
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

    public static Quiz getQuiz() {
        return quiz;
    }

    public void setGameMode(int gameMode) throws IllegalFactoryArgument {

            switch (gameMode) {
                case 0:
                    GamemodeFactory.createGameMode(Gamemodes.LEICHT);
                    setRemainingJoker(GamemodeFactory.createGameMode(Gamemodes.LEICHT).getJokerCounter());
                    break;
                case 1:
                    GamemodeFactory.createGameMode(Gamemodes.MITTEL);
                    setRemainingJoker(GamemodeFactory.createGameMode(Gamemodes.MITTEL).getJokerCounter());
                    break;
                case 2:
                    GamemodeFactory.createGameMode(Gamemodes.SCHWER);
                    setRemainingJoker(GamemodeFactory.createGameMode(Gamemodes.SCHWER).getJokerCounter());
                    break;
                default:
                    log.error("invalid game mode");
                    throw new IllegalFactoryArgument("invalid game mode!");

            }
        log.info("RemainingJoker: " + remainingJoker);
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

    public void jokerUsedCounter() {
        remainingJoker--;
    }

    /* Interface methods */

    @Override
    public int getJokerCounter() {
        return remainingJoker;
    }

    @Override
    public int getRemainingTime() {
        return timeToAnswer;
    }
}

