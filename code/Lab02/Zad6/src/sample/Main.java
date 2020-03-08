/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import com.sun.javafx.stage.WindowEventDispatcher;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

//import java.awt.geom.Point2D;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        scene = new Scene(group, 400, 400);
        var children = group.getChildren();

        double width = scene.getWidth();
        double height = scene.getHeight();

        int count = 30;

        boolean topRight = true, topLeft = true, bottomRight = true, bottomLeft = true;

        if (bottomLeft) {
            Circle circle = cornerCircle(width, 0);
            children.add(circle);

            for (int i = 1; i <= count; i++) {
                var from = new Point2D((width / count) * i, height);
                var to = new Point2D(0, 0);
                children.add(makeLine(circle, from, to));
            }

            for (int i = 1; i <= count; i++) {
                var from = new Point2D(0, (height / count) * i);
                var to = new Point2D(width, height);
                children.add(makeLine(circle, from, to));
            }
        }

        if (topLeft) {
            Circle circle = cornerCircle(width, height);
            children.add(circle);

            for (int i = 1; i <= count; i++) {
                var from = new Point2D((width / count) * i, 0);
                var to = new Point2D(0, height);
                children.add(makeLine(circle, from, to));
            }

            for (int i = 1; i <= count; i++) {
                var from = new Point2D(0, (height / count * i));
                var to = new Point2D(width, 0);
                children.add(makeLine(circle, from, to));
            }
        }

        if (bottomRight) {
            Circle circle = cornerCircle(0, 0);
            children.add(circle);

            for (int i = 1; i <= count; i++) {
                var from = new Point2D((width / count) * i, height);
                var to = new Point2D(width, 0);
                children.add(makeLine(circle, from, to));
            }

            for (int i = 1; i <= count; i++) {
                var from = new Point2D(width, (height / count) * i);
                var to = new Point2D(0, height);
                children.add(makeLine(circle, from, to));
            }
        }

        if (topRight) {
            Circle circle = cornerCircle(0, width);
            children.add(circle);

            for (int i = 1; i <= count; i++) {
                var from = new Point2D((width / count) * i, 0);
                var to = new Point2D(width, height);
                children.add(makeLine(circle, from, to));
            }

            for (int i = 1; i <= count; i++) {
                var from = new Point2D(width, (height / count) * i);
                var to = new Point2D(0, 0);
                children.add(makeLine(circle, from, to));
            }
        }

        // Set the title of the Stage(the application window)
        primaryStage.setTitle("Drawing shapes");
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage (the application window)
        primaryStage.show();
    }

    private static Line makeLine(Circle circle, Point2D from, Point2D to) {
        List<Point2D> newTo = getCircleLineIntersectionPoint(circle, from, to);
        for (Point2D point : newTo) {
            if (distSquare(from, point) < distSquare(from, to))
                to = point;
        }

        return makeLine(from, to);
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

    private Circle cornerCircle(double x, double y) {
        var result = new Circle();
        result.setFill(null);
        result.setStroke(Color.RED);
        result.setCenterX(x);
        result.setCenterY(y);
        result.setRadius(scene.getWidth());
        //result.setRadiusY(scene.getHeight());
        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static double distSquare(Point2D a, Point2D b) {
        return Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2);
    }

    public static List<Point2D> getCircleLineIntersectionPoint(Circle circle, Point2D pointA, Point2D pointB) {
        //https://stackoverflow.com/questions/13053061/circle-line-intersection-points
        var center = new Point2D(circle.getCenterX(), circle.getCenterY());
        double radius = circle.getRadius();

        double baX = pointB.getX() - pointA.getX();
        double baY = pointB.getY() - pointA.getY();
        double caX = center.getX() - pointA.getX();
        double caY = center.getY() - pointA.getY();

        double a = baX * baX + baY * baY;
        double bBy2 = baX * caX + baY * caY;
        double c = caX * caX + caY * caY - radius * radius;

        double pBy2 = bBy2 / a;
        double q = c / a;

        double disc = pBy2 * pBy2 - q;
        if (disc < 0) {
            return Collections.emptyList();
        }
        // if disc == 0 ... dealt with later
        double tmpSqrt = Math.sqrt(disc);
        double abScalingFactor1 = -pBy2 + tmpSqrt;
        double abScalingFactor2 = -pBy2 - tmpSqrt;

        Point2D p1 = new Point2D(pointA.getX() - baX * abScalingFactor1, pointA.getY()
            - baY * abScalingFactor1);
        if (disc == 0) { // abScalingFactor1 == abScalingFactor2
            return Collections.singletonList(p1);
        }
        Point2D p2 = new Point2D(pointA.getX() - baX * abScalingFactor2, pointA.getY()
            - baY * abScalingFactor2);
        return Arrays.asList(p1, p2);
    }
}
