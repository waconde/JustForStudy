package prototype;

/**
 * 自定义复杂对象javabean
 * @author side.wang
 *
 */
public class Circle implements Cloneable {
    public static final String CIRCLE = "Circle";
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Circle)super.clone();
    }

    @Override
    public String toString() {
        return CIRCLE;
    }
}
