package com.kwi.mpos.perfreports;

//import java.util.logging.Logger;
import  org.slf4j.LoggerFactory;
import  org.slf4j.Logger;


import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.util.StopWatch;

public class ProfilingMethodInterceptor implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ProfilingMethodInterceptor.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        final StopWatch stopWatch = new StopWatch(invocation.getMethod().toGenericString());
        stopWatch.start("invocation.proceed()");

        try {
        	System.out.println("pmi");
            log.info("~~~~~~~~ START METHOD {} ~~~~~~~~", invocation.getMethod().toGenericString());
            System.out.println("~~~~~~~~ START METHOD {} ~~~~~~~~"+ invocation.getMethod().toGenericString());            
            return invocation.proceed();
        } finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            System.out.println("~~~~~~~~ END METHOD {} ~~~~~~~~"+ invocation.getMethod().toGenericString()); 
            
            log.info(stopWatch.prettyPrint());            
            log.info("~~~~~~~~ END METHOD {} ~~~~~~~~", invocation.getMethod().toGenericString());
        }
    }
}    