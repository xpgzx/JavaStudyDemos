package exceptions;
/**
 * @Describe: Java异常机制测试主类
 * @Author: Gezx
 * @Date: 2020/3/30 22:20
 */
public class ExceptionTest {

    public ExceptionTest(){}

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1(){
        boolean ret = true;
        try {
            ret = testEx2();
            if(!ret){
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        }catch (Exception e){
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        }finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception{
        boolean ret = true;
        try{
            int b= 12;
            int c;
            for(int i = 2;i >= -2;i--){
                c = b / i;
                System.out.println("i = " + i);
            }
            return true;
        }catch (Exception e){
            System.out.println("testEx2, catch Exception");
            ret = false;
            throw e;
        }finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        try {
            exceptionTest.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}