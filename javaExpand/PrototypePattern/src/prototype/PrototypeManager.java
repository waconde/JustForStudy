package prototype;

import java.util.HashMap;

/**
 * 原型管理器：存放多种原型，返回不同原型的复制
 * 加入原型管理器，扩展原型模式
 *
 * @author side.wang
 */
public class PrototypeManager {
    private HashMap<String, AbstractPrototype> prototypeMap = null;

    public PrototypeManager() {
        super();

        prototypeMap = new HashMap<>(16);

        HashMap<Integer, String> info1 = new HashMap<Integer, String>(16);
        info1.put(1, "半径为3");
        prototypeMap.put("圆", new ConcretePrototypeCircle("圆形", info1, new Circle()));

        HashMap<Integer, String> info2 = new HashMap<Integer, String>(16);
        info2.put(1, "边长为3");
        prototypeMap.put("方", new ConcretePrototypeSquare("方形", info2, new Square()));
    }

    public void addShape(String key, AbstractPrototype abstractPrototype) {
        prototypeMap.put(key, abstractPrototype);
    }

    public AbstractPrototype getShape(String key) {
        AbstractPrototype abstractPrototype = prototypeMap.get(key);
        return (AbstractPrototype) abstractPrototype.clone();
    }
}
