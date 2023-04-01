package ui.mainPane;

import algorithm.LevelSearch;
import algorithm.Maze;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import ui.transitions.TranslateTransitions;
import ui.welcomePane.WelcomePaneHelper;
import util.MazeUtil;

import java.nio.file.Watchable;
import java.util.Arrays;

public class Controller {
    //WelcomePane
    @FXML
    private GridPane grid1;

    @FXML
    private Pane welcomePane;
    @FXML
    private GridPane mazeGrid;

    private Maze maze = new Maze(5,5,2,0,0);


    @FXML
    private void startReleased(){
        WelcomePaneHelper.flyAway(welcomePane);
    }

    @FXML
    private void backReleased(){
        TranslateTransitions.translateYBack(welcomePane,0,250);
    }

    @FXML
    private void aiReleased(){
        LevelSearch.search(mazeGrid,maze);
    }

    @FXML
    private void leftReleased(){

        if (maze.getChamber(maze.findMan().getX(),maze.findMan().getY()-1).hasExit()){
            maze.moveMan(0,-1);
            MazeUtil.printMaze(mazeGrid,maze);
        }
    }

    @FXML
    private void upReleased(){
        if (maze.getChamber(maze.findMan().getX()-1,maze.findMan().getY()).hasExit()){
            maze.moveMan(-1,0);
            MazeUtil.printMaze(mazeGrid,maze);
        }
    }

    @FXML
    private void rightReleased(){
        if (maze.getChamber(maze.findMan().getX(),maze.findMan().getY()+1).hasExit()) {
            maze.moveMan(0, 1);
            MazeUtil.printMaze(mazeGrid, maze);
        }
    }

    @FXML
    private void downReleased(){
        if (maze.getChamber(maze.findMan().getX()+1,maze.findMan().getY()).hasExit()) {
            maze.moveMan(1, 0);
            MazeUtil.printMaze(mazeGrid, maze);
        }
    }

    @FXML
    private void mazeReleased(){
        maze = new Maze(5,5,2,0,0);
        MazeUtil.printMaze(mazeGrid,maze);
    }


}
