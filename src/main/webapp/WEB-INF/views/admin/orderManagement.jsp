<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<title>Admin Panel | Order Management</title>
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
							class="fa fa-dashboard"></i> Order</a></li>
					<li class="active">Order Shopping Cart</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-sm-10">
						<div class="col-sm-4">
							<label class="col-sm-3">Customers</label> <select name="customer" id="customer" onchange="ajaxShoppingCart()"
								class="form-control col-sm-4">
								<option value=0>Select Customer</option>
								<c:forEach var="item" items="${customer}">
									<option value="${item.getCustomerid()}">${item.getCustomername()}
										&nbsp ${item.getCustomersurname()}</option>
								</c:forEach>

							</select>

						</div>
						<div class="col-sm-6"></div>


					</div>
					<div class="col-sm-2">

					<div class="info-box " style="cursor: pointer;" >
					
						<a onclick="fncShoppingCart()" ><span class="info-box-icon bg-red "><i
								class="ion ion-ios-cart-outline"></i></span></a>

							<div class="info-box-content ">
								<span class="info-box-text" >Cart</span> <span
									class="info-box-number" id="cartcount"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						
						
						
						
					</div>
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">Order Management Table</h3>

								<div class="box-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<input id="ordercall" name="ordercall" type="text"
											name="table_search" class="form-control pull-right"
											placeholder="Search">

										<div class="input-group-btn">
											<button onclick="pageSearch('0')" type="submit"
												class="btn btn-default">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive no-padding">
								<table class="table table-hover">
									<tbody>
										<tr id="rows">
											<th style="width: 40px">Productid</th>
											<th>Product</th>
											<th>Product Detail</th>
											<th>Category</th>
											<th>Campaign</th>
											<th>Detail</th>
											<th>Price</th>
											<th>Sale Price</th>
											<th style="width: 130px;">Add to Cart</th>
										</tr>

										<c:if test="${ not empty productList }">

											<c:forEach items="${ productList }" var="item">
												<tr id="${ item.getProductid() }" role="sil">
													<td>${ item.getProductid() }</td>


													<td>${ item.getProducttitle()}</td>
													<td>${ item. getProductdetail()}</td>
													<td>${ item.getCategorytitle()}</td>
													<c:if test="${ item.getCampaigntitle()== null}">
														<td></td>
													</c:if>
													<c:if test="${  item.getCampaigntitle()!= null}">
														<td>${ item.getCampaigntitle()}</td>
													</c:if>
													<c:if test="${ empty item.getCampaigndetail()}">
														<td></td>
													</c:if>
													<c:if test="${ not empty item.getCampaigndetail()}">
														<td>${ item.getCampaigndetail()}</td>
													</c:if>



													<td>${ item.getProductprice()}</td>
													<td>
													<c:if test="${ item.getCampaigntitle() != null }">
															<c:if test="${ item.getCampaignstatu() == 0 }">
																<c:set var="balance"
																	value="${ item.getProductprice() - (item.getProductprice() * (item.getCampaigntolerance() / 100)) }" />
																<fmt:formatNumber type="number" maxIntegerDigits="4"
																	value="${balance}" />
															</c:if>
															<c:if test="${ item.getCampaignstatu() == 1 }">
																<c:set var="balance1"
																	value="${ item.getProductprice()  - item.getCampaigntolerance()}" />
																<fmt:formatNumber type="number" maxIntegerDigits="4"
																	value="${balance1}" />
															</c:if>

													</c:if> 
													<c:if test="${ item.getCampaigntitle() ==null}">
														${ item.getProductprice()}
													</c:if>
													</td>
													<td>
														<button onclick="ShoppingCartAdd(${item.getProductid()},1)" type="button" style="color: green;"
															class="fa fa-cart-plus"></button>
													
													</td>
												</tr>
											</c:forEach>

										</c:if>

									</tbody>
								</table>
							</div>
							<!-- /.box-body -->

							<div class="box-footer clearfix">
								<ul class="pagination pagination-sm no-margin pull-right"
									id="pageorder">

								</ul>
							</div>

							<c:if test="${ empty productList }">
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
