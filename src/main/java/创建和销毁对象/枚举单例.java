package 创建和销毁对象;

//优点：代码简洁，绝对单列
//缺点：不能被继承
public enum 枚举单例 {
    INSTANCE;

    public String toString() {
        return "用枚举创建单例";
    }

    public static void main(String[] args) {
        System.out.println(枚举单例.INSTANCE.toString());
    }
}
