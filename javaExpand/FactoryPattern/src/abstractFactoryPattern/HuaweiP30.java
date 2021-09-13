package abstractFactoryPattern;

/**
 * 华为族
 *
 * @author side.wang
 */
public class HuaweiP30 implements Phone {

    @Override
    public int call() {
        System.out.println("HuaweiP30正在呼叫...");
        return (int) Math.random() * 10;
    }

    @Override
    public String toString() {
        return "HuaweiP30 [call()=" + call() + "]";
    }

}
