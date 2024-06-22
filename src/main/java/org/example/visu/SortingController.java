package org.example.visu;

import algo.Sorting;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingController {

    @FXML
    private Canvas canvas;

    @FXML
    private Button startButton;

    private List<Integer> values;
    private Sorting sorting;

    @FXML
    public void initialize() {
        values = generateRandomValues(10);
        sorting = new Sorting(values);
        drawValues(-1, -1);
    }

    @FXML
    public void startSorting(){
        sorting.setInsertionSort(false);
        int[] indices = new int[2];
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if(sorting.bubbleSortStep(indices)) {
                drawValues(indices[0], indices[1]);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    public void startInsertionSort(){
        sorting.setInsertionSort(true);
        int[] indices = new int[2];
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            if(sorting.insertionSortStep(indices)){
                drawValues(indices[0], indices[1]);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void drawValues(int current, int next) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double squareSize = canvas.getWidth() / values.size();

        for (int i = 0; i < values.size(); i++) {
            double x = i * squareSize;
            double y = canvas.getHeight() - squareSize;
            gc.setFill(Color.LIGHTBLUE);
            if (i == current) {
                gc.setFill(Color.RED);
            }
            if (i == next) {
                gc.setFill(Color.BLUE);
            }
            gc.fillRect(x, y, squareSize, squareSize);
            gc.setStroke(Color.GREEN);
            gc.strokeRect(x, y, squareSize, squareSize);
            gc.setFill(Color.BLACK);
            gc.fillText(String.valueOf(values.get(i)), x + squareSize / 2 - 10, y + squareSize / 2);
        }
    }



    private List<Integer> generateRandomValues(int count){
        List<Integer> values = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < count; i++){
            values.add(random.nextInt(100) + 1);
        }
        return values;
    }

}
