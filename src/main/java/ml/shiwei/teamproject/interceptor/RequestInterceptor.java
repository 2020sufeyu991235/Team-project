package ml.shiwei.teamproject.interceptor;

import io.jsonwebtoken.Claims;
import ml.shiwei.teamproject.service.ResourceService;
import ml.shiwei.teamproject.service.TokenService;
import ml.shiwei.teamproject.utils.token.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: swl
 * @date: 2022/11/5
 * @description: 请求拦截器
 */
@Configuration
public class RequestInterceptor implements HandlerInterceptor {
    @Autowired
    TokenService tokenService;
    @Autowired
    ResourceService resourceService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //静态资源放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //读取Token
        String string=request.getHeader("token");
        //读取url
        String url= String.valueOf(request.getRequestURI());
        //为方便开发，暂保留拦截器输出内容
        //System.out.println("Request url:"+url);
        //用户id，默认为-1，表示未登录
        long userId=-1L;

        //存在Token
        if(string!=null&&!string.equals("")){
            if(tokenService.findAndDelete(string)){
                //解析Token，获取用户id
                Claims claims= JwtUtils.checkToken(string);
                //为什么是int，留个爪
                userId= (int) claims.get("id");
            }
        }
        //读取用户权限
        List<String> resourceList=resourceService.list(userId);
        /*System.out.println("Can be accessed:");
        resourceList.forEach(System.out::println);
        System.out.println("---------------------------");*/
        if(resourceList.contains(url)){
            return true;
        }
        //返回访问失败页面
        System.out.println("request error");
        response.sendError(403,"没有权限访问");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
