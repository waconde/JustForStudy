package enhancedBuilderModel;

/**
 * 具体建造者
 *
 * @author side.wang
 */
public class ConcreteBuilder extends AbstractBuilder {

    public ConcreteBuilder(String id, String name) {
        super(id, name);
    }

    @Override
    public AbstractBuilder buildPersonAge(byte age) {
        person.setAge(age);
        return this;
    }

    @Override
    public AbstractBuilder buildPersonGender(char gender) {
        person.setGender(gender);
        return this;
    }

    @Override
    public AbstractBuilder buildPersonStature(float stature) {
        person.setStature(stature);
        return this;
    }

    @Override
    public AbstractBuilder buildPersonWeight(float weight) {
        person.setWeight(weight);
        return this;
    }

    @Override
    public AbstractBuilder buildPersonNativePlace(String nativePlace) {
        person.setNativePlace(nativePlace);
        return this;
    }

    @Override
    public AbstractBuilder buildPersonNation(String nation) {
        person.setNation(nation);
        return this;
    }

}
