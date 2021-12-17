<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>팝업창</title>
<script src="/resources/lib/jquery/jquery-3.6.0.min.js"></script>
</head>
<%-- onunload="closePopup()" 
	: 'x'를 눌러도 '확인'버튼과 동일하게 작동되도록 해줌 --%>
<body onunload="closePopup()">
	<div align="center">
		<h1>비밀번호 확인</h1>
		<form method="post" action="/consulting/checkpw">
			<input type="hidden" >
			글을 작성할 때 입력했던 비밀번호를 적어주세요
			<input type="password" name="password" id="password">
			<input type="button" id="btn" value="비밀번호확인">
		
	<br><br>
	
	<input type="submit" id="submiBtn" value="수정 또는 삭제" disabled>
	<input type="button" value="확인" onclick="closePopup()">
	</form>
	</div>
	


<script type="text/javascript">
$(document).ready(
		function(){
			$(btn).on('click',function(){
				var id = opener.document.writeForm.consulting_registerno.value;
				var xpassword = opener.document.writeForm.consulting_password.value;
				var password = $('#password').val();
				
				alert(xpassword);
				
				
				var ljk_URC001Dto = {
						consulting_registerno:id,
						consulting_password:password
		    	};
				
				$.ajax({
					
					url:'/checkpw',
					method:'POST',
					data: JSON.stringify(ljk_URC001Dto),
					contentType: 'application/json; charset=UTF-8',
					dataType :'json',
					success : function(data){
						if(data.result === "Success"){
							alert("비밀번호가 일치합니다");
							$('#submiBtn').attr('disabled',false);
						}else{
							alert("비밀번호가 일치하지않습니다"+xpassword+"/"+id);
						}
					}
					
				});
				
			});
			
		});


		/* function checkPassWord() {
			var id = opener.document.writeForm.consulting_registerno;
			var xpassword = opener.document.writeForm.consulting_password;
			var password = $('#password');
			
			alert(password);
			
			var ljk_URC001Dto = {
					consulting_registerno:id,
					consulting_password:password
	    	};
			
			$.ajax({
				
				type:'post',
				url:'/consulting/checkpw',
				data:JSON.stringify(ljk_URC001Dto),
				dataType :'json',
				success : function(data){
					if(data.result === "Success"){
						alert("비밀번호가 일치합니다");
						$('#submiBtn').attr('disabled',false);
					}else{
						alert("비밀번호가 일치하지않습니다"+xpassword+"/"+id);
					}
				}
				
			});
		} */
	function closePopup() {
		//함수 동작 테스트
		//alert("click");
		
		//자신을 실행시킨 본 창은 opener 객체로 인식된다
		//var nickNameObj = opener.document.testForm.nickName;
		//var flagObj = opener.document.testForm.flag;
		
		//nickName 초기화 시키기
		//nickNameObj.value = "";
		//nickName으로 마우스 커서 옮기기
		//nickNameObj.focus();
		
		// flag를 "ok"로 변경
		//flagObj.value = "ok";
		
		//자신(팝업)을 종료한다.
		
		self.close();
	}


</script>	
</body>
</html>