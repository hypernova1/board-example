<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
	<form role="form" method="post">
	<div class="box-body">
	
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${boardVO.title}">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Content</label>
		<textarea name="content" class="form-control" rows="3" style="resize: none;">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
	</div>
	
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="submit" class="btn btn-warning">CANCEL</button>
	</div>
	</div>
	</form>

<%@ include file="../include/footer.jsp" %>
</body>
<script>
	let formObj = document.querySelector("form[role='form']");
	
	document.querySelector(".btn-warning").addEventListener('click', function(){
		self.location = "/board/listAll";
	})
	document.querySelector(".btn-primary").addEventListener('click', function(){
		formObj.submit();
	})
</script>
</html>