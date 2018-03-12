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
								<h3 class="box-title">Settings</h3>

							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<div class="box-body">

								<div class="row">
									<div class="col-sm-1"></div>
									<div class="col-sm-9">
										<form action='<s:url value="/admin/passwordSetting"></s:url>'
											method="POST" class="form-horizontal">

											<div class="form-group">
												<label for="apassword" class="col-sm-4 control-label">Old
													Password</label>

												<div class="col-sm-8">
													<input type="password" class="form-control"
														name="apassword" placeholder="Password">
												</div>
											</div>
											<div class="form-group">
												<label for="apassword1" class="col-sm-4 control-label">New
													Password</label>

												<div class="col-sm-8">
													<input type="password" class="form-control"
														name="apassword1" placeholder="Password">
												</div>
											</div>
											<div class="form-group">
												<label for="apassword2" class="col-sm-4 control-label">New
													Password</label>

												<div class="col-sm-8">
													<input type="password" class="form-control"
														name="apassword2" placeholder="Password">
												</div>
											</div>




											<button type="submit" class="btn btn-info pull-right ">Change</button>

										</form>



									</div>

								</div>
								<div class="col-sm-1"></div>
								<br>
								<div class=row>
									<div class="col-sm-1"></div>
									<div class="col-sm-9">
										<c:if test="${ not empty passwordSettingError }">
											<div class="alert alert-danger alert-dismissible">
												<button type="button" class="close" data-dismiss="alert"
													aria-hidden="true">×</button>
												<h4>
													<i class="icon fa fa-ban"></i>Alert
												</h4>${ passwordSettingError }
											</div>
										</c:if>
										<c:if test="${ not empty passwordSettingSuccess }">
											<div class="alert alert-success alert-dismissible">
												<button type="button" class="close" data-dismiss="alert"
													aria-hidden="true">×</button>
												<h4>
													<i class="icon fa fa-ban"></i>Alert
												</h4>${ passwordSettingSuccess }
											</div>
										</c:if>
									</div>
									<div class="col-sm-1"></div>
								</div>
							</div>

						</div>
					</div>
					<div class="col-md-3"></div>
				</div>

				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Api</h3>

							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<div class="box-body">

								<div class="row">
									<div class="col-sm-2"></div>
									<div class="col-sm-8">
										<form class="form-horizontal">


											<c:if test="${ not empty newapierror }">
												<div class="alert alert-danger alert-dismissible">
													<button type="button" class="close" data-dismiss="alert"
														aria-hidden="true"></button>
													<i>${ newapierror }</i>

												</div>
											</c:if>
											<c:if test="${ not empty newapisuccess }">
												<div class="alert alert-success alert-dismissible">
													<button type="button" class="close" data-dismiss="alert"
														aria-hidden="true"></button>
													<i>${ newapisuccess }</i>
												</div>
											</c:if>

											<a href='<s:url value="/admin/newApi"></s:url>' id="next"
												class="btn btn-info pull-right ">New Api</a>

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

