package enhancedBuilderModel;

/**
 * 抽象建造者
 * @author side.wang
 *
 */
public abstract class AbstractBuilder {
    protected Person person = new Person();
    
    // 必选属性的赋值
    public AbstractBuilder(String id, String name) {
        person.setId(id);
        person.setName(name);
    }
    
    // 可选属性的赋值
    public abstract AbstractBuilder buildPersonAge(byte age);
    public abstract AbstractBuilder buildPersonGender(char gender);
    public abstract AbstractBuilder buildPersonStature(float stature);
    public abstract AbstractBuilder buildPersonWeight(float weight);
    public abstract AbstractBuilder buildPersonNativePlace(String nativePlace);
    public abstract AbstractBuilder buildPersonNation(String nation);
    
    // 产品对象的获取方法
    public Person getPerson() {
        return person;
    }

}
