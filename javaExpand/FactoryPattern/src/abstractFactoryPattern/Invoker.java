package abstractFactoryPattern;

/**
 * 调用者
 *
 * @author side.wang
 */
public class Invoker {
    public static void main(String[] args) {
        Electricalfactory electricalFactory = new LenovoElectricalFactory();
        Computer computer = electricalFactory.getComputer();
        Phone phone = electricalFactory.getPhone();
        System.out.println(computer + "\n" + phone);

        electricalFactory = new HuaweiElectricalFactory();
        computer = electricalFactory.getComputer();
        phone = electricalFactory.getPhone();
        System.out.println(computer + "\n" + phone);
    }
}
