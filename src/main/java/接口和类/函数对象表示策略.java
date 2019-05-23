package 接口和类;

public class 函数对象表示策略 {
    public static void main(String[] args) {
        LambdaPrint lambdaPrint = System.out::println;  //函数具体的实现
        lambdaPrint.print("lambdaPrintln");
        LambdaPlus lambdaPlus = (a, b) -> System.out.println(a + b);
        lambdaPlus.plus(1, 2);
    }

    //函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口，函数式接口可以被隐式转换为 lambda 表达式
    interface LambdaPrint {
        void print(String str);
    }

    interface LambdaPlus {
        void plus(int a, int b);
    }
}
