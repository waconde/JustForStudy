package normal;

public class Person {
    // 必要属性
    private final String id;
    private final String name;
    // 可选属性
    private byte age;
    private char gender;
    private float stature;
    private float weight;
    private String nativePlace;
    private String nation;

    // 包含所有属性的构造器
    public Person(String id, String name, byte age, char gender, float stature, float weight, String nativePlace,
        String nation) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.stature = stature;
        this.weight = weight;
        this.nativePlace = nativePlace;
        this.nation = nation;
    }

    // 下面为去掉某些可选属性的构造器
    public Person(String id, String name, byte age, char gender, float stature, float weight, String nativePlace) {
        this(id, name, age, gender, stature, weight, nativePlace, null);
    }

    public Person(String id, String name, byte age, char gender, float stature, float weight) {
        this(id, name, age, gender, stature, weight, null);
    }

    public Person(String id, String name, byte age, char gender) {
        this(id, name, age, gender, 0, 0);
    }

    public Person(String id, String name, byte age) {
        this(id, name, age, '男');
    }

    public Person(String id, String name) {
        this(id, name, (byte)0);
    }
}
