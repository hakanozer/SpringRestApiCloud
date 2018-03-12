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
					User Address<small>User Address Page</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li class="active">User Address</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">

					<div class="col-xs-12">
						<a href='<s:url value="/admin/useraddress"></s:url>' class="btn btn-app pull-right">
							<i class="fa fa-arrow-left"></i>Back
						</a>
					</div>

					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">User Address Form</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<form class="form-horizontal" 
								action='<s:url value="/admin/useraddresssave"></s:url>'
								method="post">
								<div class="box-body">
									<div class="col-md-12">
										<div class="form-group">
											<label class="col-md-1 control-label">User</label>
											<div class="col-md-11">
												<select name="adresscustomerid" id="adresscustomerid"
													class="form-control select2" style="width: 100%;">
													<option value="-1">Please select your user</option>
													<c:if test="${not empty userLs }">
														<c:forEach var="item" items="${userLs }">
															<option value="${item.getCustomerid() }">${item.getCustomername() }
																${item.getCustomersurname() }</option>
														</c:forEach>
													</c:if>
												</select>
												<c:if test="${not empty error}">
										<div class="alert alert-danger alert-dismissible">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">×</button>
											<h4>
												<i class="icon fa fa-ban"></i>Alert
											</h4>${ error }
										</div>
									</c:if>
											</div>
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<label class="col-md-1 control-label">Title</label>
											<div class="col-md-11">
												<input name="adresstitle" type="text" class="form-control"
													placeholder="Address Title">
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label class="col-sm-2 control-label">City</label>
											<div class="col-sm-10">
												<select name="adresscityid" id="cityid"
													onchange="fncUserTown()" class="form-control select2"
													style="width: 100%;">
													<option value="-1">Please select your city</option>
													<c:if test="${not empty cityLs }">
														<c:forEach var="item" items="${cityLs }">
															<option value="${item.getCityid() }">${item.getCitytitle() }</option>
														</c:forEach>
													</c:if>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Town</label>
											<div class="col-sm-10">
												<select name="adresstownid" id="townid"
													onchange="fncUserNeighborhood()"
													class="form-control select2" style="width: 100%;">
													<option value="-1" selected="selected">Please select your town</option>
												</select>
											</div>
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label class="col-sm-2 control-label">Neighborhood</label>
											<div class="col-sm-10">
												<select name="adressneighborhoodid" id="neighborhoodid"
													onchange="fncUserStreet()" class="form-control select2"
													style="width: 100%;">
													<option value="-1" selected="selected">Please select your neighborhood</option>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">Street</label>
											<div class="col-sm-10">
												<select name="adressstreetid" id="streetid"
													class="form-control select2" style="width: 100%;">
													<option value="-1" selected="selected">Please select your street</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="adressdescription" class="col-md-2 control-label">Description</label>
											<div class="col-md-10">
												<textarea id="adressdescription" name="adressdescription" class="form-control"
													rows="3" placeholder="Description"></textarea>
											</div>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="adressinformation" class="col-md-2 control-label">Information</label>
											<div class="col-md-10">
												<textarea id="adressinformation" name="adressinformation" class="form-control"
													rows="3" placeholder="Information"></textarea>
											</div>
										</div>
									</div>
								</div>
								<!-- /.box-body -->

								<div class="box-footer"> 
									<button type="reset" id="reset" class="btn btn-default">Reset</button>
									<input type="submit" class="btn btn-info pull-right">
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
	<script src='<s:url value="/resources/adminJS/useraddress.js"></s:url>'></script>
</body>
</html>

