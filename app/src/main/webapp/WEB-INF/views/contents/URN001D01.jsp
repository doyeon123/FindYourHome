<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 공지사항 상세 페이지 -->
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="m-1 row">
		<label for="title" class="col-sm-2 align-self-center text-center">Title</label>
		<div class="col-sm-10">
			<input type="text" readonly class="form-control-plaintext fs-1"
				id="title" value="${notice.notice_title}">
		</div>
	</div>
	<div class="d-flex flex-row-reverse bd-highlight">
		<div class="p-2 bd-highlight">${notice.notice_displydate}</div>
		<div class="p-2 bd-highlight">|</div>
		<div class="p-2 bd-highlight">${notice.notice_rewritedate}</div>
		<div class="p-2 bd-highlight">|</div>
		<div class="p-2 bd-highlight">${notice.notice_writedate}</div>
	</div>
	<div class="m-1 row">
		<label for="link" class="col-sm-2 align-self-center text-center">Link</label>
		<div class="col-sm-10">
			<a href="${notice.notice_link}">${notice.notice_link}</a>
		</div>
	</div>
	<div class="m-1 row">
		<label for="content" class="col-sm-2 align-self-center text-center">Content</label>
		<div  class="col-sm-10">
			<div id="content" class="card">
				${notice.notice_content}
			</div>
		</div>
	</div>

</body>
</html>