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
						<a href='<s:url value="/admin/userAddressAdd"></s:url>' class="btn btn-app pull-right"> <i class="fa fa-plus"></i>
							Add
						</a>
					</div>
					
				<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">User Address List</h3>

								<div class="box-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<input id="ara" name="ara" type="text" name="table_search"
											class="form-control pull-right" placeholder="Search">

									<div class="input-group-btn">
			                          <button  onclick="pageSearch('0')" type="submit" class="btn btn-default">
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
											<th style="width: 40px">Id</th>
											<th>Customer Name</th>
											<th>Customer Surname</th>
											<th>Title</th>
											<th>City</th>
											<th>Town</th>
											<th>Neighborhood</th>
											<th>Street</th>
											<th>Description</th>
											<th>Information</th>
											<th style="width: 130px;">Transaction</th>
										</tr>
										
										<c:if test="${ not empty ls }">
										
											<c:forEach items="${ ls }" var="item">
												<tr id="${ item.getAdressid()}" role="sil">
												<td>${ item.getAdressid()}</td>
													<td>${ item.getCustomername()}</td>
													<td>${ item.getCustomersurname()}</td>
													<td>${ item.getAdresstitle()}</td>
													<td>${ item.getCitytitle()}</td>
													<td>${ item.getTowntitle()}</td>
													<td>${ item.getNeighborhoodtitle()}</td>
													<td>${ item.getStreettitle()}</td>
													<td>${ item.getAdressdescription()}</td>
													<td>${ item.getAdressinformation()}</td>
													<td>
														<button onclick="fncDelete(${ item.getAdressid() }, 'adressid' ,'adress')" type="button" class="btn btn-danger btn-sm">Sil</button>
														
                                             <a href='<s:url value="/admin/userAddressUpdate/${ item.getAdressid() }"></s:url>' type="submit" class="btn btn-primary btn-sm">Düzenle</a>
													</td>
												</tr>
											</c:forEach>
											
										</c:if>
										
									</tbody>
								</table>
							</div>
							<!-- /.box-body -->

							<div class="box-footer clearfix">
								<ul class="pagination pagination-sm no-margin pull-right"  id="pages">
									
								</ul>
							</div>

							<c:if test="${ empty ls }">
									<div style="text-align: center; padding: 10px;">Burada Data Yok !</div>
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
	<script src='<s:url value="/resources/adminJS/useraddress.js"></s:url>'></script>
</body>
</html>

