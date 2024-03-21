package org.example.yourapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.yourapp.controller.BoardController;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//http://localhost:8080/*.do
/*
분기요청을 할 수 있다.
톰캣이 요청을 받고 응답을 보낸다.
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {

    private String getAction(String uri) {
        return uri.split("\\.")[0];
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request.getRequestURI());
        BoardController bc = new BoardController();

        Method[] methods = bc.getClass().getDeclaredMethods();//어노테이션이 달린 애들만 찾는다.

        for (Method mt : methods) {
            //어노테이션을 찾는다.
            Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
            RequestMapping rm = (RequestMapping) anno;
            if (rm.value().equals(action)) {
                try {
                    String result = (String) mt.invoke(bc);
                    response.getWriter().println(result);
                    break;//컨트롤러를 찾으면 빠져나온다.
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

//        String result;
//        switch (action) {
//            case "save":
//                result = bc.save();
//                response.getWriter().println(result);
//                break;
//            case "findAll":
//                result = bc.findAll();
//                response.getWriter().println(result);
//                break;
//            default:
//                response.getWriter().println("4040 Not Found");
//
//        }
    }
}
