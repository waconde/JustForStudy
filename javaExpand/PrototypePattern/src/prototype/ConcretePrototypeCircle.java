package prototype;

import java.util.HashMap;

/**
 * 具体原型类
 * @author side.wang
 *
 */
public class ConcretePrototypeCircle implements AbstractPrototype {
    private String shapeName;
    private HashMap<Integer, String> info;
    private Circle circle;

    @Override
    public String toString() {
        return "ConcretePrototypeCircle [shapeName=" + shapeName + ", info=" + info + ", shapeType=" + circle + "]";
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public HashMap<Integer, String> getInfo() {
        return info;
    }

    public void setInfo(HashMap<Integer, String> info) {
        this.info = info;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public ConcretePrototypeCircle(String shapeName, HashMap<Integer, String> info, Circle circle) {
        super();
        this.shapeName = shapeName;
        this.info = info;
        this.circle = circle;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public Object clone() {
        ConcretePrototypeCircle concretePrototypeCircle = null;
        try {
            // 对基本类型进行浅克隆
            concretePrototypeCircle = (ConcretePrototypeCircle)super.clone();
            // 对每个复杂类型进行单独克隆，需要先在该复杂类型的类中继承Cloneable接口，重写clone()方法或者使用序列化进行克隆
            // 这里HashMap已经继承Cloneable接口，且重写了clone方法，因此可以直接使用
            concretePrototypeCircle.info = (HashMap<Integer, String>)this.info.clone();
            // 对自定义对象进行深克隆，同复杂类型
            concretePrototypeCircle.circle = (Circle)this.circle.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return concretePrototypeCircle;
    }

    @Override
    public void printShapeType() {
        System.out.println(Circle.CIRCLE);
    }

}
