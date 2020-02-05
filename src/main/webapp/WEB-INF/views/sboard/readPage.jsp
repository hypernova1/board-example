<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<body>
<%@ include file="../include/header.jsp" %>
	<div class="box-body">
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
		<button type="submit" class="btn btn-warning modifyBtn">Modify</button>
		<button type="submit" class="btn btn-danger removeBtn">ROMOVE</button>
		<button type="submit" class="btn btn-primary goListBtn">GO LIST</button>
	</div>
	</div>
	<div class="box-body">
	<div class="row">
		<div class="col-md-12">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
			<div class="box-body">
				<label for="newReplyWriter">Writer</label>
				<input class="form-control" type="text" placeholder="USER ID"id="newReplyWriter">
				<label for="newReplyText">REPLY TEXT</label>
				<input class="form-control" type="text" placeholder="REPLY TEXT"id="newReplyText">
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
			</div>
		</div>
	</div>
	<ul class="timeline">
		<li class="time-label" id="repliesDiv"><span class="bg-green">Replies List</span></li>
	</ul>
	<div class="text-center">
		<ul id="pagination" class="pagination pagination-sm no-margin">
		
		</ul>
	</div>
	</div>
	
	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword" value="${cri.keyword}">
	</form>

<%@ include file="../include/footer.jsp" %>
</body>
<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="replyLi" data-rno={{rno}}>
<i class="fa fa-comments bg-blue"></i>
	<div class="timeline-item">
		<span class="time">
			<i class="fa fa clock-o"></i>{{prettifyDate regdate}}
		</span>
		<h3 class="timeline-header"><strong>{{rno}}</strong> -{{replyer}}</h3>
		<div class="timeline-body">{{replytext}}</div>
		<div class="timeline- footer">
			<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal">Modify</a>
		</div>
	</div>
<li>
{{/each}}
</script>

<script>
	let formObj = document.querySelector("form[role='form']");
	
	document.querySelector(".modifyBtn").addEventListener('click', function(){
		formObj.setAttribute("action", "/sboard/modifyPage");
		formObj.setAttribute("method", "get");
		formObj.submit();
	});
	document.querySelector(".removeBtn").addEventListener('click', function(){
		formObj.setAttribute("action", "/sboard/removePage");
		formObj.setAttribute("method", "get");
		formObj.submit();
	});
	document.querySelector(".goListBtn").addEventListener('click', function(){
		formObj.setAttribute("method", "get");
		formObj.setAttribute("action", "/sboard/list");
		formObj.submit();
	});
	
	let printData = (replyArr, target, tempalateObject) => {
		let template = Handlebars.compile(templateObject.html());
		let html = template(replyArr);
		document.querySelector(".replyLi").remove();
		target.after(html);
	};
	
	let bno = ${boardVO.bno};
	let replyPage = 1;
	
	let printPaging = (pageMaker, target) => {
		let str = "";
		
		if(pageMaker.prev){
			str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
		}
		
		for(let i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){
			let strClass = pageMaker.cri.page == i ? 'class = active' : '';
			str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
		}
		
		if(pageMaker.next){
			str += "<li><a href'" + (pageMaker.endPage + 1) + "'> >> </a></li>";
		}
		
		target.html(str);
	}

	let getPage = (pageInfo) => {
		$.getJSON(pageInfo, (data) => {
			printData(data.list, $("#repliesDiv", document.querySelector("#repliesDiv"), document.querySelector("#template")));
			printPaging(data.pageMaker, document.querySelector(".pagination"));
			
			$("#modifyModal").modal('hide');
		});
	}
	
	
</script>
<script id="template" type="text/x-handlebars-template">
	Handlebars.registerHelper("prettifyDate", function(timeValue){
		let dataObj = new Date(timeValue);
		let year = dataObj.getFullYear();
		let month = dataObj.getMonth() + 1;
		let date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
</script>
</html>