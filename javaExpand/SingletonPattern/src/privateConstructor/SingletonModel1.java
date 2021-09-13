package privateConstructor;

import java.io.Serializable;

public class SingletonModel1 implements Serializable {
    private static final long serialVersionUID = - 4214717102400201376L;

    private static final SingletonModel1 INSTANCE = new SingletonModel1();
    // 全局检测开关，第一次创建对象后就关闭，防止反射二次创建对象。
    private static boolean isFirst = true;

    private SingletonModel1() {
        synchronized (SingletonModel1.class) {
            if (isFirst) {
                isFirst = false;
            } else {
                throw new RuntimeException("抱歉，此操作会破坏单例模式，已终止。");
            }
        }
    }

    public static SingletonModel1 getInstance() {
        return INSTANCE;
    }

    // 防止反序列化产生新的实例对象。如果一定要实现Serializable接口的话
    private Object readResolve() {
        return INSTANCE;
    }

    // 防止克隆产生新的实例对象
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }
}
