package com.ritsuki.framework.common.core.exception;

import com.ritsuki.framework.common.core.constant.CommonErrorCodeConst;
import com.ritsuki.framework.common.core.pojo.CommonResult;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理
 *
 * @author ritsuki
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数校验异常处理
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult<Void> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("[common.exception][GlobalExceptionHandler][methodArgumentNotValidException]", e);
        return new CommonResult<>(CommonErrorCodeConst.BAD_REQUEST.code(), e.getAllErrors()
                .get(0)
                .getDefaultMessage());
    }

    /**
     * 参数校验异常处理
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({BindException.class, ValidationException.class, TypeMismatchException.class,
            ServletRequestBindingException.class, MissingPathVariableException.class,
            HttpMessageNotReadableException.class, MissingServletRequestParameterException.class,
            MissingServletRequestPartException.class, MultipartException.class,
            MethodArgumentTypeMismatchException.class, IllegalArgumentException.class})
    @ResponseBody
    public CommonResult<Void> illegalRequestException(Exception e) {
        log.error("[common.exception][GlobalExceptionHandler][illegalRequestException]", e);
        return new CommonResult<>(CommonErrorCodeConst.BAD_REQUEST.code(), e.getMessage());
    }

    /**
     * SpringMVC 请求地址不存在处理
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public CommonResult<?> noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        log.error("[common.exception][GlobalExceptionHandler][noHandlerFoundExceptionHandler]", e);
        return new CommonResult<>(CommonErrorCodeConst.NOT_FOUND.code(), e.getMessage());
    }

    /**
     * 服务异常处理
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public CommonResult<Void> businessExceptionHandler(BusinessException e) {
        log.error("[common.exception][GlobalExceptionHandler][businessExceptionHandler]", e);
        AlarmFrameworkUtil.alarm(e);
        return new CommonResult<>(e.getCode(), e.getMessage());
    }

    /**
     * 不支持异常处理
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseBody
    public CommonResult<Void> unsupportedOperationExceptionHandler(UnsupportedOperationException e) {
        log.error("[common.exception][GlobalExceptionHandler][unsupportedOperationExceptionHandler]", e);
        return new CommonResult<>(CommonErrorCodeConst.NOT_IMPLEMENTED.code(), e.getMessage());
    }

    /**
     * 异常处理
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult<Void> exceptionHandler(Exception e) {
        log.error("[common.exception][GlobalExceptionHandler][exceptionHandler]", e);
        AlarmFrameworkUtil.alarm(e);
        return new CommonResult<>(CommonErrorCodeConst.INTERNAL_SERVER_ERROR.code(),
                CommonErrorCodeConst.INTERNAL_SERVER_ERROR.message());
    }

}

