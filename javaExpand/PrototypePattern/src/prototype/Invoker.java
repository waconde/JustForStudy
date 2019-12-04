package prototype;

import java.util.HashMap;

/**
 * 普通原型模式调用者
 * @author side.wang
 *
 */
public class Invoker {
    
    public static void main(String[] args) {
        HashMap<Integer, String> info = new HashMap<Integer, String>(16);
        info.put(1, "半径为2");
        AbstractPrototype abstractPrototype = new ConcretePrototypeCircle("圆形", info, new Circle());
        System.out.println(abstractPrototype);
        AbstractPrototype clone = (ConcretePrototypeCircle)abstractPrototype.clone();
        System.out.println(clone);
    }
}
