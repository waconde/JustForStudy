package java8.lambda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * lambda表达式语法
 * lambda表达式本质上是为函数式接口提供了一个匿名实现类。我们要做的是确定该匿名类中唯一需要重写的方法的参数以及方法体（含返回值？）。
 * 这也是必须由我们自主控制的，其他的结构性语句则可省略掉。提高代码简洁渡。
 * 而lambda表达式的强大之处不仅是简化代码，更在于能将自己（行为参数化）作为参数传递。
 * 参数 -> 方法体（含返回值？）
 *
 * @author side.wang
 * @since 2019年8月28日
 */
public class LambdaBaseGrammar {
    public static void main(String[] args) {
        LambdaBaseGrammar lambdaStudy = new LambdaBaseGrammar();
        // 无参数无返回值
        lambdaStudy.withoutParamAndReturn();
        // 单参数有返回值
        lambdaStudy.oneParamAndReturn(new Date());
        // 多参数有返回值
        lambdaStudy.manyParamsAndReturn(new Date(), new Date(), new Date());
    }

    /**
     * 1、无参数无返回值
     * () -> { Code blocks }
     *
     * @author side.wang
     * @since 2019年8月28日
     */
    protected void withoutParamAndReturn() {
        PrintLog printLog1 = new PrintLog() {
            @Override
            public void out() {
                System.out.println("匿名类继承接口重写抽象方法");
            }
        };
        printLog1.out();

        PrintLog printLog2 = () -> System.out.println("无参无返回值lambda表达式\n");
        printLog2.out();
    }

    /**
     * 2、单参数有返回值
     * Interface instance = (param) -> { Code blocks }
     *
     * @param message 任意类型消息内容
     * @author side.wang
     * @since 2019年8月28日
     */
    protected void oneParamAndReturn(Object message) {
        Message<Object, String> message1 = new Message<Object, String>() {
            @Override
            public String showMessage(Object r) {
                return String.valueOf(r);
            }
        };
        System.out.println("匿名类继承接口重写抽象方法：" + message1.showMessage(message));

        Message<Object, String> message2 = messageContext -> {return String.valueOf(messageContext);};
        System.out.println("单参数有返回值lambda表达式：" + message2.showMessage(message) + "\n");
    }

    /**
     * 3、多参数有返回值
     * Interface instance = (param1, param2, ... ) -> { Code blocks }
     *
     * @param paramList 参数列表
     * @author side.wang
     * @since 2019年8月28日
     */
    protected void manyParamsAndReturn(Object param1, Object param2, Object param3) {
        PrintParamList<Object, String> printParamList1 = new PrintParamList<Object, String>() {
            @Override
            public List<String> showParamsContext(Object obj1, Object obj2, Object obj3) {
                List<Object> params = new ArrayList<Object>();
                params.add(obj1);
                params.add(obj2);
                params.add(obj3);
                List<String> paramContexts = new ArrayList<String>();
				for (Object object : params) {paramContexts.add(String.valueOf(object));}
                return paramContexts;
            }
        };
        System.out.println("匿名类继承接口重写抽象方法：");
        printParamList1.showParamsContext(param1, param2, param3).forEach(System.out::println);
        // 上一行的原版：printParamList1.showParamsContext(param1, param2, param3).forEach(str -> System.out.println(str));
        // 上一行的原版：for ( String str : printParamList1.showParamsContext(param1, param2, param3)) System.out.println(str);

        PrintParamList<Object, String> printParamList2 = (p1, p2, p3) -> {
            List<Object> params = new ArrayList<Object>();
            params.add(p1);
            params.add(p2);
            params.add(p3);
            List<String> paramContexts = new ArrayList<String>();
			for (Object object : params) {paramContexts.add(String.valueOf(object));}
            return paramContexts;
        };
        System.out.println("多参数有返回值lambda表达式：");
        printParamList2.showParamsContext(param1, param2, param3).forEach(System.out::println);
        System.out.println();
    }

    /**
     * 函数式接口：无参无返回值
     *
     * @author side.wang
     * @since 2019年8月28日
     */
    @FunctionalInterface
    protected interface PrintLog {
        void out();
    }

    /**
     * 函数式接口：单参数有返回值
     *
     * @param <P> 参数类型
     * @param <R> 返回值类型
     * @author side.wang
     * @since 2019年8月28日
     */
    @FunctionalInterface
    protected interface Message<P, R> {
        R showMessage(P r);
    }

    /**
     * 函数式接口：多参数有返回值
     *
     * @param <P> 参数类型
     * @param <R> 返回值类型
     * @author side.wang
     * @since 2019年8月28日
     */
    @FunctionalInterface
    protected interface PrintParamList<P, R> {
        List<R> showParamsContext(P p1, P p2, P p3);
    }
}
