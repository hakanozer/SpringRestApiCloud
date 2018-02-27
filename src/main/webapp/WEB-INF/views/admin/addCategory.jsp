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
							<form class="form-horizontal">
								<div class="box-body">

									<div class="col-md-6">
										<div class="form-group">
											<label for="categoryTitle" class="col-sm-2 control-label" style="text-align: center">Category
												Name</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" id="categoryTitle"
													placeholder="Please enter a category name">
											</div>
										</div>
										<div class="form-group">
											<label for="categoryDescription"
												class="col-sm-2 control-label">Category Description</label>

											<div class="col-sm-10">
												<input type="text" class="form-control"
													id="categoryDescription"
													placeholder="Please enter a description about your category">
											</div>
										</div>

									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="categoryparentid" class="col-sm-2 control-label" style="text-align: center">Category Parent</label> 
											<div class="col-sm-10">
											<select
												class="form-control" id="categoryparentid">
												
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												</select>
											</div>
												
										</div>
										<div class="form-group">
											<label for="categorySort" class="col-sm-2 control-label" style="text-align: center" >Category
												Sort</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" id="categorySort"
													placeholder="Please enter a category sort">
											</div>
										</div>
									</div>

								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="reset" class="btn btn-default">Reset</button>
									<button type="submit" class="btn btn-info pull-right">Save
									</button>
								</div>
								<!-- /.box-footer -->
							</form>
						</div>

					</div>

				</div>


			</section>
		</div>
		<c:import url="/admin/footer"></c:import>
		<c:import url="/admin/sidebar"></c:import>
	</div>
	<c:import url="/admin/js"></c:import>
	<script src='<s:url value="/resources/adminJS/Sample.js"></s:url>'></script>
</body>
</html>

