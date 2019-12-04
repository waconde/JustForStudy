package simpleFactoryPattern;

public class Invoker {
    public static void main(String[] args) {
        // 必须填全限定名，可通过配置文件方式去掉包名
        Circle circle = (Circle)ShapeFactory.getShape("simpleFactoryPattern.Circle");
        circle.setRadius(3);
        System.out.println(circle);
        
        Square square = (Square)ShapeFactory.getShape("simpleFactoryPattern.Square");
        square.setSideLength(3);
        System.out.println(square);
    }
}
