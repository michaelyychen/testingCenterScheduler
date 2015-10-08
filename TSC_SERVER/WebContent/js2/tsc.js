
function login() {
    

	$.ajax({
 	 url: 'control/test.do?method=testFindUser',
  	 type: 'POST',
  	 async:false,
  	 success: function(data) {
	//called when successful
  		alert(data.toString());
  },
  error: function(e) {
	//called when there is an error
	//console.log(e.message);
		alert("test2");
  }
});
}

function login2() {
    
	$.post('control/test.do?method=testFindUser');
}