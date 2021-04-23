package argorithm.map;

import com.google.common.hash.BloomFilter;
import org.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

interface B<T> {

}
class C {}
abstract class A<T> implements B<T>{
    public static void main(String[] args) {
        A a = new A<C>(){};

        System.out.println("ClassUtils.getUserClass(a) :" + ClassUtils.getUserClass(a) );
        System.out.println("a.getClass().getName() :" + a.getClass().getGenericSuperclass());
        Type types = ClassUtils.getUserClass(a).getGenericSuperclass();
        System.out.println("==> type:" + types);

        Arrays.asList(types).forEach(type -> {
                System.out.println("getTypeName:" + type.getTypeName());
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println("parameterizedType：" + parameterizedType.getActualTypeArguments()[0].getTypeName());
                }
        );
        System.out.println("<==");
//        ParameterizedType parameterizedType = (ParameterizedType) type;
//        System.out.println("==> parameterizedType");
//        System.out.println(parameterizedType.getRawType());
//        System.out.println("<==");


    }
}
public class BitMap { // Java中char类型占16bit，也即是2个字节
    private char[] chars;
    private int bitSize;

    public BitMap(int size) {
        this.bitSize = size;
        this.chars = new char[size/16 + 1];
    }


    public void set(int num) {
        if(bitSize < num) {
            return;
        }
        int charIndex = num / 16;
        int bitIndex = num % 16;
        chars[charIndex] |= (1 << bitIndex);
    }

    public boolean get(int num) {
        int charIndex = num / 16;
        int bitIndex = num % 16;
        return (chars[charIndex] & (1 << bitIndex)) != 0;
    }
}