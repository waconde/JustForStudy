package factoryMethodPattern;

public class Square implements Shape {
    private double sideLength;
    
    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return "Square [sideLength=" + sideLength + ", area=" + getArea() + ", perimeter=" + getPerimeter() + "]";
    }
}
