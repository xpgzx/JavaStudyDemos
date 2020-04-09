package exceptions;

/**
 * @Describe: 主要用来测试自定义异常
 * @Author: Gezx
 * @Date: 2020/3/31 23:26
 */
public class ExceptionTest2 {
    static int quotient(int x, int y) throws MyException { // 定义方法抛出异常
        if (y < 0) { // 判断参数是否小于0
            throw new MyException("除数不能是负数"); // 异常信息
        }
        return x/y; // 返回值
    }
    public static void main(String args[]) { // 主方法
        int  a =3;
        int  b =0;
        try { // try语句包含可能发生异常的语句
            int result = quotient(a, b); // 调用方法quotient()
        } catch (MyException e) { // 处理自定义异常
            System.out.println(e.getMessage()); // 输出异常信息
        } catch (ArithmeticException e) { // 处理ArithmeticException异常
            System.out.println("除数不能为0"); // 输出提示信息
        } catch (Exception e) { // 处理其他异常
            System.out.println("程序发生了其他的异常"); // 输出提示信息
        }
    }

    /**
     * 下面两个方法结合起来看：测试关于finally语句块的一个知识点
     */

}
