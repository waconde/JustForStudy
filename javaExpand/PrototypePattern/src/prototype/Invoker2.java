package prototype;

/**
 * 扩展原型模式调用者
 *
 * @author side.wang
 */
public class Invoker2 {

    public static void main(String[] args) {
        PrototypeManager prototypeManager = new PrototypeManager();
        AbstractPrototype circle = prototypeManager.getShape("圆");
        System.out.println(circle);
        AbstractPrototype square = prototypeManager.getShape("方");
        System.out.println(square);
    }
}
