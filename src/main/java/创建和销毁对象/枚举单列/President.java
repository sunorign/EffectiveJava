package 创建和销毁对象.枚举单列;

//优点：代码简洁，绝对单列
//缺点：不能被继承
public enum  President {
    INSTANCE;
    public void speech(){
        System.out.println("演讲");
    }
}
