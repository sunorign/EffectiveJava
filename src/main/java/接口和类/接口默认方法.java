package 接口和类;

/**
 * 接口默认方法：在接口中实现的方法，可以直接调用
 */
public class 接口默认方法 {
    public static void main(String[] args) {
        new InterfaceB() {}.foo(); // 打印：“InterfaceA foo”
        new InterfaceC() {}.foo(); // 打印：“InterfaceC foo”
        new InterfaceD() {
            @Override
            public void foo() {
                System.out.println("InterfaceD foo");
            }
        }.foo(); // 打印：“InterfaceD foo”

        // 或者使用 lambda 表达式
        ((InterfaceD) () -> System.out.println("InterfaceD foo")).foo();
    }
}
interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}

//继承InterfaceA 的默认方法
interface InterfaceB extends InterfaceA {
}
//覆写InterfaceA的默认方法
interface InterfaceC extends InterfaceA {
    @Override
    default void foo() {
        System.out.println("InterfaceC foo");
    }
}
//实现类中实现默认方法
interface InterfaceD extends InterfaceA {
    @Override
    void foo();
}