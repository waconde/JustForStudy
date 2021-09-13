package factoryMethodPattern;

public class Invoker {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new CircleFactory();
        Circle circle = (Circle) shapeFactory.getShape();
        circle.setRadius(3);
        System.out.println(circle);

        shapeFactory = new SquareFactory();
        Square square = (Square) shapeFactory.getShape();
        square.setSideLength(3);
        System.out.println(square);
    }
}
