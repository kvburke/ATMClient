package com.burke;

import java.util.Map;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	
	@Autowired
	private MessageSender sender;
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";


	
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}
	
	
	@RequestMapping("/hello")
	public void hello() {
		System.out.println("hello world");
	}
	
	@RequestMapping(value="/transaction", method=RequestMethod.POST)
	public void transaction(@RequestParam("accountnumber")int accountnumber,@RequestParam("message")String message,@RequestParam("creditscore")int creditscore,@RequestParam("savingsbalance")int savingsbalance, @RequestParam("currentbalance")int currentbalance) {
		try {
			sender.sendmessage(accountnumber, message, creditscore, savingsbalance, currentbalance);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  @RequestMapping(value = "/terminal")
	    public String somePg() {
	        return "static/terminal.html";
	    }
	
}