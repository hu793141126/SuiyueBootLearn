package com.test.base.config.globalException;



import com.test.base.bean.WebResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 * @date 2019/7/13
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException {
    private  WebResult webResult;
}
