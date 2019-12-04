package enhancedBuilderModel;

/**
 * 产品对象
 * @author side.wang
 *
 */
public class Person {
    // 必要属性
    private String id;
    private String name;
    // 可选属性
    private byte age;
    private char gender;
    private float stature;
    private float weight;
    private String nativePlace;
    private String nation;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public byte getAge() {
        return age;
    }
    
    public void setAge(byte age) {
        this.age = age;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public float getStature() {
        return stature;
    }
    
    public void setStature(float stature) {
        this.stature = stature;
    }
    
    public float getWeight() {
        return weight;
    }
    
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public String getNativePlace() {
        return nativePlace;
    }
    
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }
    
    public String getNation() {
        return nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", stature=" + stature
            + ", weight=" + weight + ", nativePlace=" + nativePlace + ", nation=" + nation + "]";
    }
    
}
