package 创建和销毁对象;

public class 工具类无实例 {
    public static void main(String[] args) {
        try {
            Class<?> mathUtilClass = Class.forName("创建和销毁对象.MathUtil");
            MathUtil mathUtil = (MathUtil) mathUtilClass.newInstance();
            System.out.println(mathUtil.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//缺点：无法被继承
class MathUtil {
    private MathUtil() {
        throw new AssertionError("工具类无实例 not allowed instantiation");
    }

    public static int plus(int a, int b) { return a + b; }

    @Override
    public String toString() {
        return "is MathUtil";
    }
}
