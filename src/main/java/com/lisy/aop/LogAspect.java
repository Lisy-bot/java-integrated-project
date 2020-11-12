package com.lisy.aop;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lisy.util.IpUtil;
/**
 * 常用日志
 */
@Slf4j
@Aspect //开启AOP
@Component //将这个类注册到容器中
public class LogAspect {
	@Pointcut("execution(public * com.lisy.controllers.*.*.*(..))")
	public void webLog() {}
	@Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
    	//获取 ServletRequestAttributes对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //利用ServletRequestAttributes对象获取HttpServletRequest对象
        HttpServletRequest request = attributes.getRequest();
        //获取url,使用getRequestURL()获取的是StringBuffer对象，需要转成String
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();

        //利用JoinPoint获得拦截的方法
        String methodName = joinPoint.getSignature().getDeclaringTypeName()+"."
                            + joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(ip,url,methodName,args);
        log.info("Request : {}", requestLog);
    }
     //最终通知 ：无论目标方法是否出现异常 最终通知都会 执行，将返回结果记录到日志中
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		log.info("RESPONSE : " + ret);
	}
	//定义一个内部类来封装用户的ip,请求的URL,调用的方法，参数
    public class RequestLog{
        private String ip;
        private String url;
        private String methodName;
        private Object[] args;

        public RequestLog(String ip, String url, String methodName, Object[] args) {
            this.ip = ip;
            this.url = url;
            this.methodName = methodName;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "ip='" + ip + '\'' +
                    ", url='" + url + '\'' +
                    ", methodName='" + methodName + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
