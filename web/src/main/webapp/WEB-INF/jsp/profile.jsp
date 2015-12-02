<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${basedir}/resources/css/profile.css">
<!-- <link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"> -->
<script src="${basedir}/resources/js/profile.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">
<body>
	<div class="container">
		<div class="row profile custom_form shadow">
			<div class="col-md-3 ">
				<div class="profile-sidebar">
					<div class="profile-userpic">
						<img src="${basedir}/resources/images/unknown_user.png"
							class="img-responsive" alt="">
					</div>
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">${name}</div>
						<div class="profile-usertitle-email">${email}</div>
					</div>
					<div class="profile-usermenu">
						<ul class="nav">
							<li id="public" class="active"><a href="#"
								onclick="return false;"> <i
									class="glyphicon glyphicon-eye-open"></i> Public files
							</a></li>
							<li id="private"><a href="#" onclick="return false;"> <i
									class="glyphicon glyphicon-lock"></i> Private files
							</a></li>
							<li><a href="#" onclick="return false;"> <i
									class="glyphicon glyphicon-user"></i> Account Settings
							</a></li>
							<li><a href="upload"> <i
									class="glyphicon glyphicon glyphicon-upload"></i> Upload file
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="profile-content">
					<table class="table table-bordered" cellspacing="0"
						width="100%" id="result_table">
						<thead>
							<tr>
								<th>Title</th>
								<th>Description</th>
								<th>Created</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Title</th>
								<th>Description</th>
								<th>Created</th>
								<th></th>
							</tr>
						</tfoot>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
</body>
</html>