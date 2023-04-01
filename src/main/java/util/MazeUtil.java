package util;

import algorithm.Maze;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MazeUtil {

    private static final String WALL = "#718093";
    private static final String EMPTY = "#f5f6fa";
    private static final String PATH = "#4cd137";
    private static final String EXIT = "#e84118";
    private static final String PERSON = "#00a8ff";

    public static void printMaze(GridPane gridPane,Maze maze) {
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                if (maze.getChamber(i, j).hasPerson()) {
                    changeColor(mazeMatrix(gridPane)[i][j],PERSON);
                } else if (maze.getChamber(i, j).hasExit()) {
                    changeColor(mazeMatrix(gridPane)[i][j],PATH);
                } else {
                    changeColor(mazeMatrix(gridPane)[i][j],WALL);
                }
            }

        }

    }

    public static Pane[][] mazeMatrix(GridPane gridPane) {
        Pane[][] toReturn = new Pane[5][5];
        for (int i = 0; i < 5; i++) {
            toReturn[0][i] = (Pane) gridPane.getChildren().get(i);
        }
        for (int i = 5; i < 10; i++) {
            toReturn[1][i-5] = (Pane) gridPane.getChildren().get(i);
        }
        for (int i = 10; i < 15; i++) {
            toReturn[2][i-10] = (Pane) gridPane.getChildren().get(i);
        }
        for (int i = 15; i < 20; i++) {
            toReturn[3][i-15] = (Pane) gridPane.getChildren().get(i);
        }
        for (int i = 20; i < 25; i++) {
            toReturn[4][i-20] = (Pane) gridPane.getChildren().get(i);
        }

        return toReturn;
    }

    public static void changeColor(Pane pane, String color){
        pane.setStyle("-fx-background-color: " + color + ";");
    }

}
