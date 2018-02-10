package com.burke;

import javax.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Scope(value="singleton")
@Controller
public class ATMController {

	
	@Autowired
	private MessageSender sender;
		
	
	@RequestMapping(value="/transaction", method=RequestMethod.POST)
	public void transaction(@RequestParam("accountnumber")int accountnumber,@RequestParam("message")String message,@RequestParam("creditscore")int creditscore,@RequestParam("savingsbalance")int savingsbalance, @RequestParam("currentbalance")int currentbalance) throws JMSException {
			sender.sendmessage(accountnumber, message, creditscore, savingsbalance, currentbalance);
		
	}
	
	  @RequestMapping(value = "/terminal")
	    public String somePg() {
	        return "static/terminal.html";
	    }
	
}