package enhancedBuilderModel;

public class Invoker {
    
    public static void main(String[] args) {
        AbstractBuilder abstractBuilder = new ConcreteBuilder("1", "青青橙");
        Person person = abstractBuilder.buildPersonAge((byte)24).buildPersonGender('男').buildPersonNation("汉")
                        .buildPersonNativePlace("挪威").buildPersonStature(187).buildPersonWeight(59).getPerson();
        System.out.println(person);
        
        abstractBuilder = new ConcreteBuilder("2", "青青橙2");
        Person person2 = abstractBuilder.buildPersonAge((byte)100).getPerson();
        System.out.println(person2);
    }
}
