package prototype;

/**
 * 抽象原型类
 * @author side.wang
 *
 */
public interface AbstractPrototype extends Cloneable {
    void printShapeType();
    Object clone();
}
