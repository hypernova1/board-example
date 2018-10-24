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
	<div class="box-body">
	<form role="form" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno}">
	</form>
	
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Content</label>
		<textarea name="content" class="form-control" rows="3" readonly="readonly" style="resize: none;">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
	</div>
	
	<div class="box-footer">
		<button type="submit" class="btn btn-warning">Modify</button>
		<button type="submit" class="btn btn-danger">ROMOVE</button>
		<button type="submit" class="btn btn-primary">LIST ALL</button>
	</div>
	</div>

<%@ include file="../include/footer.jsp" %>
</body>
<script>
	let formObj = document.querySelector("form[role='form']");
	
	document.querySelector(".btn-warning").addEventListener('click', function(){
		formObj.setAttribute("action", "/board/modify");
		formObj.setAttribute("method", "get");
		formObj.submit();
	})
	document.querySelector(".btn-danger").addEventListener('click', function(){
		formObj.setAttribute("action", "/board/remove");
		formObj.setAttribute("method", "get");
		formObj.submit();
	})
	document.querySelector(".btn-primary").addEventListener('click', function(){
		self.location = "/board/listAll";
	})
	
</script>
</html>