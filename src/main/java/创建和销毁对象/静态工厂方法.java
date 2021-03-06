package 创建和销毁对象;

public class 静态工厂方法{
    public static void main(String[] args){
        Person p1 = Person.getInstance();
        Person.Cooker p2 = Person.getCooker();
        Person p3 = Person.getPersonWithAge("12");
        Person p4 = Person.getPersonWithName("小明");
        FamilyMember familyMember1 = FamilyMember.getMother();
        FamilyMember familyMember2 = FamilyMember.getFather();
        FamilyMember familyMember3 = FamilyMember.getSon();
        if (familyMember1.type == FamilyMember.MOTHER){
            System.out.println("这是位母亲");
        }
    }
}
class Person {
    private String name;
    private String age;
    //1、静态工厂方法与构造器不同的第一优势在于，它们有名字
    public static Person getPerson(){
        return new Person();
    }
    //2、第二个优势，不用每次被调用时都创建新对象（例子为懒汉写法）
    private static volatile Person instance;
    public static Person getInstance(){
        if (instance == null){
            synchronized (Person.class){
                if (instance == null){
                    instance = new Person();
                }
            }
        }
        return instance;
    }
    //3、第三个优势，可以返回原返回类型的子类
    static class Cooker extends Person{}
    static Cooker getCooker(){
        return new Cooker();
    }
    //4、可以有多个参数相同但名称不同的工厂方法
    public static Person getPersonWithAge(String age){
        Person person = new Person();
        person.age = age;
        return person;
    }
    public static Person getPersonWithName(String name){
        Person person = new Person();
        person.name = name;
        return person;
    }
    //5、多了一层控制，方便统一修改
    public static Person getTestInstance(){
        Person person = new Person();
        person.name = "测试名";
        person.age = "13";
        return person;
    }
}

//6、可以减少对外暴露的属性
class FamilyMember{
    public static final int MOTHER = 1;
    public static final int FATHER = 2;
    public static final int SON = 3;
    int type;
    private FamilyMember(int type){
        this.type = type;
    }
    public static FamilyMember getMother(){
        return new FamilyMember(MOTHER);
    }
    public static FamilyMember getFather(){
        return new FamilyMember(FATHER);
    }
    public static FamilyMember getSon(){
        return new FamilyMember(SON);
    }

    public int getType() {
        return type;
    }
}
