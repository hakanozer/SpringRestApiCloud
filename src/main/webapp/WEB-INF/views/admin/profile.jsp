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
					Sample <small>Sample Page</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li class="active">Sample</li>
				</ol>
			</section>
			<section class="content">
<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">My Profile</h3>
					<c:if test="${ not empty error }">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">×</button>
							<h4>
								<i class="icon fa fa-ban"></i>Alert
							</h4>${ error }
						</div>
					</c:if>
					<c:if test="${ not empty success }">
						<div class="alert alert-success alert-dismissible">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">×</button>
							<h4></h4>${ success }
						</div>
					</c:if>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<div class="box-body">

					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<form action='<s:url value="/admin/edit"></s:url>' method="GET"
								class="form-horizontal">
								<img class="profile-user-img img-responsive img-circle"
									src='<s:url value="/resources/dist/img/defaultuser.png"></s:url>'
									alt="User profile picture"><br>
								<div class="col-md-12" align="right">
									<input type="file" id="exampleInputFile">
								</div>
								<br> <br>

								<div class="form-group">
									<label for="aname" class="col-sm-5 control-label">Name</label>

									<div class="col-sm-7">
										<label id="aname" class="col-sm-3 control-label">${ adm.getAname() }</label>
									</div>
								</div>
								<div class="form-group">
									<label for="asurname" class="col-sm-5 control-label">Surname</label>

									<div class="col-sm-7">
										<label id="asurname" class="col-sm-3 control-label">${ adm.getAsurname() }</label>
									</div>
								</div>
								<div class="form-group">
									<label for="aphone" class="col-sm-5 control-label">Phone</label>

									<div class="col-sm-7">
										<label id="aphone" class="col-sm-3 control-label">${ adm.getAphone() }</label>
									</div>
								</div>

								<div class="form-group">
									<label for="amail" class="col-sm-5 control-label">Email</label>

									<div class="col-sm-7">
										<label id="amail" class="col-sm-3 control-label">${ adm.getAmail() }</label>
									</div>
								</div>
								<div class="form-group">
									<label for="companyname" class="col-sm-5 control-label">companyname</label>

									<div class="col-sm-7">
										<label id="companyname" class="col-sm-3 control-label">${ com.getCompanyname() }</label>
									</div>
								</div>
								<div class="form-group">
									<label for="companyphone" class="col-sm-5 control-label">companyphone</label>

									<div class="col-sm-7">
										<label id="companyphone" class="col-sm-3 control-label">${ com.getCompanyphone() }</label>
									</div>
								</div>
								<div class="form-group">
									<label for="companyfax" class="col-sm-5 control-label">companyfax</label>

									<div class="col-sm-7">
										<label id="companyfax" class="col-sm-3 control-label">${ com.getCompanyfax() }</label>
									</div>
								</div>
								<div class="form-group">
									<label for="companymail" class="col-sm-5 control-label">companymail</label>

									<div class="col-sm-7">
										<label id="companymail" class="col-sm-3 control-label">${ com.getCompanymail() }</label>
									</div>
								</div>

								<div class="form-group">
									<label for="companyadress" class="col-sm-5 control-label">companyadress</label>

									<div class="col-sm-7">
										<label id="companyadress" class="col-sm-3 control-label">${ companyadress }
										</label>
									</div>
								</div>

								<button id="next" class="btn btn-info pull-right ">Edit</button>

							</form>
						</div>
					</div>
					<div class="col-sm-2"></div>


				</div>


			</div>
		</div>
		<div class="col-md-3"></div>
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

