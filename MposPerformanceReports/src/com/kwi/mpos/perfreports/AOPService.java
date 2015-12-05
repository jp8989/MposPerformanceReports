package com.kwi.mpos.perfreports;

import  org.slf4j.LoggerFactory;
import  org.slf4j.Logger;

public class AOPService {

    private static final Logger log = LoggerFactory.getLogger(AOPService.class);
    private String aop = new String();

    @ProfileExecution
    public void foo() {
        log.info("Executing method 'foo'.");
    }

	public String getAop() {
		return aop;
	}

	public final void setAop(String aop) {
		this.aop = aop;
	}

}    

