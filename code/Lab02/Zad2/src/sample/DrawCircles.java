package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class DrawCircles extends Application {

    @Override
    public void start(Stage primaryStage) {
        final Group group = new Group();
        final Scene scene = new Scene(group, 500, 500);
        final ObservableList<Node> groupChildren = group.getChildren();

        final double width = scene.getWidth();
        final double height = scene.getHeight();

        final double centerX = Math.floor(width / 2);
        final double centerY = Math.floor(height / 2);

        final int circleCount = 12;
        final double baseRadius = 20.0;

        for (int i = 0; i < circleCount; i++) {
            double size = (i + 1) * baseRadius;

            Circle circle = new Circle();
            circle.setCenterX(centerX);
            circle.setCenterY(centerY);
            circle.setRadius(size);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            groupChildren.add(circle);
        }

        final var horizontalDiameter = new Line();
        horizontalDiameter.setStartX(centerX - circleCount * baseRadius);
        horizontalDiameter.setEndX(centerX + circleCount * baseRadius);
        horizontalDiameter.setEndY(centerY);
        horizontalDiameter.setStartY(centerY);
        horizontalDiameter.setStroke(Color.RED);
        groupChildren.add(horizontalDiameter);

        final var verticalDiameter = new Line();
        verticalDiameter.setStartX(centerX);
        verticalDiameter.setEndX(centerX);
        verticalDiameter.setStartY(centerY - circleCount * baseRadius);
        verticalDiameter.setEndY(centerY + circleCount * baseRadius);
        verticalDiameter.setStroke(Color.RED);
        groupChildren.add(verticalDiameter);

        primaryStage.setTitle("Twelve object-oriented circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
