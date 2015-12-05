package com.kwi.mpos.perfreports;

import org.springframework.stereotype.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
/*
 * author: Jonathan
 * 
 */
 
@Controller
public class MposPerformanceReportsServlet {
	

	@RequestMapping("/addItemReport")
	public ModelAndView addItemReport() {
		
		runBean();
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>1) shows parameters 2) run reports 3) display results</div><br><br>";
		
		return new ModelAndView("addItemReport", "message", message);
	}
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		runBean();
		
		String message = "<br><div style='text-align:center;'>"
				//+ "<h3>********** message from SpringMposPerformanceReportsServlet **********</div><br><br>";
				+ "<h3>AOPService: " + runBean() + "</div><br><br>";
		
		return new ModelAndView("welcome", "message", message);
	}
	
	@ProfileExecution
	public String runBean() {
	
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
			new String[] { "applicationContext.xml" });

		AOPService cust = (AOPService) appContext.getBean("aopServiceProxy");
		cust.foo();


		return cust.getAop();

	}
}
