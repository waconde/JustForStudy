package site.waconde.test;

import site.waconde.main.GetFilePath;

/**
 * 从其他路径测试
 * @author side.wang
 *
 */
public class GetFilePath01 {

    public void printPath() {
        // 获取到classes目录的全路径
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
        // 获取到classes目录下指定文件的全路径
        System.out.println(this.getClass().getClassLoader().getResource("site").getPath());
        // 获取到classes目录下指定文件的全路径
        System.out.println(this.getClass().getClassLoader().getResource("site/waconde/test/GetFilePath01.class").getPath());
        // 得到的是当前类GetFIlePath.class文件的URI目录。不包括自己！
        System.out.println(GetFilePath.class.getResource(""));
        // 得到的是当前的classpath下指定文件的绝对URI路径。建议使用
        System.out.println(GetFilePath.class.getResource("/site"));
        // 得到的也是当前ClassPath的绝对URI路径。
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        // 得到的也是当前ClassPath的绝对URI路径。
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("site"));
        // 得到的也是当前ClassPath的绝对URI路径。建议使用
        System.out.println(GetFilePath01.class.getClassLoader().getResource(""));
        // 得到的也是当前ClassPath的绝对URI路径。建议使用
        System.out.println(GetFilePath01.class.getClassLoader().getResource("site"));
        // 得到的也是当前ClassPath的绝对URI路径。
        System.out.println(ClassLoader.getSystemResource(""));
        // 得到的也是当前ClassPath的绝对URI路径。
        System.out.println(ClassLoader.getSystemResource("site"));
        // 在Web应用程序中，我们一般通过ServletContext.getRealPath("/")方法得到Web应用程序的根目录的绝对路径。
    }

}
