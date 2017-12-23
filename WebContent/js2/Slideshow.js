
function displayResult() {
    
	$.ajax({
 	 url: 'control/test.do?method=testFindUser',
  	 type: 'POST',
  success: function(data) {
	//called when successful
	alert(data);
  },
  error: function(e) {
	//called when there is an error
	//console.log(e.message);
  }
});
}
