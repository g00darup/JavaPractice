package hackerrank.IntPrepKit.java.advanced.reflection;
;
import com.cs.inheritance.Student;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution0 {

    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getMethods();

        List<String> methodList;
        methodList = Arrays.stream(methods).toList().stream().map(method -> method.getName()).collect(Collectors.toList());
        Collections.sort(methodList);
        methodList.stream().forEach(System.out::println);

    }

}

