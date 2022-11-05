package ml.shiwei.teamproject.interceptor;

import ml.shiwei.teamproject.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: swl
 * @date: 2022/11/5
 * @description: 请求拦截器
 */
public class RequestInterceptor implements HandlerInterceptor {
    @Autowired
    TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String string=request.getHeader("token");
        if(string!=null&&!string.equals("")){
            if(tokenService.findAndDelete(string)){
                return true;
            }
        }
        return true;
    }
}
