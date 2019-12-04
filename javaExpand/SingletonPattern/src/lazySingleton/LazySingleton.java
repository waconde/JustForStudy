package lazySingleton;

public class LazySingleton {
    /* volatile保证实例修改时对所有线程的同步
     * 如果不需要在多线程环境下运行，则可以去掉volatile和synchronized关键字，防止性能和资源浪费
     */
    private static volatile LazySingleton INSTANCE_LAZY_SINGLETON = null;
    
    private LazySingleton() {
        
    }
    
    public static synchronized  LazySingleton getInstance() {
        if(INSTANCE_LAZY_SINGLETON == null) {
            INSTANCE_LAZY_SINGLETON = new LazySingleton();
        }
        return INSTANCE_LAZY_SINGLETON; 
    }
}
