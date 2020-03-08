package problem02;

import javafx.geometry.Point2D;
import javafx.scene.shape.Circle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Geometry {
    private Geometry() {
    }

    //https://stackoverflow.com/questions/13053061/circle-line-intersection-points
    public static List<Point2D> getCircleLineIntersectionPoints(Circle circle, Point2D pointA, Point2D pointB) {
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

    public static double distanceSquare(Point2D a, Point2D b) {
        return Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2);
    }
}
