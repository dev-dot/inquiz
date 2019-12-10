package de.hdm_stuttgart.mi.jokerFactory;

import de.hdm_stuttgart.mi.exceptions.IllegalFactoryArgument;
import de.hdm_stuttgart.mi.interfaces.IJoker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JokerFactory implements IJoker {
    private static final Logger log = LogManager.getLogger(JokerFactory.class);

    public static IJoker createJoker(de.hdm_stuttgart.mi.interfaces.IJoker.AvailableJoker availableJoker) throws IllegalFactoryArgument {

        switch (availableJoker){
            case FIFTYFIFTY: return new FiftyFiftyJoker();
            case TIME: return new TimeJoker();
            case SKIP:return new SkipQuestionJoker();
            default:
                log.error("wrong Joker!");
                throw new IllegalFactoryArgument(
                        "Wrong Joker!");
        }

    }

    @Override
    public void useJoker() {}
}
