package 注解技术;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class Basic {
    public static void main(String args[]) {
        //构建一个 Java 文件
//        JavaFile.builder("com.czx.javapoeat", //包名
//                TypeSpec.classBuilder("Clazz")   //类
//                        .addField(FieldSpec.builder().build())               //属性
//                        .addMethod(MethodSpec.constructorBuilder().build())              //方法
//                        .build()).build();
        //
    }
}

/**
 * 一个简单的 Java 文件结构:包名、类、属性、方法
 */
class Clazz {
    private int mField;

    public void menthod(String str) {
        System.out.println(str);
    }
}
