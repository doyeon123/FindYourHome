<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�˾�â</title>
<script src="/resources/lib/jquery/jquery-3.6.0.min.js"></script>
</head>
<%-- onunload="closePopup()" 
	: 'x'�� ������ 'Ȯ��'��ư�� �����ϰ� �۵��ǵ��� ���� --%>
<body onunload="closePopup()">
	<div align="center">
		<h1>��й�ȣ Ȯ��</h1>
		<form method="post" action="/consulting/checkpw">
			<input type="hidden" >
			���� �ۼ��� �� �Է��ߴ� ��й�ȣ�� �����ּ���
			<input type="password" name="password" id="password">
			<input type="button" id="btn" value="��й�ȣȮ��">
		
	<br><br>
	
	<input type="submit" id="submiBtn" value="���� �Ǵ� ����" disabled>
	<input type="button" value="Ȯ��" onclick="closePopup()">
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
							alert("��й�ȣ�� ��ġ�մϴ�");
							$('#submiBtn').attr('disabled',false);
						}else{
							alert("��й�ȣ�� ��ġ�����ʽ��ϴ�"+xpassword+"/"+id);
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
						alert("��й�ȣ�� ��ġ�մϴ�");
						$('#submiBtn').attr('disabled',false);
					}else{
						alert("��й�ȣ�� ��ġ�����ʽ��ϴ�"+xpassword+"/"+id);
					}
				}
				
			});
		} */
	function closePopup() {
		//�Լ� ���� �׽�Ʈ
		//alert("click");
		
		//�ڽ��� �����Ų �� â�� opener ��ü�� �νĵȴ�
		//var nickNameObj = opener.document.testForm.nickName;
		//var flagObj = opener.document.testForm.flag;
		
		//nickName �ʱ�ȭ ��Ű��
		//nickNameObj.value = "";
		//nickName���� ���콺 Ŀ�� �ű��
		//nickNameObj.focus();
		
		// flag�� "ok"�� ����
		//flagObj.value = "ok";
		
		//�ڽ�(�˾�)�� �����Ѵ�.
		
		self.close();
	}


</script>	
</body>
</html>