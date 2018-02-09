/**
 * 
 */
//var form = document.getElementById("atm");
//var accountnumberField = form.elements["accountnumber"];
//var messageField = form.elements["message"];
//var creditscoreField = form.elements["creditscore"];
//var savingsbalanceField = form.elements["savingsbalance"];
//var currentbalanceField = form.elements["currentbalance"];








$('#submit').click(function() {

	
	var accountnumberField = $("#accountnumber").val();
	var messageField = $("#message").val();
	var creditscoreField = $("#creditscore").val();
	var savingsbalanceField = $("#savingsbalance").val();
	var currentbalanceField = $("#currentbalance").val();
	
	
	
	
	

	
	
	
	
	
	
    
	$.post("http://localhost:8888/transaction", {accountnumber: accountnumberField, message: messageField, creditscore: creditscoreField, savingsbalance: savingsbalanceField, currentbalance: currentbalanceField});

	
	
	

	
	
	
	
	
	
    return false;//suppress natural form submission
});