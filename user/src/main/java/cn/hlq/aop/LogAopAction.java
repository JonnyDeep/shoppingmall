package cn.hlq.aop;

import cn.hlq.annotation.SystemLog;
import cn.hlq.common.utils.Datetils;
import cn.hlq.common.utils.Exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAopAction {



    private static Logger logger = LogManager.getLogger(LogAopAction.class.getName());
    @Pointcut("execution(* cn.hlq.controller..*.*(..))")
    private void controllerOperation(){}

    @Around("cn.hlq.aop.LogAopAction.controllerOperation()")
    public Object doAroundControllerCheck(ProceedingJoinPoint pjp) throws Throwable{
        

        Date date = new Date();
        String time = Datetils.Long2DateFormat(date.getTime());
        logger.info("---------- currentTime:{}",time);
        Object retVal = pjp.getTarget();
        String signature = pjp.getSignature().getName();
        logger.info("---------- signature:{}",signature);
        logger.info("---------- signatureType:{}",pjp.getSignature().getDeclaringTypeName());
        Object args = pjp.getArgs();
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if(!(sig instanceof  MethodSignature)){
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature)sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();
        Object object = null;
        Method method = null;

        try {
            method = retVal.getClass().getMethod(signature,parameterTypes);
        }catch (NoSuchMethodException ex){
            logger.info("没有该方法");
            throw new CustomException("没有该方法");
        }catch (SecurityException ex){
            logger.info("不安全");
            throw new CustomException("不安全");
        }

        if(null!=method){
            if(method.isAnnotationPresent(SystemLog.class)){
                SystemLog systemLog = method.getAnnotation(SystemLog.class);
                String sysmodule = systemLog.module();
                String sysmethod = systemLog.methods();
                logger.info("----------- module:{},method:{}",sysmodule,sysmethod);
                try{
                    object = pjp.proceed();
                    Date end = new Date();
                    String endtime = Datetils.Long2DateFormat(end.getTime());
                    logger.info("----------- endtime:{}",endtime);
                }catch (Throwable ex){
                    Date end = new Date();
                    String endtime = Datetils.Long2DateFormat(end.getTime());
                    logger.info("----------- endtime:{}",endtime);
                    logger.info("----------- 执行失败");
                    ex.printStackTrace();
                    throw new CustomException("执行失败");
                }
            }else {
                object = pjp.proceed();
                logger.info("----------- 没有注解");
            }
        }else{
            object = pjp.proceed();
            logger.info("----------- 不需要拦截");
        }
        return  object;
    }

}
