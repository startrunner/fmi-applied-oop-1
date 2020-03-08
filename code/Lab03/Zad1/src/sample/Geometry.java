package sample;

//import com.sun.javafx.geom.Point2D;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Geometry extends Application {

    static double readVerticalLineX() {
        var inputDialog = new TextInputDialog();
        inputDialog.setHeaderText(null);
        inputDialog.setContentText("AB line X");
        double x = Double.parseDouble(inputDialog.showAndWait().get());
        return x;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        double verticalLineX = readVerticalLineX();


        var group = new Group();
        ObservableList<Node> children = group.getChildren();

        double totalWidth = 400, totalHeight = 400;
        double centerX = totalWidth / 2, centerY = totalHeight / 2;

        double circleRadius = Math.min(totalWidth, totalHeight) / 3.0;
        var circle = new Circle();
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setRadius(circleRadius);
        circle.setStroke(Color.BLACK);
        circle.setFill(null);
        children.add(circle);

        addSegment(
            children,
            new Point2D(verticalLineX, 0),
            new Point2D(verticalLineX, totalHeight),
            Color.RED
        );

        {
            List<Point2D> crossPoints = getPointsAtGivenX(circle, verticalLineX);
            if (crossPoints.size() < 2) {
                var alert = new Alert(Alert.AlertType.CONFIRMATION, "NADA CROSS POINT");
                alert.showAndWait();
                return;
            }

            Point2D a = crossPoints.get(0), b = crossPoints.get(1);
            Point2D center = new Point2D(centerX, centerY);
            Point2D abMiddle = getSegmentMiddle(a, b);

            addSegment(children, abMiddle, b, Color.ORANGE);
            addSegment(children, a, center, Color.GREEN);
            addSegment(children, abMiddle, center, Color.GREEN);
            addSegment(children, a, abMiddle, Color.GREEN);

            addLabeledPoint(children, abMiddle, "M");
            addLabeledPoint(children, center, "O");
            addLabeledPoint(children, a, "A");
            addLabeledPoint(children, b, "B");
        }

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(group, totalWidth, totalHeight));
        primaryStage.show();
    }

    private static Point2D getSegmentMiddle(Point2D a, Point2D b) {
        return new Point2D((a.getX() + b.getX()) / 2.0, (a.getY() + b.getY()) / 2.0);
    }

    private void addSegment(ObservableList<Node> children, Point2D a, Point2D b, Color brush) {
        var lineAB = new Line();
        lineAB.setStartX(a.getX());
        lineAB.setStartY(a.getY());
        lineAB.setEndX(b.getX());
        lineAB.setEndY(b.getY());
        lineAB.setStroke(brush);
        children.add(lineAB);
    }

    private static void addLabeledPoint(ObservableList<Node> items, Point2D point, String label) {
        var circle = new Circle();
        circle.setStroke(null);
        circle.setFill(Color.BLACK);
        circle.setCenterX(point.getX());
        circle.setCenterY(point.getY());
        circle.setRadius(3);
        items.add(circle);


        if (label == null)
            label = "";

        label = String.format("%s(%.2f, %.2f)", label, point.getX(), point.getY());

        var text = new Text(label);
        text.setX(point.getX() + 5);
        text.setStroke(Color.BLACK);
        text.setY(point.getY() + 5);
        items.add(text);
    }

    private static List<Point2D> getPointsAtGivenX(Circle circle, double x) {
        if (x < circle.getCenterX() - circle.getRadius() || x > circle.getCenterX() + circle.getRadius())
            return new ArrayList<>();

        double innerX = x - circle.getCenterX();

        //r^2 = x^2 + y^2
        //y^2 = r^2 - x^2
        double innerY = Math.sqrt(Math.pow(circle.getRadius(), 2) - Math.pow(innerX, 2));

        List<Point2D> result = new ArrayList<>();

        double y1 = innerY + circle.getCenterY();
        if (innerY == 0) {
            result.add(new Point2D(x, y1));
        } else {
            double y2 = -innerY + circle.getCenterY();
            result.add(new Point2D(x, Math.min(y1, y2)));
            result.add(new Point2D(x, Math.max(y1, y2)));
        }

        return result;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
