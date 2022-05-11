let index = {
	init: function() {
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},
	
	save: function() {
		//alert("save 호출");
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val(),
		};
		
		//console.log(data);
		$.ajax({
			type:"POST",
			url:"/blog/api/user",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp){
			alert("회원가입이 완료되었습니다");
			location.href = "/blog";
		}).fail(function(){
			alert(JSON.stringify(error));
			
		});
	}
}

index.init();