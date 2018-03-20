<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img
					src='<s:url value="/resources/dist/img/user2-160x160.jpg"></s:url>'
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${ adm.getAname() }${ adm.getAsurname() }</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">MAIN NAVIGATION</li>
			<li class="active treeview"><a href="#"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span> <span
					class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>

				<ul class="treeview-menu">
					<li <c:if test="${ sayfa == 'dashboard' }"> class="active" </c:if>><a
						href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-circle-o"></i> Homepage</a></li>

					<li <c:if test="${ sayfa == 'category' }"> class="active" </c:if>><a
						href='<s:url value="/admin/category"></s:url>'><i
							class="fa fa-circle-o"></i>Category</a></li>

					<li <c:if test="${ sayfa == 'product' }"> class="active" </c:if>><a
						href='<s:url value="/admin/product"></s:url>'><i
							class="fa fa-circle-o"></i>Product</a></li>

					<li <c:if test="${ sayfa == 'campaigns' }"> class="active" </c:if>><a
						href='<s:url value="/admin/campaigns"></s:url>'><i
							class="fa fa-circle-o"></i>Campaigns</a></li>

					<li
						<c:if test="${ sayfa == 'orderManagement' }"> class="active" </c:if>><a
						href='<s:url value="/admin/orderManagement"></s:url>'><i
							class="fa fa-circle-o"></i>Order Management</a></li>

					<li <c:if test="${ sayfa == 'users' }"> class="active" </c:if>><a
						href='<s:url value="/admin/users"></s:url>'><i
							class="fa fa-circle-o"></i>Users</a></li>

					<li <c:if test="${ sayfa == 'useradress' }"> class="active" </c:if>><a
						href='<s:url value="/admin/useraddress"></s:url>'><i
							class="fa fa-circle-o"></i>User Address</a></li>

					<li
						<c:if test="${ sayfa == 'image/index' }"> class="active" </c:if>><a
						href='<s:url value="/admin/imageupload/1"></s:url>'><i
							class="fa fa-circle-o"></i>Image Upload</a></li>

				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>