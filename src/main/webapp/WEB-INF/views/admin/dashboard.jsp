<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
  <title>Admin Panel | Yönetim Sayfası</title>
  <c:import url="/admin/css"></c:import>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
  
  <c:import url="/admin/header"></c:import>
  
  <!-- Left side column. contains the logo and sidebar -->
  <c:import url="/admin/menu"></c:import>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Homepage
        <small>Control panel</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Main</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Small boxes (Stat box) -->
      <div class="row">
        <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3>Categories</h3>
<br>
             
            </div>
            <div class="icon">
              <i class="ion-ios-pricetag-outline"></i>
            </div>
            <a href='<s:url value="/admin/category"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3>Products</h3>
<br>
              
            </div>
            <div class="icon">
              <i class="ion ion-stats-bars"></i>
            </div>
            <a href='<s:url value="/admin/product"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-blue">
            <div class="inner">
              <h3>Campaigns</h3>
			<br>
            </div>
            <div class="icon">
              <i class="ion-arrow-graph-down-right"></i>
            </div>
            <a href='<s:url value="/admin/campaigns"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
         <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-purple">
            <div class="inner">
              <h3>Orders</h3>
              <br>
             
            </div>
            <div class="icon">
              <i class="ion ion-bag"></i>
            </div>
            <a href='<s:url value="/admin/orderManagement"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-teal">
            <div class="inner">
              <h3>Image Upload</h3>
<br>
             
            </div>
            <div class="icon">
              <i class="ion-ios-cloud-upload-outline"></i>
            </div>
            <a href='<s:url value="/admin/imageupload/1"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>Users</h3>
<br>
             
            </div>
            <div class="icon">
              <i class="ion ion-person-add"></i>
            </div>
            <a href='<s:url value="/admin/users"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        
        <!-- ./col -->
        <div class="col-lg-4 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3>User Adress</h3>

              <br>
            </div>
            <div class="icon">
              <i class="ion-location"></i>
            </div>
            <a href='<s:url value="/admin/useraddress"></s:url>' class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
       
      </div>
      
      
            

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <c:import url="/admin/footer"></c:import>

  <!-- Control Sidebar -->
  <c:import url="/admin/sidebar"></c:import>
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  
</div>
<!-- ./wrapper -->

<c:import url="/admin/js"></c:import>
</body>
</html>

