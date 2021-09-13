package prototype;

/**
 * 自定义复杂对象javabean
 *
 * @author side.wang
 */
public class Square implements Cloneable {
    public static final String SQUARE = "Square";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Square) super.clone();
    }

    @Override
    public String toString() {
        return SQUARE;
    }
}
