package ex02;

import ex02.RequsetMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        String path = "/update";


        UserController con = new UserController();

        Method[] methods = con.getClass().getDeclaredMethods();
        //System.out.println(methods.length);

        for (Method method : methods) {
            //System.out.println(method.getName());
            RequsetMapping rm = method.getDeclaredAnnotation(RequsetMapping.class);

            if (rm == null)continue;

            if (rm.uri().equals(path)) {
                try {
                    method.invoke(con);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
