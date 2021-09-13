package abstractFactoryPattern;

/**
 * 联想族
 *
 * @author side.wang
 */
public class LenovoZ6 implements Phone {

    @Override
    public int call() {
        System.out.println("LenovoZ6正在呼叫...");
        return (int) Math.random() * 10;
    }

    @Override
    public String toString() {
        return "LenovoZ6 [call()=" + call() + "]";
    }

}
