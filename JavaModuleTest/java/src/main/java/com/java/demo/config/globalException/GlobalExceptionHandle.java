package com.java.demo.config.globalException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 *
 * @author Tellsea
 * @date 2019/7/13
 */
@Slf4j
@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    public void exception(Exception e, Model model) {
        model.addAttribute("code", e.getClass());
        model.addAttribute("info", e.getMessage());
        log.error("处理过程异常：{}",e);
    }

    @ExceptionHandler(value = com.java.demo.config.globalException.GlobalException.class)
    public void globalExceptionHandle(GlobalException e, Model model) {
        model.addAttribute("code", e.getWebResult().getCode());
        model.addAttribute("info", e.getWebResult().getMessage());
        log.error("处理过程异常：{}",e);
    }
}
