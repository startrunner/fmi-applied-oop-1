public class RectangleTest {
    public static void main(String[] args) {
        var rectangle = new Rectangle(10, 30, "Blue");

        System.out.println(10 * 30 == rectangle.getArea());
        System.out.println(2 * (10 + 30) == rectangle.getPerimeter());
        System.out.println(rectangle.getColor().equals("Blue"));
    }
}


