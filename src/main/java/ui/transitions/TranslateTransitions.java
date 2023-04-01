package ui.transitions;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TranslateTransitions {

    public static void translateX(Pane pane, int endValue, int millis) {

        pane.translateXProperty().set(0);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateXProperty(), endValue, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();

    }

    public static void translateXBack(Pane pane, int endValue, int millis) {

        pane.translateXProperty().set(endValue);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateXProperty(), 0, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();

    }


    public static void translateY(Pane pane, int endValue, int millis) {

        pane.translateYProperty().set(0);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateYProperty(), endValue, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();


    }

    public static void translateYBack(Pane pane, int endValue, int millis) {

        pane.translateYProperty().set(endValue);

        Timeline timeline = new Timeline();

        KeyValue keyValue = new KeyValue(pane.translateYProperty(), 0, Interpolator.EASE_IN);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(millis), keyValue);

        timeline.getKeyFrames().add(keyFrame);


        timeline.play();


    }

    public static void scale(Node node, double from, double to, int milis, int delay) {
        javafx.animation.ScaleTransition st = new javafx.animation.ScaleTransition(Duration.millis(milis), node);
        st.setDelay(Duration.millis(delay));
        st.setFromX(from);
        st.setFromY(from);
        st.setToX(to);
        st.setToY(to);
        st.play();
    }

}
