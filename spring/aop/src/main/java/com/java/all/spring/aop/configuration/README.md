#### aop 程序代码进行切面编程
##### 1 xml申明自动扫描AOP注解 
```
 <aop:aspectj-autoproxy/>
```

##### 配置aop注解类 
```
 @Component
 @Aspect
 public class AspectJ {
 
     /**
      * 申明一个Pointcut切面空方法，创建一个引用，公用切点
      */
     @Pointcut("execution(public * com.java.all.spring.aop.configuration.service..*(..))")
     public void doPointcut() {
 
     }
 
     @Before("doPointcut()")
     public void before() {
         System.out.println("AspectJ before 前置通知");
     }
 }
```
##### 启动ConfAopApplication类，执行目标方法
```
# 返回结果
AspectJ before 前置通知
ExecutionService execute ...
AspectJ before 后置通知
AspectJ AfterReturning 通知
```