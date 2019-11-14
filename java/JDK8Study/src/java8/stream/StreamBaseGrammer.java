package java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 练习Stream聚合操作
 * 
 *
 * @author side.wang
 * @since 2019年9月2日
 */
public class StreamBaseGrammer {
	protected volatile List<Student> stuList = new ArrayList<Student>();
	
	protected class Student{
		private String name;
		private Integer age;
		private Boolean isDelete;
		
		protected Student(String name, Integer age, Boolean isDelete) {
			super();
			this.name = name;
			this.age = age;
			this.isDelete = isDelete;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Boolean getIsDelete() {
			return isDelete;
		}

		public void setIsDelete(Boolean isDelete) {
			this.isDelete = isDelete;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", isDelete=" + isDelete + "]";
		}
	}
	
	protected void productStudents() {
		for (int i = 0; i < 10; i++)
			stuList.add(new Student(String.valueOf((char)(Math.random()*26+98)), (int)(Math.random()*10+10), Math.random() > 0.5 ? true : false));
		stuList.forEach(System.out::println);
	}
	
	protected void toLinkedHashSet() {
		stuList.stream().collect(Collectors.toCollection(LinkedHashSet::new)).forEach(System.out::println);
	}
	
	protected void toMap() {
		stuList.stream().collect(Collectors.toMap(student -> student, Student::getName));
	}
	
	protected void sorted() {
		stuList.stream().sorted((student1, student2) -> student1.getAge().compareTo(student2.getAge())).forEach(System.out::println);
	}
	
	protected void getMax() {
		Optional<Student> theMaxOne = stuList.stream().max((student1, student2) -> student1.getAge().compareTo(student2.getAge()));
		System.out.println(theMaxOne);
	}
	
	protected void peek() {
		stuList.stream().peek(student -> student.setAge(student.getAge() + 10)).forEach(System.out::println);;
	}
	
	protected void filter() {
		stuList.stream().filter(student -> student.getAge() > 25).forEach(System.out::println);
	}
	
	protected void concat() {
		Stream.concat(stuList.stream().filter(student -> student.getAge() % 2 == 0), stuList.stream().filter(student -> student.getAge() % 2 != 0)).forEach(System.out::println);;
	}
	
	public static void main(String[] args) {
		StreamBaseGrammer streamBaseGrammer = new StreamBaseGrammer();
		System.out.println("productStudents====================");
		streamBaseGrammer.productStudents();
		System.out.println("toTreeSet====================");
		streamBaseGrammer.toLinkedHashSet();
		System.out.println("toMap====================");
		streamBaseGrammer.toMap();
		System.out.println("sorted====================");
		streamBaseGrammer.sorted();
		System.out.println("getMax====================");
		streamBaseGrammer.getMax();
		System.out.println("peek====================");
		streamBaseGrammer.peek();
		System.out.println("filter====================");
		streamBaseGrammer.filter();
		System.out.println("concat====================");
		streamBaseGrammer.concat();
	}
}
