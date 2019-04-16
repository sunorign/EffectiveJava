package 创建和销毁对象.工具类无实例;

//缺点：无法被继承
public class MathUtil {
    private MathUtil(){
        throw new AssertionError("MathUtil not allowed instantiation");
    }
    public static int plus(int a,int b){
        return a+b;
    }
}
