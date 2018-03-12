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
					Order <small>Order Page</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> orderManagement</a></li>
					<li class="active">Order</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">

					<div class="container-fluid row">
					<div class="col-lg-4 col-md-4 col-xs-4">
					
					</div>
					<div class="col-lg-5 col-md-5 col-xs-5">
					
					
					
					</div>
					<div class="col-lg-3 col-md-3 col-xs-3">
						<a onclick="window.history.back();" class="btn btn-app pull-right">
							<i class="fa fa-arrow-left"></i>Back
						</a>
					</div>
				</div>
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Responsive Hover Table</h3>


							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive no-padding">
								<table class="table table-hover">
									<tbody>
										<tr id="orderrows">
											<th style="width: 40px">Orderid</th>
											<th>Product</th>
											<th>Detail</th>
											<th>Customer</th>
											<th>Company</th>
											<th>Count</th>
											<th>Status</th>
											<th>Total Price</th>
											<th>Order Date</th>
											<th>Operation</th>

										</tr>

										<c:if test="${ not empty viewOrderLs }">

											<c:forEach items="${ viewOrderLs }" var="item">
												<tr id="${item.getOrderid()}" role="sil">
													<td>${item.getOrderid()}</td>
													<td>${item.getProducttitle()}</td>
													<td>${item.getProductdetail()}</td>
													<td>${item.getCustomername()}</td>
													<td>${item.getCompanyname()}</td>
													<td>${item.getOrdercounts()}</td>
													<td>${item.getOrderstatus()}</td>
													<td>${item.getOrdertotalprice()}</td>
													<td>${item.getOrderdate()}</td>
													<c:if test="${item.getOrderstatus()==0}">
														<td>
															<button onclick="fncStatusChange(${item.getOrderid()})"
																type="button" class="btn btn-light">deliver</button>
														</td>
													</c:if>
													<c:if test="${item.getOrderstatus()== 1}">
														<td>
															<button disabled
																onclick="fncStatusChange(${item.getOrderid()})"
																type="button" class="btn btn-light">delivered</button>
														</td>
													</c:if>

												</tr>
											</c:forEach>

										</c:if>

									</tbody>
								</table>
							</div>
							<!-- /.box-body -->

							<div class="box-footer clearfix">
								<ul class="pagination pagination-sm no-margin pull-right"
									id="pageLsorder">

								</ul>
							</div>

							<c:if test="${ empty viewOrderLs }">
								<div style="text-align: center; padding: 10px;">Burada
									Data Yok !</div>
							</c:if>
						</div>
						<!-- /.box -->
					</div>
				</div>


			</section>
		</div>
		<c:import url="/admin/footer"></c:import>
		<c:import url="/admin/sidebar"></c:import>
	</div>
	<c:import url="/admin/js"></c:import>
	<script
		src='<s:url value="/resources/adminJS/OrderProduct.js"></s:url>'></script>
</body>
</html>

