package 创建和销毁对象;

import java.util.Arrays;
import java.util.EmptyStackException;

public class 过期对象要消除 {
    //如果一个栈先是增长，然后再收缩，那从栈中弹出的对象将不会当作垃圾回收(如果不处理)
    public static void main(String[] args) {
        StrStack strStack = StrStack.INSTANCE;
        strStack.push("1");
        strStack.push("2");
        System.out.println(strStack.pop());
        System.out.println(strStack.pop());
    }
}

//如果自己管理内存，就要警惕内存泄漏问题
enum StrStack {
    INSTANCE;
    private String[] strs = new String[2];
    private int size = 0;

    void push(String str) {
        ensureCapacity();
        strs[size++] = str;
    }

    String pop() {
        if (size == 0)
            throw new EmptyStackException();
        String str = strs[--size];
        //一旦数组元素变成非活动的一部分，程序员就手工清除这些数组元素
        strs[size] = null;
        return str;
    }

    private void ensureCapacity() {
        if (size == strs.length) {
            //Arrays.copyOf(T[] original, int newLength) 传回的数组是新的数组对象,第二个自变量指定要建立的新数组长度
            strs = Arrays.copyOf(strs, 2 * size + 1);
        }
    }
    //清空对象引用不是规范处理方式，最好让包含该引用的变量结束其生命周期
}
//2.另外一个常见的内存泄漏来自缓存。用 WeakHashMap 代表缓存，缓存项过期就会自动删除（缓存周期由外部引用决定而不是其值决定时才有用处）


//3.监听器和其他回调也会发生内存泄漏，可将回调保存成 WeakHashMap 中的键