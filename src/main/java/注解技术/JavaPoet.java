package 注解技术;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;


public class JavaPoet {
    public static void main(String[] args) {
        /*
        构建一个 Java 文件
         */
        // `JavaFile` 代表 Java 文件
        JavaFile javaFile = JavaFile.builder("注解技术.java_poet",
                // TypeSpec 代表一个类
                TypeSpec.classBuilder("Clazz").addModifiers(Modifier.PUBLIC)
                        // 给类添加一个属性
                        .addField(FieldSpec.builder(TypeName.INT, "mField", Modifier.PRIVATE).build())
                        // 给类添加一个方法
                        .addMethod(MethodSpec.methodBuilder("menthod")
                                .addModifiers(Modifier.PUBLIC)
                                .returns(void.class)
                                .addParameter(ParameterSpec.builder(TypeName.OBJECT, "str").build())
                                .addStatement("System.out.println(str)")
                                .build())
                        .build())
                .build();
        System.out.println(javaFile.toString());
    }
}

/**
 * 一个简单的 Java 文件结构:包名、类、属性、方法
 */
class Person {
    private int mField;

    public void menthod(String str) {
        System.out.println(str);
    }
}
