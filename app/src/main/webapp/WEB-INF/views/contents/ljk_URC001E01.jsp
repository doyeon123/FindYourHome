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
			<h1>글 쓰기</h1>		
		</div>
	<form name="writeForm" action="/consulting/create" method="post">
		<table id="table2"  width=100% border=0 cellpadding=1 cellspacing=0 bgcolor="#dddddd">
		<c:choose>
			<c:when test="${vo != null}">
			<tr>
				<td>
					<input type="text" name="consulting_registerno" placeholder="번호" value="${vo.consulting_registerno} " readonly disabled>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="consulting_author" placeholder="작성자" value="${vo.consulting_author} " autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="consulting_password" placeholder="비밀번호" value="${vo.consulting_password }" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="consulting_title" placeholder="글제목" class="w_title" value="${vo.consulting_title }" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<textarea name="consulting_content" placeholder="글내용" autocomplete="off">${vo.consulting_content }</textarea>
				</td>
			</tr>
			</c:when>
			<c:otherwise>
			<tr>
				<td>
					<input type="text" name="consulting_author" placeholder="작성자" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="consulting_password" placeholder="비밀번호" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="text" name="consulting_title" placeholder="글제목" class="w_title" autocomplete="off">
				</td>
			</tr>
			
			<tr>
				<td>
					<textarea name="consulting_content" placeholder="글내용" autocomplete="off"></textarea>
				</td>
			</tr>
			
			</c:otherwise>
		</c:choose>

			
			<tr>
				<td colspan="2">
					<c:if test="${vo != null}">
				
					<input type="button" value="수정" onclick="detailBtn()">
					<input type="reset"  value="삭제" onclick="detailBtn()">
					</c:if>	
					<c:if test="${vo == null}">
					<input type="button" value="글쓰기" onclick="checkBoard()">
					<input type="reset"  value="취소">
					</c:if>
					<input type="button" value="팝업창 띄우기" onclick="openPopUp()"><br>
					<a href="javascript:history.back()"><input type="button" value="뒤로가기"></a>					
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
			
			console.log("수정실행");
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
				
			console.log("삭제실행");
			document.writeForm.action=url;
			document.writeForm.method="get";
			document.writeForm.submit();
			
		}
	
		function checkBoard(){
			var form = document.writeForm;
			var title = form.consulting_title.value;
			var content = form.consulting_content.value;
			
			
			if(title==""){
				alert("글제목을 써주세요");
				form.consulting_title.focus();
				return false;
			}
			if(content==""){
				alert("글내용을 써주세요");
				form.consulting_content.focus();
				return false;
			}
			form.submit();
		}
	
	</script>
</body>
</html>