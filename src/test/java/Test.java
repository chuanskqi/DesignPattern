import com.google.gson.Gson;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Gson g = new Gson();
        String s = g.toJson(get());

        Object[] objects = null;
        if (objects == null || lt(objects)) {

        }

        School school = g.fromJson(s, School.class);
        List<Student> list = school.getList();
        for (Student st : list) {
            System.out.println(g.toJson(st));
        }
    }
    public static boolean lt(Object[] objects) {
        return objects.length<=0;
    }

    public static School get() {
        Student s = new Student();
        s.setName("branch1");
        s.setAge("123");
        List<Student> list = new ArrayList<>();
        list.add(s);
        School school = new School();
        school.setList(list);
        return school;
    }
}



@Data
class School {
    private List<Student> list;
}
@Data
class Student {
    private String name;
    private String age;
}
