package eagerSingleton;

public class EagerSingleton {
    // 饿汉式直接使用final关键字，实例确保不可变，不必担心线程不安全问题
    private static final EagerSingleton INSTANCE_EAGER_SINGLETON = new EagerSingleton();
    
    private EagerSingleton() {
        
    }
    
    public static EagerSingleton getInstance() {
        return INSTANCE_EAGER_SINGLETON;
    }
}
