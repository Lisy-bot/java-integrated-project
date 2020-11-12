package com.lisy.exception;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.lisy.common.result.CommonEnum;
import com.lisy.common.result.ResultBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一异常处理
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    // private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class); 等同于 @Slf4j

    /**
     * 处理自定义的业务异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public ResultBody exceptionHandler(HttpServletRequest req, MyException e) {
    	log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
    	log.error("发生空指针异常！原因是:", e);
        return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
    	log.error("500未知异常！原因是:", e);
        return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }

    /***
     * 404异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Object notFountHandler(HttpServletRequest request, NoHandlerFoundException e) {
    	log.error("404:", e);
        return ResultBody.error(CommonEnum.NOT_FOUND);
    }

}
