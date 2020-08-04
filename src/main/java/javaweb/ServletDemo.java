package javaweb;

import javax.servlet.*;
import java.io.IOException;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2020/6/18
 */
public class ServletDemo implements Servlet {

    ServletConfig  servletConfig = null;

    @Override
    public ServletConfig getServletConfig() {
        servletConfig.getServletContext();
        System.out.println("ServletConfig");
        return null;
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        servletConfig = servletConfig;
         System.out.println("init");
    }



    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
