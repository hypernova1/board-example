<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
<link href="/resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
<body>
<%@ include file="../include/header.jsp" %>
	<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" placeholder="Enter Title">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" rows="3" name="content" placeholder="Enter ..."></textarea>
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" placeholder="Enter Writer">
		</div>
	</div>
		
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
		<%@include file="../include/footer.jsp" %>
</body>
</html>