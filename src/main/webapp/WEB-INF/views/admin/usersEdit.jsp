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
								<h3 class="box-title">Users Edit Form</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->




							<c:if test="${ not empty lst }">

								<c:forEach items="${ lst }" var="item">


									<form
										action='<s:url value="/admin/usersEdit/${item.getCustomerid() }"></s:url>'
										method="POST">

										<div class="box-body">

											<div class="col-md-6">
												<div class="form-group">
													<label for="customername" class="col-sm-2 control-label">Name</label>

													<div class="col-sm-10">

														<input type="text" class="form-control" id="customername"
															name="customername" value="${item.getCustomername() }">
													</div>
												</div>
												<div class="form-group">
													<label for="costumersurname" class="col-sm-2 control-label">Surname</label>

													<div class="col-sm-10">
														<input type="text" class="form-control"
															id="costumersurname" name="customersurname"
															id="customersurname"
															value="${item.getCustomersurname() }">
													</div>
												</div>


											</div>

											<div class="col-md-6">

												<div class="form-group">
													<label for="customermail" class="col-sm-2 control-label">Email</label>

													<div class="col-sm-10">
														<input type="email" class="form-control" id="customermail"
															value="${item.getCustomermail() }" name="customermail">
													</div>
												</div>

												<div class="form-group">
													<label for="customercompanyid"
														class="col-sm-2 control-label">Company</label>

													<div class="col-sm-10">

														<select name="customercompanyid"
															class="form-control select2" style="width: 100%;"
															id="customercompanyid">
															<c:forEach items="${ lst }" var="item">
																<option value="${ item.getCompanyid() }">${ item.getCompanyname() }</option>
															</c:forEach>
														</select>

													</div>


												</div>

												<div class="form-group">
													<label for="customerphone" class="col-sm-2 control-label">Phone</label>

													<div class="col-sm-10">
														<c:forEach items="${ lst }" var="item">
															<input type="text" class="form-control"
																id="customerphone" value="${item.getCustomerphone() }"
																name="customerphone">
														</c:forEach>
													</div>
												</div>
												<div id="displayDivId" style="display: none;">
													<div class="form-group">
														<label for="customerpassword"
															class="col-sm-2 control-label">password</label>

														<div class="col-sm-10">
															<c:forEach items="${ lst }" var="item">
																<input type="password" class="form-control"
																	id="customerpassword"
																	value="${item.getCustomerpassword() }"
																	name="customerpassword">
															</c:forEach>
														</div>
													</div>
												</div>


											</div>

											<div class="col-md-12">
												<div class="form-group"></div>


											</div>

										</div>
										<!-- /.box-body -->
										<div class="box-footer">
											<button type="reset" class="btn btn-default">Reset</button>
											<button type="submit" class="btn btn-info pull-right">Update</button>





										</div>
										<!-- /.box-footer -->


									</form>


								</c:forEach>

							</c:if>






























						</div>

					</div>









					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Users Password Form</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->




							<c:if test="${ not empty lst }">

								<c:forEach items="${ lst }" var="item">


									<form
										action='<s:url value="/admin/usersPassword/${item.getCustomerid() }"></s:url>'
										method="POST">

										<div class="box-body">

											<div class="col-md-7">


												<div class="form-group">
													<label for="npassword" class="col-sm-2 control-label">New
														Password</label>

													<div class="col-sm-10">

														<input type="text" class="form-control" id="npassword"
															name="npassword" value="${item.getCustomerpassword() }">
													</div>
												</div>

												<div class="form-group">
													<label for="nnpassword" class="col-sm-2 control-label">New
														Password</label>

													<div class="col-sm-10">

														<input type="text" class="form-control" id="nnpassword"
															name="nnpassword" value="${item.getCustomerpassword() }">
													</div>
												</div>


												<div id="displayDivId" style="display: none;">
													<div class="form-group">
														<label for="customermail" class="col-sm-2 control-label">password</label>

														<div class="col-sm-10">
															<c:forEach items="${ lst }" var="item">
																<input type="password" class="form-control"
																	id="customermail"
																	value="${item.getCustomermail() }"
																	name="customermail">
															</c:forEach>
														</div>
													</div>
												</div>


												<div id="displayDivId" style="display: none;">
													<div class="form-group">
														<label for="customername" class="col-sm-2 control-label">password</label>

														<div class="col-sm-10">
															<c:forEach items="${ lst }" var="item">
																<input type="password" class="form-control"
																	id="customername"
																	value="${item.getCustomername() }"
																	name="customername">
															</c:forEach>
														</div>
													</div>
												</div>

												<div id="displayDivId" style="display: none;">
													<div class="form-group">
														<label for="customersurname"
															class="col-sm-2 control-label">password</label>

														<div class="col-sm-10">
															<c:forEach items="${ lst }" var="item">
																<input type="password" class="form-control"
																	id="customersurname"
																	value="${item.getCustomersurname() }"
																	name="customersurname">
															</c:forEach>
														</div>
													</div>
												</div>




												<div id="displayDivId" style="display: none;">
													<div class="form-group">
														<label for="customerphone" class="col-sm-2 control-label">password</label>

														<div class="col-sm-10">
															<c:forEach items="${ lst }" var="item">
																<input type="password" class="form-control"
																	id="customerphone"
																	value="${item.getCustomerphone() }"
																	name="customerphone">
															</c:forEach>
														</div>
													</div>
												</div>



												<div id="displayDivId" style="display: none;">
													<div class="form-group">
														<label for="customercompanyid" class="col-sm-2 control-label">password</label>

														<div class="col-sm-10">
															<c:forEach items="${ lst }" var="item">
																<input type="password" class="form-control"
																	id="customercompanyid"
																	value="${item.getCompanyid() }"
																	name="customercompanyid">
															</c:forEach>
														</div>
													</div>
												</div>






											</div>





										</div>



										<!-- /.box-body -->
										<div class="box-footer">
											<button type="reset" class="btn btn-default">Reset</button>
											<button type="submit" class="btn btn-info pull-right">Update</button>



										</div>
										<!-- /.box-footer -->


									</form>

								</c:forEach>

							</c:if>

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
	<script src='<s:url value="/resources/adminJS/Users.js"></s:url>'></script>





















</body>
</html>

