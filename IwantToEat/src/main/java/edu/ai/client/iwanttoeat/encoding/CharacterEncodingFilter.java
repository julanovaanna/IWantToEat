package edu.ai.client.iwanttoeat.encoding;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: anna
 * Date: 15.02.12
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public class CharacterEncodingFilter implements Filter, Serializable
{
    private static final long serialVersionUID = -4246457499875267088L;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
