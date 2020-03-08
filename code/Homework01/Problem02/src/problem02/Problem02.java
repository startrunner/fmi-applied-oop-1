/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem02;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.List;

public class Problem02 extends Application {
    final Scene scene;
    final Group group;
    final ObservableList<Node> children;
    final double width = 400, height = 400;

    public Problem02() {
        group = new Group();
        scene = new Scene(group, width, height);
        children = group.getChildren();
    }

    @Override
    public void start(Stage primaryStage) {
        int lineCountPerSide = 30;

        boolean topRight = false, topLeft = false, bottomRight = false, bottomLeft = true;

        if (bottomLeft) {
            Circle circle = makeCornerCircle(width, 0);
            children.add(circle);

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D((width / lineCountPerSide) * i, height);
                var direction = new Point2D(0, 0);
                children.add(makeLine(from, direction, circle));
            }

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D(0, (height / lineCountPerSide) * i);
                var direction = new Point2D(width, height);
                children.add(makeLine(from, direction, circle));
            }
        }

        if (topLeft) {
            Circle circle = makeCornerCircle(width, height);
            children.add(circle);

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D((width / lineCountPerSide) * i, 0);
                var direction = new Point2D(0, height);
                children.add(makeLine(from, direction, circle));
            }

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D(0, (height / lineCountPerSide * i));
                var direction = new Point2D(width, 0);
                children.add(makeLine(from, direction, circle));
            }
        }

        if (bottomRight) {
            Circle circle = makeCornerCircle(0, 0);
            children.add(circle);

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D((width / lineCountPerSide) * i, height);
                var direction = new Point2D(width, 0);
                children.add(makeLine(from, direction, circle));
            }

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D(width, (height / lineCountPerSide) * i);
                var direction = new Point2D(0, height);
                children.add(makeLine(from, direction, circle));
            }
        }

        if (topRight) {
            Circle circle = makeCornerCircle(0, width);
            children.add(circle);

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D((width / lineCountPerSide) * i, 0);
                var direction = new Point2D(width, height);
                children.add(makeLine(from, direction, circle));
            }

            for (int i = 1; i <= lineCountPerSide; i++) {
                var from = new Point2D(width, (height / lineCountPerSide) * i);
                var direction = new Point2D(0, 0);
                children.add(makeLine(from, direction, circle));
            }
        }

        primaryStage.setTitle("Drawing shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Circle makeCornerCircle(double centerX, double centerY) {
        var result = new Circle();
        result.setFill(null);
        result.setStroke(Color.RED);
        result.setCenterX(centerX);
        result.setCenterY(centerY);
        result.setRadius(scene.getWidth());
        return result;
    }

    private static Line makeLine(Point2D from, Point2D direction, Circle circleTo) {
        List<Point2D> intersections = Geometry.getCircleLineIntersectionPoints(circleTo, from, direction);

        Point2D closestToStart = direction;
        for (Point2D point : intersections) {
            if (Geometry.distanceSquare(from, point) < Geometry.distanceSquare(from, closestToStart))
                closestToStart = point;
        }

        return makeLine(from, closestToStart);
    }

    private static Line makeLine(Point2D from, Point2D to) {
        var line = new Line();
        line.setStartX(from.getX());
        line.setStartY(from.getY());
        line.setEndX(to.getX());
        line.setEndY(to.getY());
        line.setStroke(Color.RED);
        return line;
    }

    public static void main(String[] args) {
        launch(new String[]{});
    }
}
