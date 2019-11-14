package javaBeanModel;

public class Person {
    // 必要属性。请注意javabean模式中无法使用final修饰符
    private String id;
    private String name;
    // 可选属性
    private byte age;
    private char gender;
    private float stature;
    private float weight;
    private String nativePlace;
    private String nation;

    // 无参构造函数
    public Person() {
        super();
    }

    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setStature(float stature) {
        this.stature = stature;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
