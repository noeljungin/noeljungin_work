package board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mybatis.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
	
	@Around("execution(* board..controller.*Controller.*(..)) or execution(* board..service.*Impl.*(..)) or execution(* board..dao.*Mapper.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable{
		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();
		
		if (name.indexOf("Controller") > -1) {
			type = "Conroller \t: ";
		} else if(name.indexOf("Service") > -1) {
			type = "ServiceImpl \t: ";
		} else if(name.indexOf("Mapper") > -1) {
			type = "Mapper \t\t: ";
		}
		
		log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
		return joinPoint.proceed();
	}

}
