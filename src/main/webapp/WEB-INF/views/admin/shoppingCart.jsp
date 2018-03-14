<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel | ShoppingCart</title>
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
					Order <small>Shopping Page</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li class="active">Order Shopping Cart</li>
				</ol>
				<hr>
				<div class="container-fluid row">
					<div class="col-lg-6 col-md-6 col-xs-6">

						<div class="callout callout-success">
							<h4 id="total">Your Basket Has ${ total } in Count</h4>
						</div>
					</div>
					<div class="col-lg-3 col-md-3 col-xs-3">
					
					
					<a onclick="fncOrderOpen(${custid})" class="btn btn-app pull-right">
							<i ></i>Sipariş Detayları
						</a>
					
					</div>
					<div class="col-lg-3 col-md-3 col-xs-3">
						<a onclick="window.history.back();" class="btn btn-app pull-right">
							<i class="fa fa-arrow-left"></i>Back
						</a>
					</div>
				</div>
				<div>
					<div class="col sm-8 ">
						<table class="table table-hover">
							<tbody>
								<tr id="rows1">
									<th style="width: 40px">Basketid</th>
									<th>Product</th>
									<th>Product Detail</th>
									<th>Category</th>
									<th>Sale Price</th>
									<th>Pieces</th>
									<th>Total Price</th>
									<th>Quantity</th>
									<th>Remove</th>

								</tr>
								<c:if test="${ not empty basketLs }">
									<c:forEach var="item" items="${ basketLs }">
										<tr id="${ item.getBasketid() }" role="setd">
											<td>${ item.getBasketid() }</td>
											<td>${ item.getProducttitle() }</td>
											<td>${ item.getProductdetail() }</td>
											<td>${ item.getCategorytitle() }</td>
											<td>${ item.getProductprice() }</td>
											<td>${ item.getBasketproductcount() }</td>
											<td>${ item.getBasketproductcount() * item.getProductprice()  }</td>
											<td><span class="input-group-btn">
													<button
														onclick="azalt(${item.getBasketid()},${item.getBasketproductcount() })"
														class="btn btn-default" data-dir="dwn">
														<span class="glyphicon glyphicon-minus"></span>
													</button>

													<button onclick="arttir(${item.getBasketid()})"
														class="btn btn-default" data-dir="up">
														<span class="glyphicon glyphicon-plus"></span>
													</button>
											</span></td>
											<td>
												<button onclick="ProductCartRemove(${item.getBasketid()})"
													type="button" style="color: red;" class="fa fa-trash-o"></button>
											</td>
									</c:forEach>

								</c:if>

							</tbody>
						</table>

					</div>
					
				</div>
				
				<div class="container-fluid row">
					<div class="col-lg-10 col-md-10 col-xs-10">
					</div>
					<div class="col-lg-2 col-md-2 col-xs-2">
						<button onclick="fncShoppingOrdersCart(${custid})" type="button" class="btn btn-block btn-warning">Sepeti Onayla</button>
					</div>
				</div>
			</section>
			<section class="content">
				<div class="row"></div>
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

