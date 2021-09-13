package abstractFactoryPattern;

/**
 * 华为族
 *
 * @author side.wang
 */
public class Matebook implements Computer {

    @Override
    public int powerOnSelfTest() {
        System.out.println("Matebook自检中...");
        return (int) Math.random() * 10;
    }

    @Override
    public String toString() {
        return "Matebook [powerOnSelfTest()=" + powerOnSelfTest() + "]";
    }

}
