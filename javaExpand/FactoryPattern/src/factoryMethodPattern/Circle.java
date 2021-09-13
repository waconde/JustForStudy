package factoryMethodPattern;

public class Circle implements Shape {
    private static final double PI = 3.14;
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return PI * 2 * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}
