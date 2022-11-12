package ml.shiwei.teamproject.config;

import ml.shiwei.teamproject.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: swl
 * @date: 2022/10/16
 * @description: 把自己自定义的配置加载到系统的默认配置中
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("访问的路径").addResourceLocations("资源的路径");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        String filepath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\postimg\\";
        registry.addResourceHandler("/postimg/")
                .addResourceLocations(filepath.replace("\\","/"));
    }

    //手动注入拦截器
    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return new RequestInterceptor();
    }
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getRequestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/resource/list")
                .excludePathPatterns("/error/**")
                .excludePathPatterns("/post/list");
    }
}