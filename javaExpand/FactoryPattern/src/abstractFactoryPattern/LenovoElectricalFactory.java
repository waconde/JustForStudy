package abstractFactoryPattern;

/**
 * 生产联想族产品的具体工厂类——联想工厂
 *
 * @author side.wang
 */
public class LenovoElectricalFactory implements Electricalfactory {

    @Override
    public Computer getComputer() {
        return new Thinkpad();
    }

    @Override
    public Phone getPhone() {
        return new LenovoZ6();
    }

}
