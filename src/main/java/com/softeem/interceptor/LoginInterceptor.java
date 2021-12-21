package com.softeem.interceptor;

import com.softeem.dto.EmployeeDTO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author muzi@softeem.com
 * @description 验证是否登录的拦截器
 * @since 2021/5/15 21:56
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("用户请求地址为:" + requestURI);
        Object o = request.getSession().getAttribute("userInfo");
        /**
         * 1.如果用户登录过了,那么如果用户还想请求login,就让他跳转至main
         * 2.所以还是要该拦截器去拦截/login,至于之前放行的情况,也在拦截器中去判断
         */
        if (o != null) {
            //如果从session中能获取到对应的信息
            EmployeeDTO userInfo = (EmployeeDTO) o;
            //空值判断
            if (userInfo.getEmId() != null && userInfo.getStatus() == 1) {
                if (requestURI.toLowerCase().indexOf("login") >= 0) {
                    response.sendRedirect("/main");
                    return false;
                }
                return true;
            }
        }

        if (requestURI.toLowerCase().indexOf("login") >= 0) {
            return true;
        }
        //让其跳转到登录页面
//        PrintWriter out = response.getWriter();
//        out.print("<html>");
//        out.print("<script>");
//        out.print("window.open('"+request.getContextPath()+"/login','_self)'");
//        out.print("</script>");
//        out.print("</html>");
        response.sendRedirect("/login");
        return false;
    }
}
