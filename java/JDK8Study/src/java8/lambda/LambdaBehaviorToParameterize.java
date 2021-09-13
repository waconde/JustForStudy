package java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambda表达式行为参数化体验
 * 行为参数化使得那些大体相同的业务逻辑能复用同一段代码，从而缩减代码量。
 * 只需要将它们其中不同的小部分代码使用lambda表达式的形式传递并替换即可。
 *
 * @author side.wang
 * @since 2019年8月28日
 */
public class LambdaBehaviorToParameterize {
    public static void main(String[] args) {
        LambdaBehaviorToParameterize lambdaExample = new LambdaBehaviorToParameterize();
        List<Student> studentList = lambdaExample.createStudents();
        Scanner input = new Scanner(System.in);
        System.out.println("分别输入功能号（1:> 2:<）和年龄阈值：");
        int functionNumber = input.nextInt();
        int condition = input.nextInt();
        input.close();
        List<Student> result = lambdaExample.compare(studentList, lambdaExample.getCondition(functionNumber, condition));
        result.forEach(System.out::println);
        System.out.println();
        // 查询年龄最大值
        Optional<Student> theMaxAge = studentList.stream().max(Comparator.comparingInt(Student::getAge));
        System.out.println(theMaxAge);
    }

    protected List<Student> createStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("黄芪", Gender.FEMALE, 21, 89.65F));
        students.add(new Student("红兵", Gender.MALE, 24, 80.73F));
        students.add(new Student("海珠", Gender.FEMALE, 23, 85.61F));
        students.add(new Student("明哲", Gender.MALE, 20, 75.30F));
        return students;
    }

    /**
     * 根据传入的lambda表达式来实现不同的筛选行为
     *
     * @param studentList student数据源
     * @param predicate   lambda表达式
     * @return List<Student> 筛选结果
     * @author side.wang
     * @since 2019年8月28日
     */
    protected List<Student> compare(List<Student> studentList, Predicate<Student> predicate) {
        List<Student> resultList = new ArrayList<Student>();
		for (Student student : studentList) {if (predicate.test(student)) {resultList.add(student);}}
        return resultList;
    }

    /**
     * 选择要做的行为，并自定义行为的范围
     * 这里有“1、年龄下限筛选；2、年龄上限筛选”可选。不选则默认返回原数据源
     *
     * @param functionNumber 功能号
     * @param condition      年龄上/下限
     * @return Predicate<Student> lambda表达式实现的断言型接口
     * @author side.wang
     * @since 2019年8月28日
     */
    protected Predicate<Student> getCondition(Integer functionNumber, Integer condition) {
        switch (functionNumber) {
            case 1:
                return stu -> stu.getAge() > condition;
            case 2:
                return stu -> stu.getAge() >= 0 && stu.getAge() < condition;
            default:
                return stu -> true;
        }
    }

    protected enum Gender {
        MALE("男"), FEMALE("女");
        private String value;

        private Gender(String value) {
            this.value = value;
        }

        protected String getValue() {
            return value;
        }
    }

    protected class Student {
        private String name;
        private Gender gender;
        private Integer age;
        private Float grade;

        protected Student(String name, Gender gender, Integer age, Float grade) {
            super();
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Float getGrade() {
            return grade;
        }

        public void setGrade(Float grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", gender=" + gender + ", age=" + age + ", grade=" + grade + "]";
        }

    }

}
