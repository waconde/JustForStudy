package factoryMethodPattern;

/**
 * 具体工厂
 *
 * @author side.wang
 */
public class SquareFactory implements ShapeFactory {

    @Override
    public Shape getShape() {
        return new Square();
    }

}
