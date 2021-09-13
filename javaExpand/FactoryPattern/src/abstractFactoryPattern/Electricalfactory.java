package abstractFactoryPattern;

/**
 * 生产同族产品的抽象工厂类
 *
 * @author side.wang
 */
public interface Electricalfactory {
    Computer getComputer();

    Phone getPhone();
}
