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
			<div class="row">
				<section class="content">


					<div class="col-xs-12">
						<a onclick="window.history.back();" class="btn btn-app pull-right">
							<i class="fa fa-arrow-left"></i>Back
						</a>
					</div>
					<div id="firststep" class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title">User Information</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form class="form-horizontal"
									action='<s:url value="/admin/update"></s:url>' method="POST">
									<div class="box-body">

										<div class="form-group">
											<img class="profile-user-img img-responsive img-circle"
												src='<s:url value="/resources/dist/img/defaultuser.png"></s:url>'
												alt="User profile picture"><br>
											<div class="col-md-12" align="center">
												<input type="file" id="exampleInputFile">
											</div>
										</div>
										<div class="form-group">
											<label for="aname" class="col-sm-3 control-label">Name</label>

											<div class="col-sm-9">
												<input type="text" class="form-control" id="aname"
													name="aname" placeholder="Name" value="${ adm.getAname() }">
											</div>
										</div>
										<div class="form-group">
											<label for="asurname" class="col-sm-3 control-label">Surname</label>

											<div class="col-sm-9">
												<input type="text" class="form-control" id="asurname"
													name="asurname" placeholder="Surname"
													value="${ adm.getAsurname() }">
											</div>
										</div>
										<div class="form-group">
											<label for="aphone" class="col-sm-3 control-label">Phone</label>

											<div class="col-sm-9">
												<input type="text" name="aphone" id="aphone"
													class="form-control" placeholder="(---)--- -- --"
													value="${ adm.getAphone() }">
											</div>
										</div>

										<div class="form-group">
											<label for="amail" class="col-sm-3 control-label">Email</label>

											<div class="col-sm-9">
												<input type="email" class="form-control" id="amail"
													name="amail" placeholder="Email"
													value="${ adm.getAmail() }">
											</div>
										</div>


										<hr>
										<div class="box-header with-border">
											<h3 class="box-title">Company Information</h3>
										</div>
										<div class="form-group">
											<label for="companyname" class="col-sm-3 control-label">Company
												Name</label>

											<div class="col-sm-9">
												<input type="text" class="form-control" id="companyname"
													name="companyname" placeholder="Company Name"
													value="${ com.getCompanyname() }">
											</div>
										</div>

										<div class="form-group">
											<label for="companyphone" class="col-sm-3 control-label">Company
												Phone</label>

											<div class="col-sm-9">
												<input type="text" name="companyphone" id="companyphone"
													class="form-control" placeholder="(---)--- -- --"
													value="${ com.getCompanyphone() }">
											</div>
										</div>

										<div class="form-group">
											<label for="companyfax" class="col-sm-3 control-label">Company
												Fax</label>

											<div class="col-sm-9">
												<input type="text" name="companyfax" id="companyfax"
													class="form-control" placeholder="(---)--- -- --"
													value="${ com.getCompanyfax() }">
											</div>
										</div>

										<div class="form-group">
											<label for="companymail" class="col-sm-3 control-label">Company
												Mail</label>

											<div class="col-sm-9">
												<input type="email" class="form-control" id="companymail"
													name="companymail" placeholder="Company Mail"
													value="${ com.getCompanymail() }">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Title</label>
											<div class="col-sm-9">
												<input name="adresstitle" id="adresstitle" type="text"
													class="form-control" placeholder="Adress Title">
											</div>

										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">City</label>
											<div class="col-sm-9">
												<select id="cityid" name="adresscityid" onchange="fncUserTown()"
													class="form-control select2" style="width: 100%;">
													
													<c:if test="${ empty adr.getAdresscityid() }"><option value="0" >Please select your
														city</option></c:if>
													<c:if test="${ not empty adr.getAdresscityid() }">
													<option value="${adr.getAdresscityid() }">${vca.getCitytitle()  }</option>
													</c:if>
													
													
													
													<c:if test="${not empty cityLs }">
														<c:forEach var="item" items="${cityLs }">
															<option value="${item.getCityid() }">${item.getCitytitle() }</option>
														</c:forEach>
													</c:if>
												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">Town</label>
											<div class="col-sm-9">
												<select id="townid" name="adresstownid" onchange="fncUserNeighborhood()"
													class="form-control select2" style="width: 100%;">
													
													<c:if test="${ empty adr.getAdresstownid() }"><option value="0" >Please select your
														town</option></c:if>
													<c:if test="${ not empty adr.getAdresstownid() }">
													<option value="${adr.getAdresstownid() }">${vca.getTowntitle() }</option>
													</c:if>
													
													
												</select>
											</div>
										</div>

										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">Neighborhood</label>
											<div class="col-sm-9">
												<select id="neighborhoodid" name="adressneighborhoodid" onchange="fncUserStreet()"
													class="form-control select2" style="width: 100%;">
													
													<c:if test="${ empty adr.getAdressneighborhoodid() }"><option value="0" >Please select your
														neighborhood</option></c:if>
													<c:if test="${ not empty adr.getAdressneighborhoodid() }">
													<option value="${adr.getAdressneighborhoodid() }">${vca.getNeighborhoodtitle() }</option>
													</c:if>
													
													

												</select>
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">Street</label>
											<div class="col-sm-9">
												<select id="streetid" name="adressstreetid" class="form-control select2"
													style="width: 100%;">
													
													<c:if test="${ empty adr.getAdressstreetid() }"><option value="0" >Please select your
														Street</option></c:if>
													<c:if test="${ not empty adr.getAdressstreetid() }">
													<option value="${adr.getAdressstreetid() }">${vca.getStreettitle() }</option>
													</c:if>
													
													
												</select>
											</div>
										</div>

										<div class="form-group">
											<label for="inputPassword3" class="col-sm-3 control-label">Description</label>
											<div class="col-sm-9">
												<textarea id="description" name="adressdescription" class="form-control" rows="3"
													placeholder="Enter ..."></textarea>
											</div>
										</div>
									</div>

									<!-- /.box-body -->
									<div class="box-footer">
										<div class="row">
											<div class="col-sm-2">
												<button type="reset" class="btn btn-default">Reset</button>
											</div>
											<div class="col-sm-8"></div>
											<div class="col-sm-2">
												<button id="save" name="save"
													class="btn btn-info pull-right">Save</button>
											</div>
										</div>
									</div>
								</form>
								<!-- /.box-footer -->

							</div>
						</div>
						<div class="col-md-3"></div>
					</div>
				</section>
			</div>
		</div>
		<c:import url="/admin/footer"></c:import>
		<c:import url="/admin/sidebar"></c:import>
	</div>
	<c:import url="/admin/js"></c:import>
	<script src='<s:url value="/resources/adminJS/Sample.js"></s:url>'></script>
		<script src='<s:url value="/resources/adminJS/useraddress.js"></s:url>'></script>
</body>
</html>

