public class Rectangle {
    private double width;
    private double height;
    private String color = "Yellow";

    public Rectangle() {
        this(1, 1, "Bembeno");
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public Rectangle(double width, double height, String color) {
        this(width, height);
        setColor(color);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().equals("")) {
            throw new IllegalArgumentException("Color cannot be null or empty string!");
        }
        this.color = color;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}
