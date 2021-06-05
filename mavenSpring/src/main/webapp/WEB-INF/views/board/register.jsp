<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>


<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<div class="row">
	<div class="col-lg-12">
		<h1 class ="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class = "col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading" style="margin-bottom: 15px">Board Register page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/register" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
					<div class="form-group">
						<label style="margin-left:7px">Title</label> 
						<input class="form-control" name="title" style="width: 40%; margin-left:7px">
					</div>
					
					<div class="form-group">
						<label style="margin-left:7px">Text area</label> 
						<textarea class="form-control" rows="5" name="content" style="width: 40%; margin-left:7px"></textarea>
					</div>
					
					<div class="form-group">
						<label style="margin-left:7px">Writer</label> 
						<input class="form-control" name="writer" value='<sec:authentication property="principal.username"/>'
							readonly="readonly" style="width: 40%; margin-left:7px">
						</input>
					</div>
					
					<button type="submit" class="btn btn-default" style="color: blue">Submit Button</button>
					<button type="reset" class="btn btn-default" style="color: red">Reset Button</button>
				</form>
			</div>
			<!--  end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- end col-log-12 -->
</div>