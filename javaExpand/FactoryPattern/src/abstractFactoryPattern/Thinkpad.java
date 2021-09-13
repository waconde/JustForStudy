package abstractFactoryPattern;

/**
 * 联想族
 *
 * @author side.wang
 */
public class Thinkpad implements Computer {

    @Override
    public int powerOnSelfTest() {
        System.out.println("Thinkpad自检中...");
        return (int) Math.random() * 10;
    }

    @Override
    public String toString() {
        return "Thinkpad [powerOnSelfTest()=" + powerOnSelfTest() + "]";
    }

}
