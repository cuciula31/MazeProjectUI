package ui.transitions;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class FadeTranslations {

    public static void fade(Node node, double fromOpacity, double toOpacity, int milis) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setFromValue(fromOpacity);

        //PauseTransition pauseTransition = new PauseTransition(Duration.millis(milis));
        // pauseTransition.setOnFinished(actionEvent -> {
        fadeTransition.setOnFinished(actionEvent -> {
            if (toOpacity == 0) {
                node.setDisable(true);
                node.setVisible(false);
            }
        });

        if (toOpacity != 0) {

            node.setDisable(false);
            node.setVisible(true);
        }
        //pauseTransition.play();

        fadeTransition.setToValue(toOpacity);
        fadeTransition.setNode(node);
        fadeTransition.setDuration(Duration.millis(milis));
        fadeTransition.play();
    }

    public static void fade(Pane pane, double fromOpacity, double toOpacity, int milisDuration, int milisDelay) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDelay(Duration.millis(milisDelay));
        fadeTransition.setFromValue(fromOpacity);
        fadeTransition.setOnFinished(actionEvent -> {
            if (toOpacity == 0) {
                pane.setDisable(true);
                pane.setVisible(false);
            }
        });
        if (toOpacity != 0) {

            pane.setDisable(false);
            pane.setVisible(true);
        }

        fadeTransition.setToValue(toOpacity);
        fadeTransition.setNode(pane);
        fadeTransition.setDuration(Duration.millis(milisDuration));
        fadeTransition.play();


    }

    public static void fade(Node node, double fromOpacity, double toOpacity, int milisDuration, int milisDelay) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDelay(Duration.millis(milisDelay));
        fadeTransition.setFromValue(fromOpacity);

        fadeTransition.setOnFinished(actionEvent -> {
            if (toOpacity == 0) {
                node.setDisable(true);
                node.setVisible(false);
            }
        });
        if (toOpacity != 0) {
            node.setDisable(false);
            node.setVisible(true);
        }
        fadeTransition.setToValue(toOpacity);
        fadeTransition.setNode(node);
        fadeTransition.setDuration(Duration.millis(milisDuration));
        fadeTransition.play();


    }

}
