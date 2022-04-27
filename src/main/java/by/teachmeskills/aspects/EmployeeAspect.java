package by.teachmeskills.aspects;

import by.teachmeskills.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class EmployeeAspect {

    @Pointcut("execution(* getEmployeeById(..))")
    public void getEmployeeByIdPointCut(){ }

    @Before("target(by.teachmeskills.controller.EmployeeController)")
    public void adviseGetEmployeeById(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(signature.getMethod().getName());
    }

//    @After("getEmployeeByIdPointCut()")
//    public void adviseAfterGetEmployeeById() {
//        System.out.println("This advice after method getById()");
//    }

//    @AfterReturning(value = "getEmployeeByIdPointCut()", returning = "employee")
//    public void afterGettingEmployee(Employee employee) {
//        System.out.println("First name: " + employee.getFirstName());
//    }
//
//    @AfterThrowing(value = "getEmployeeByIdPointCut()", throwing = "exception")
//    public void adviceWithThrowing(Throwable exception) {
//        System.out.println(exception.getMessage());
//    }

//    @Around("getEmployeeByIdPointCut()")
//    public Object aroundAdviceTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("Before getting Employee");
//
//        Object proceed = proceedingJoinPoint.proceed();
//
//        System.out.println("After getting Employee");
//
//        return proceed;
//    }
}