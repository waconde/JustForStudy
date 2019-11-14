package site.waconde.main;
import site.waconde.test.GetFilePath01;

public class GetFilePath {

    public static void main(String[] args) {
        GetFilePath getFIlePath = new GetFilePath();
        getFIlePath.printPath();
        GetFilePath01 getFilePath01 = new GetFilePath01();
        getFilePath01.printPath();
    }

    public void printPath() {
        // 获取到classes目录的全路径
        System.out.println(this.getClass().getClassLoader().getResource("").getPath());
        // 获取到classes目录下指定文件的全路径
        System.out.println(this.getClass().getClassLoader().getResource("site").getPath());
        // 获取到classes目录下指定文件的全路径
        System.out.println(this.getClass().getClassLoader().getResource("site/waconde/main/GetFilePath.class").getPath());
        // 得到的是当前类GetFIlePath.class文件的URI目录。不包括自己！
        System.out.println(GetFilePath.class.getResource(""));
        // 得到的是当前的classpath下指定文件的绝对URI路径。建议使用
        System.out.println(GetFilePath.class.getResource("/site"));
        // 得到的也是当前ClassPath的绝对URI路径。
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        // 得到的也是当前ClassPath的绝对URI路径。建议使用
        System.out.println(GetFilePath.class.getClassLoader().getResource(""));
        // 得到的也是当前ClassPath的绝对URI路径。
        System.out.println(ClassLoader.getSystemResource(""));
        // 在Web应用程序中，我们一般通过ServletContext.getRealPath("/")方法得到Web应用程序的根目录的绝对路径。
    }

}
