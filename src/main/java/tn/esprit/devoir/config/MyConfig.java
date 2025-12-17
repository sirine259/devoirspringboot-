package tn.esprit.devoir.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyConfig {

    // Pointcut qui cible toutes les méthodes du package service
    @Pointcut("execution(* tn.esprit.devoir.service..*.*(..))")
    public void serviceMethods() {}

    // Advice qui s'exécute après le retour normal d'une méthode
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logMethodCall(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Méthode exécutée avec succès - {}#{}", className, methodName);
    }
}
