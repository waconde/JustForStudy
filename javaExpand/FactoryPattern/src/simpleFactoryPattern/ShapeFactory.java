package simpleFactoryPattern;

/**
 * 使用反射机制创建实例，符合开闭原则
 * @author side.wang
 *
 */
public class ShapeFactory {
    public static Shape getShape(String clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (Shape)obj;
    }
}
