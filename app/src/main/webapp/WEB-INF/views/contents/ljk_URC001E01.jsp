<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	${volist}
	<div id="container">
	
		<div class="title">
			<h1>�� ����</h1>		
		</div>
	<form name="writeForm" action="/consulting/create" method="post">
		<table id="table2"  width=100% border=0 cellpadding=1 cellspacing=0 bgcolor="#dddddd">
		<c:choose>
			<c:when test="${vo != null}">
			<tr>
				<td>
					<input type="text" name="consulting_registerno" placeholder="��ȣ" value="${vo.consulting_registerno} " readonly disabled>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="consulting_author" placeholder="�ۼ���" value="${vo.consulting_author} " autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="consulting_password" placeholder="��й�ȣ" value="${vo.consulting_password }" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="consulting_title" placeholder="������" class="w_title" value="${vo.consulting_title }" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<textarea name="consulting_content" placeholder="�۳���" autocomplete="off">${vo.consulting_content }</textarea>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
			<tr>
				<td>
					<input type="text" name="consulting_author" placeholder="�ۼ���" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="consulting_password" placeholder="��й�ȣ" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="consulting_title" placeholder="������" class="w_title" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<textarea name="consulting_content" placeholder="�۳���" autocomplete="off"></textarea>
				</td>
			</tr>
			
			</c:otherwise>
		</c:choose>

			
			<tr>
				<td colspan="2">
					<c:if test="${vo != null}">
				
					<input type="button" value="����" onclick="detailBtn()">
					<input type="reset"  value="����" onclick="detailBtn()">
					</c:if>	
					<c:if test="${vo == null}">
					<input type="button" value="�۾���" onclick="checkBoard()">
					<input type="reset"  value="���">
					</c:if>
					<input type="button" value="�˾�â ����" onclick="openPopUp()"><br>
					<a href="javascript:history.back()"><input type="button" value="�ڷΰ���"></a>					
				</td>
			</tr>
			
					
		</table>
	
	</form>
	
	</div>
	
	
	<script type="text/javascript">
	
		function openPopUp(){
			window.open("Popup", "Popup", "width=450, height=250, top=150, left=200");

		}
	
		function detailBtn(){
			var url= "";
			var no = ${vo.consulting_registerno}+"";
			
			if(${vo != null}){
				url = '/consulting/update/'+ no;
			}
			
			console.log("��������");
			document.writeForm.action=url;
			document.writeForm.method="post";
			document.writeForm.submit();
		}
		function removeBoard(){
			//location.href = "/board/list?pageNo="+page;
			//document.writeForm.pageNo.value=page;
			var url= "";
			var no = ${vo.consulting_registerno}+"";
			
			if(${vo == null}){
				url = '/consulting/remove/';		
			}else{
				url = '/consulting/remove/'+ no;
			}
				
			console.log("��������");
			document.writeForm.action=url;
			document.writeForm.method="get";
			document.writeForm.submit();
			
		}
	
		function checkBoard(){
			var form = document.writeForm;
			var title = form.consulting_title.value;
			var content = form.consulting_content.value;
			
			
			if(title==""){
				alert("�������� ���ּ���");
				form.consulting_title.focus();
				return false;
			}
			if(content==""){
				alert("�۳����� ���ּ���");
				form.consulting_content.focus();
				return false;
			}
			form.submit();
		}
	
	</script>
</body>
</html>