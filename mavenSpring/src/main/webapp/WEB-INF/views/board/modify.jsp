<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>


<link rel="stylesheet" href="/webjars/bootstrap/4.4.1/css/bootstrap.min.css">

<div class="row">
	<div class="col-lg-12">
		<h1 class ="page-header">Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class = "col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading" style="margin-bottom: 15px">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<div class="form-group">
						<label style="margin-left: 7px">Bno</label> 
						<input class="form-control" name="bno" value='<c:out value="${board.bno}" />' readonly="readonly" style="width: 40%; margin-left: 7px">
					</div>
					
					<div class="form-group">
						<label style="margin-left: 7px">Title</label> 
						<input class="form-control" name="title" value='<c:out value="${board.title}" />' style="width: 40%; margin-left: 7px">
					</div>
					
					<div class="form-group">
						<label style="margin-left: 7px">Text area</label> 
						<textarea class="form-control" rows="3" name="content" style="width: 40%; margin-left: 7px"><c:out value="${board.content}" /></textarea>
					</div>
					
					<div class="form-group">
						<label style="margin-left: 7px">Writer</label> 
						<input class="form-control" name="writer" value='<c:out value="${board.writer}" />' style="width: 40%; margin-left: 7px">
					</div>
					
					<div class="form-group">
						<label style="margin-left: 7px">RegDate</label> 
						<input class="form-control" name="regDate" value='<fmt:formatDate pattern ="yyyy/MM/dd" value ="${board.regdate}" />' readonly="readonly" style="width: 40%; margin-left: 7px">
					</div>
					
					<div class="form-group">
						<label style="margin-left: 7px">Update Date</label> 
						<input class="form-control" name="regDate" value='<fmt:formatDate pattern ="yyyy/MM/dd" value ="${board.updateDate}" />' readonly="readonly" style="width: 40%; margin-left: 7px">
					</div>
					
					<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum}' />" >
					<input type="hidden" name="amount" value="<c:out value='${cri.amount}' />" >
					<input type="hidden" name="type" value="<c:out value='${cri.type}' />" >
					<input type="hidden" name="keyword" value="<c:out value='${cri.keyword}' />" >
					
					<button type ="submit" data-oper="list" class="btn btn-info" style="margin-left: 14px; margin-right: 20px">List</button>
					
					<sec:authentication property="principal" var="pinfo"/>
					<sec:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq board.writer }">
							<button type ="submit" data-oper="modify" class="btn btn-default" style="color: white; background-color: cornflowerblue; border-color: cornflowerblue">Modify</button>
							<button type ="submit" data-oper="remove" class="btn btn-danger">Remove</button>
						</c:if>
					</sec:authorize>
				</form>
			</div>
			<!--  end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- end col-log-12 -->
</div>
<!-- end row -->

<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-3.1.1.slim.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		var formObj = $("form");
		
		$("button").on("click", function(e) {
			e.preventDefault();
			var operation = $(this).data("oper");
			
			if(operation === 'remove') {
				alert("remove");
				formObj.attr("action", "/board/remove");
			} else if(operation === 'list') {
				formObj.attr("action", "/board/list").attr("method", "get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
								
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			}
			formObj.submit();
		});
	});
</script>