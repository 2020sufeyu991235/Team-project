package ml.shiwei.teamproject.controller;

import ml.shiwei.teamproject.utils.identicon.Result;
import ml.shiwei.teamproject.utils.identicon.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author: swl
 * @date: 2022/11/8
 * @description: 实现ErrorController接口，指定自定义错误提示页面
 */
@Controller
public class ErrorPageController extends BasicErrorController {
    Logger logger= LoggerFactory.getLogger(ErrorPageController.class);

    @Autowired
    public ErrorPageController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }

    //返回错误提示页面
    @Override
    public ModelAndView errorHtml(HttpServletRequest request,HttpServletResponse response){
        int code=response.getStatus();
        if(403==code){
            return new ModelAndView("error/403");
        }
        //System.out.println("errorHtml()");
        return null;
    }

    /*public ResponseEntity<Map<String,Object>> error(HttpServletRequest request){

    }*/

}
