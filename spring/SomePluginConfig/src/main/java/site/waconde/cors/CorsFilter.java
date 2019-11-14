package site.waconde.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cors拦截器配置
 * 创建cors拦截器，并在filter中启用
 *
 * @author side.wang
 * @since 2019年10月29日
 */
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String origin = ((HttpServletRequest) request).getHeader("Origin");
        if(origin==null || "".equals(origin)){
            origin = "*";
        }
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Allow-Origin", origin);
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, PATCH");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers",
            "Access-Control-Allow-Origin,Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        res.setCharacterEncoding("utf-8");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("XDomainRequestAllowed", "1");
        chain.doFilter(request, res);
    }

    @Override
    public void destroy() {

    }
}
