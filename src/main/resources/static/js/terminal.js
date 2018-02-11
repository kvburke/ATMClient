/**
 * 
 */


$('#submit').click(function() {

	
	var accountnumberField = $("#accountnumber").val();
	var messageField = $("#message").val();
	var depositField = $("#deposit").val();
	var withdrawField = $("#withdraw").val();
	var currentbalanceField = $("#currentbalance").val();
	
	
	
	
	

	
	
	
	
	
	
    
	$.post("http://localhost:8888/transaction", {accountnumber: accountnumberField, message: messageField, deposit: depositField, withdraw: withdrawField, currentbalance: currentbalanceField});

	
	
	

	
	
	
	
	
	
    return false;//suppress natural form submission
});



function init(){
	$.get("http://localhost:8080/queue");
}