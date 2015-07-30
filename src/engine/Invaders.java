package engine;

import screen.*;

import java.util.List;

/**
 * Created by Ryan on 7/28/2015.
 */
public class Invaders {

    /**
     * Start running the game
     */
    public static void run() {

        // Get a list of levels to play
        List<GameSettings> levelSettings = Levels.getLevels();

        // Hold on to all of the game's information
        GameState gameState = new GameState(1, 0, Constants.MAX_LIVES, 0, 0);
        
        // Show Title Screen below this line
        Screen screen = new TitleScreen();
        screen.show();

        ScreenType nextScreenType = screen.getNextScreenType();
        while(nextScreenType != ScreenType.EndGame) {
            if (nextScreenType == ScreenType.TitleScreen) {
                Screen titleScreen = new TitleScreen();
                titleScreen.show();
            } else if (nextScreenType == ScreenType.GameScreen) {
                Screen gameScreen = new GameScreen(gameState, levelSettings);
                gameScreen.show();
            } else if (nextScreenType == ScreenType.ScoreScreen) {
                Screen scoreScreen = new ScoreScreen(gameState);
                scoreScreen.show();
            } else if (nextScreenType == ScreenType.HighScoreScreen) {
                Screen highScoreScreen = new HighScoreScreen();
                highScoreScreen.show();
            }
            nextScreenType = screen.getNextScreenType();
        }
    }
}
