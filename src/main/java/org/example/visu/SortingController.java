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
        values = generateRandomValues(50);
        sorting = new Sorting(values);
        drawValues();
    }

    @FXML
    public void startSorting(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            if(sorting.bubbleSortStep()) {
                drawValues();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void drawValues() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double width = canvas.getWidth() / values.size();
        double heightFactor = canvas.getHeight() / 100.0;

        for (int i = 0; i < values.size(); i++) {
            double height = values.get(i) * heightFactor;
            double x = i * width;
            double y = canvas.getHeight() - height;
            if(i % 2 == 0){
                gc.setFill(Color.BLUE);
            }
            else gc.setFill(Color.DARKRED);
            gc.fillRect(x, y, width, height);
            gc.setFill(Color.WHITE);
            gc.fillText(String.valueOf(values.get(i)), x + width / 2 - 10, y + height / 2);
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
