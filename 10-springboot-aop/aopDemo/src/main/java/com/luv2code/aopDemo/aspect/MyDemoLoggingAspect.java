package com.luv2code.aopDemo.aspect;

import com.luv2code.aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
@AfterThrowing(
            pointcut = "execution(* com.luv2code.aopDemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=====>>> The exception is: " + theExc);
    }    
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopDemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> result is: " + result);

        // Modify the data if needed
        if (result != null) {
            for (Account account : result) {
                // Sample modification: convert account names to uppercase
                account.setName(account.getName().toUpperCase());
            }
        }

        System.out.println("\n=====>>> result after modification is: " + result);
    }

    @Before("com.luv2code.aopDemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
        }
    }

    @Before("com.luv2code.aopDemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(JoinPoint joinPoint) {
        // Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // Display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
        }
    }
}
