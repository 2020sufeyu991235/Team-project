package ml.shiwei.teamproject.config;

import org.springframework.context.annotation.Configuration;
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
        registry.addResourceHandler("begin.html")
                .addResourceLocations("classpath:/static/");
    }
}

