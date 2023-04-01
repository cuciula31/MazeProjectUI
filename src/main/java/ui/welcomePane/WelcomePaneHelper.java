package ui.welcomePane;

import javafx.animation.PauseTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import ui.transitions.FadeTranslations;
import ui.transitions.TranslateTransitions;

import java.util.Random;

public class WelcomePaneHelper {

    public static void flyAway(Pane welcomePane) {
        TranslateTransitions.translateY(welcomePane, 1000, 250);
    }


}
