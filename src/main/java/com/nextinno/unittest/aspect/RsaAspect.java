package com.nextinno.unittest.aspect;

import java.lang.reflect.Method;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

// @Aspect가 명시된 빈에는 어드바이스(Advice)라 불리는 메써드를 작성할 수 있다.
// @Before, @After, @AfterReturning, @AfterThrowing, @Around 등
@Aspect
@Component
@Slf4j
// @Order를 명시하여 @Aspect 빈 간의 작동 순서를 정할 수 있다. 값이 낮을수록 우선순위가 높다.
// LOWEST_PRECEDENCE는 기본값 이면서 가장 낮은 우선순위를 가진다.
@Order(Ordered.LOWEST_PRECEDENCE)
// @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RsaAspect {

    @AfterReturning(pointcut = "@annotation(com.nextinno.unittest.aspect.Rsa)", returning = "result")
    public void rsaAfterReturning(JoinPoint joinPoint, Object result) {
        try {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            Rsa rsa = method.getAnnotation(Rsa.class);
            System.out.println("================2222222222================");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(result);
            log.debug("rsa : ", rsa);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    // @Before(value = "name", argNames = "name")
    // @Before("execution(* com.nextinno.unittest.*.*(..))")
    @Before("@annotation(com.nextinno.unittest.aspect.Rsa)")
    public void rsaBeforReturning(JoinPoint joinPoint) {
        try {
            log.debug("rsaBeforReturning : ", joinPoint.getSignature().getName());
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Object[] test1 = joinPoint.getArgs();
            Method method = signature.getMethod();
            Rsa rsa = method.getAnnotation(Rsa.class);
            String[] encryptedFields = rsa.encryptedFields();
            for (String item : encryptedFields) {
                // String encryptedField = httpRequest.getAttribute(item).toString();
                // Object test1 = httpRequest.get
                System.out.println("================11111111================");
            }
            System.out.println("logBefore() is running!");
            System.out.println("hijacked : " + joinPoint.getSignature().getName());
            System.out.println("******");

            // httpRequest.getAttribute("");
            // log.debug("rsa : ", rsa);
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Around("@annotation(com.nextinno.unittest.aspect.Rsa)")
    public String rsaAroundReturning(ProceedingJoinPoint joinPoint) {
        try {
            // @Rsa aspect의 encryptedFields 값을 가져오는 부분
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            Rsa rsa = method.getAnnotation(Rsa.class);
            String[] encryptedFields = rsa.encryptedFields();

            // Controller에 parameter로 넘어온 값을 가져온다.
            Object[] args = joinPoint.getArgs();

            ObjectMapper mapper = new ObjectMapper();
            // objcet -> map 형식으로 변환.
            Map<String, String> valMap = mapper.convertValue(args[0], Map.class);

            for (String field : encryptedFields) {
                if (valMap.get(field).toString() != null) {
                    // 복호화 하기
                    // valMap.put(field, rsaUtil.decryptRSA(valMap.get(field).toString(),
                    // "123123"));
                    valMap.put(field, "test11");
                }
            }

            args[0] = mapper.convertValue(valMap, args[0].getClass());

            // joinPoint.proceed(args) 으로 끝내면 Controller 가기 전까지만 실행되고
            // return은 Controller의 return 값을 가져오게 된다.
            String test11 = (String) joinPoint.proceed(args);
            System.out.println(test11);
            return test11;
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
