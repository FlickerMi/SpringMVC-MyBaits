package cn.notemi.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Title：CustomExceptionResolver
 * Description：针对 CustomException 异常的全局异常处理器
 *
 * @author Flicker
 * @create 2017-01-23 下午 9:31
 **/
public class GlobalUserExceptionResolver implements HandlerExceptionResolver {
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex 系统抛出的异常
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {

        String message;
        // 如果是自定义异常，给出具体的异常信息
        if (ex instanceof CustomException) {
            message = ex.getMessage();
        } else {
            message = "服务器未知错误";
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error_message", message);
        modelAndView.setViewName("user/error");
        return modelAndView;
    }
}
