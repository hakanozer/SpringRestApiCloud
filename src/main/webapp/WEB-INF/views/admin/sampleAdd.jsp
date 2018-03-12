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
					Sample <small>Sample Page Add</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li class="active">Sample Add</li>
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
								<h3 class="box-title">Sample Add Form</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form class="form-horizontal">
								<div class="box-body">

									<div class="col-md-6">
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">Email</label>

											<div class="col-sm-10">
												<input type="email" class="form-control" id="inputEmail3"
													placeholder="Email">
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-2 control-label">Password</label>

											<div class="col-sm-10">
												<input type="password" class="form-control"
													id="inputPassword3" placeholder="Password">
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-2 control-label">Email</label>

											<div class="col-sm-10">
												<input type="email" class="form-control" id="inputEmail3"
													placeholder="Email">
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-2 control-label">Password</label>

											<div class="col-sm-10">
												<input type="password" class="form-control"
													id="inputPassword3" placeholder="Password">
											</div>
										</div>
									</div>

									<div class="col-md-12">
									<div class="form-group">
									
									<label for="inputPassword3" class="col-sm-1 control-label">Detail</label>
					<div class="col-sm-11">
					<textarea id="editor1" name="editor1" rows="10" cols="80">
                                            This is my textarea to be replaced with CKEditor.
                    </textarea>
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

