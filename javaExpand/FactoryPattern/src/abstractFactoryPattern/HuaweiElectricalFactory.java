package abstractFactoryPattern;

/**
 * 生产华为族产品的具体工厂类——华为工厂
 *
 * @author side.wang
 */
public class HuaweiElectricalFactory implements Electricalfactory {

    @Override
    public Computer getComputer() {
        return new Matebook();
    }

    @Override
    public Phone getPhone() {
        return new HuaweiP30();
    }

}
