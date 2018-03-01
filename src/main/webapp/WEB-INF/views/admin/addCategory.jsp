<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel | Yönetim Sayfası</title>
<c:import url="/admin/css"></c:import>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<c:import url="/admin/header"></c:import>
		<c:import url="/admin/menu"></c:import>
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Categories <small>Category Page Add</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li class="active">Category Add</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">

					<div class="col-xs-12">
						<a onclick="window.history.back();" class="btn btn-app pull-right">
							<i class="fa fa-arrow-left"></i>Back
						</a>
					</div>


					<div class="col-md-12">
				
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Category Add Form</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
						
							<div class="form-horizontal" >
								<div class="box-body">

									<div class="col-md-6">
										<div class="form-group">
											<label for="categoryTitle" class="col-sm-2 control-label" style="text-align: center">Category
												Name</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="categorytitle"  id="categoryTitle"
													placeholder="Please enter a category name">
											</div>
										</div>
										<div class="form-group">
											<label for="categoryDescription"
												class="col-sm-2 control-label">Category Description</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="categorydescription"
													id="categoryDescription"
													placeholder="Please enter a description about your category">
											</div>
										</div>

									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="categoryparentid" class="col-sm-2 control-label" style="text-align: center">Category Parent</label> 
											<div class="col-sm-10">
										 <c:if test="${ not empty showCategory }">
											<select	class="form-control" id="categoryparentid" name="categoryparentid">
												<option value="0" > Main Category</option>
												<c:forEach var="item" items="${ showCategory }">
												
												<option value="${ item.getCategoryid() }">${ item.getCategorytitle() }</option>
												
												</c:forEach>
												
												</select>
											</c:if>
											</div>
												
										</div>
										<div class="form-group">
											<label for="categorySort" class="col-sm-2 control-label" style="text-align: center" >Category
												Sort</label>

											<div class="col-sm-10">
												<input type="number" class="form-control" name="categorysort" id="categorySort"
													placeholder="Please enter a category sort">
											</div>
										</div>
									</div>

								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="reset" class="btn btn-default">Reset</button>
									<%-- <input type="submit" class="form-control" value="Save" />--%>
									<button  class="btn btn-info pull-right" id="btnadd">Save
									</button> 
								</div>
								<!-- /.box-footer -->
							</div>
						</div>

					</div>

				</div>


			</section>
		</div>
		<c:import url="/admin/footer"></c:import>
		<c:import url="/admin/sidebar"></c:import>
	</div>
	<c:import url="/admin/js"></c:import>
	<script src='<s:url value="/resources/adminJS/Category.js"></s:url>'></script>
</body>
</html>

