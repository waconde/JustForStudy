package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import privateConstructor.SingletonModel1;

public class TestForRef {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingletonModel1 singletonModel1 = SingletonModel1.getInstance();
		System.out.println(singletonModel1);
		
		Constructor<SingletonModel1> constructor = SingletonModel1.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		SingletonModel1 ref = constructor.newInstance();
		System.out.println(ref);
	}
}
