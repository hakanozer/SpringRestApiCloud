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
					Campaigns <small>Campaign Edit Page</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href='<s:url value="/admin/dashboard"></s:url>'><i
							class="fa fa-dashboard"></i> Dashboard</a></li>
					<li class="active">Campaign Edit</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">

					<div class="col-xs-12">
						<a href='<s:url value="/admin/campaigns"></s:url>' class="btn btn-app pull-right">
							<i class="fa fa-arrow-left"></i>Back
						</a>
					</div>


					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">Campaign Edit Form</h3>
							</div>
							<!-- /.box-header -->
							<!-- form start -->
							<c:if test="${ not empty error }">
								<div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert"
										aria-hidden="true">×</button>
									<h4>
										<i class="icon fa fa-ban"></i>Alert
									</h4>${ error }
								</div>
							</c:if>
							<c:if test="${ not empty ls }">
								<c:forEach items="${ ls }" var="item">
									<form class="form-horizontal"
										action='<s:url value="/admin/campaignEdit"></s:url>'
										method="post">
										<div class="box-body">
											<input type="hidden" name="campaingid"
												value="${item.getCampaignid() }">

											<div class="col-md-6">
												<div class="form-group">
													<label for="campaigntitle" class="col-sm-2 control-label">Title</label>

													<div class="col-sm-10">
														<input value="${item.getCampaigntitle() }"
															name="campaigntitle" type="text" class="form-control"
															id="campaigntitle" placeholder="Title">
													</div>
												</div>
												<div class="form-group">
													<label for="campaignstatu" class="col-sm-2 control-label">Status</label>
													<div class="col-sm-10">
														<select class="form-control" id="campaignstatu"
															name="campaignstatu">

															<option value="0">Price</option>


															<option value="1">Percent</option>


														</select>
													</div>
												</div>
												<!-- Date -->
												<div class="form-group">
													<label for="datepicker" class="col-sm-2 control-label">Start
														Date</label>
													<div class="col-sm-10">
														<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<input type="text" class="form-control pull-right"
																id="datepicker" name="campaignstartdate" value="${item.getCampaignstartdate() }">
														</div>
													</div>
													<!-- /.input group -->
												</div>
												<!-- /.form group -->

											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label for="campaigncompanyid"
														class="col-sm-2 control-label">Company</label>

													<div class="col-sm-10">
														<input value="${item.getCampaigncompanyid() }"
															name="campaigncompanyid" type="text" class="form-control"
															id="campaigncompanyid" placeholder="Company Name"
															readonly>
													</div>
												</div>
												<div class="form-group">
													<label for="campaigntolerance"
														class="col-sm-2 control-label">Tolerance</label>

													<div class="col-sm-10">
														<input value="${item.getCampaigntolerance() }"
															name="campaigntolerance" type="text" class="form-control"
															id="campaigntolerance" placeholder="Campaign Tolerance">
													</div>
												</div>
												<!-- Date -->
												<div class="form-group">
													<label for="datepicker2" class="col-sm-2 control-label">End
														Date</label>
													<div class="col-sm-10">
														<div class="input-group date">
															<div class="input-group-addon">
																<i class="fa fa-calendar"></i>
															</div>
															<input type="text" class="form-control pull-right"
																id="datepicker2" name="campaignenddate" value="${item.getCampaignenddate() }">
														</div>
													</div>
													<!-- /.input group -->
												</div>
												<!-- /.form group -->
												
											</div>



											<div class="col-md-12">
												<div class="form-group">

													<label for="editor1" class="col-sm-1 control-label">Detail</label>
													<div class="col-sm-11">
														<textarea id="editor1" name="campaigndetail" rows="10"
															cols="80">
                                           ${item.getCampaigndetail() }
                    </textarea>
													</div>
												</div>


											</div>

										</div>
										<!-- /.box-body -->

										<div class="box-footer">
											<button type="reset" class="btn btn-default">Reset</button>
											<button type="submit" class="btn btn-info pull-right">Save
											</button>
										</div>
									</form>
								</c:forEach>
							</c:if>

							<!-- /.box-footer -->
						</div>

					</div>

				</div>


			</section>
		</div>
		<c:import url="/admin/footer"></c:import>
		<c:import url="/admin/sidebar"></c:import>
	</div>
	<c:import url="/admin/js"></c:import>
	<script src='<s:url value="/resources/adminJS/Campaigns.js"></s:url>'></script>



</body>
</html>

