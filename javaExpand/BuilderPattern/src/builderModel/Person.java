package builderModel;

public class Person {
    // 必要属性
    private final String id;
    private final String name;
    // 可选属性
    private final byte age;
    private final char gender;
    private final float stature;
    private final float weight;
    private final String nativePlace;
    private final String nation;

    // 使用builder对象为属性赋值
    public Person(Builder builder) {
        super();
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.stature = builder.stature;
        this.weight = builder.weight;
        this.nativePlace = builder.nativePlace;
        this.nation = builder.nation;
    }

    public static void main(String[] args) {
        Person person = new Person.Builder("id", "name").age((byte) 0).gender('男').nation("汉").build();
    }

    // 内部构建器builder类
    public static class Builder {
        // 构建器中属性与外部类相同，因为外部类构造器（静态工厂方法）还需要使用构建器来为属性赋值。
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

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder age(byte age) {
            this.age = age;
            return this;
        }

        public Builder gender(char gender) {
            this.gender = gender;
            return this;
        }

        public Builder stature(float stature) {
            this.stature = stature;
            return this;
        }

        public Builder weight(float weight) {
            this.weight = weight;
            return this;
        }

        public Builder nativePlace(String nativePlace) {
            this.nativePlace = nativePlace;
            return this;
        }

        public Builder nation(String nation) {
            this.nation = nation;
            return this;
        }

        // 使用builder对象构造外部类对象。
        public Person build() {
            return new Person(this);
        }
    }
}
