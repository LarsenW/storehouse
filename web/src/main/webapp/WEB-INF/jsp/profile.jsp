<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
							<li id="account_settings"><a href="#"
								onclick="return false;"> <i class="glyphicon glyphicon-user"></i>
									Account Settings
							</a></li>
							<li id="upload"><a href="#" onclick="return false;"> <i
									class="glyphicon glyphicon glyphicon-upload"></i> Upload file
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="profile-content">
					<table class="table table-bordered" id="result_table">
						<thead>
							<tr>
								<th>Title</th>
								<th>Category</th>
								<th>Created</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Title</th>
								<th>Category</th>
								<th>Created</th>
								<th></th>
							</tr>
						</tfoot>
						<tbody>
						</tbody>
					</table>
					<div id="upload_form_wrapper" class="panel panel-default"
						style="display: none;">
						<div class="panel-heading">
							<h3 class="panel-title glyphicon glyphicon-upload">Upload
								new file</h3>
						</div>
						<div class="panel-body">
							<form:form method="POST" modelAttribute="itemForm"
								action="upload" enctype="multipart/form-data">
								<div class="form-group">
									<form:input type="text" name="name" id="name" path="name"
										class="form-control input-sm glowing-border"
										placeholder="Name" />
								</div>
								<div>
									<form:textarea class="form-control" rows="3" id="comment"
										path="description" placeholder="File description..." />
								</div>
								<br>
								<br>
								<table>
									<tr>
										<td><form:radiobutton path="privacy" value="false" />Public</td>
										<td><form:radiobutton path="privacy" value="true" />Private</td>
									</tr>
								</table>
								<br>
								<br>
								<div class="input-group">
									<span class="input-group-btn"> <span
										class="btn btn-info btn-file"> Browse… <input
											type="file" name="file">
									</span>
									</span> <input id="file_upload" type="text" class="form-control"
										placeholder="file is not chosen" readonly="readonly">
								</div>
								<br>
								<div id="upload_button">
									<input type="submit" value="Upload"
										class="btn btn-primary btn-block">
								</div>
							</form:form>
						</div>
					</div>
					<div id="account_settings_form_wrapper" class="box box-primary"
						style="display: none;">
						<div class="box-header">
							<h3 class="box-title" style="text-align: center;">Account
								settings</h3>
						</div>
						<div class="box-body">
							<hr>
							<form>
								<div class="form-group">
									<label for="new_email">New email</label> <input type="email"
										class="form-control" id="new_email" placeholder="Enter email">
								</div>
								<div class="box-footer">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
							</form>
							<hr>
							<form action="">
								<div class="form-group">
									<label for="old_password">Old password</label> <input
										type="password" class="form-control" id="old_password"
										placeholder="Password">
								</div>
								<div class="form-group">
									<label for="new_password">New password</label> <input
										type="password" class="form-control" id="new_password"
										placeholder="Password">
								</div>
								<div class="form-group">
									<label for="confirm_password">Confirm password</label> <input
										type="password" class="form-control" id="confirm_password"
										placeholder="Password">
								</div>
								<div class="box-footer">
									<button type="submit" class="btn btn-primary">Save</button>
								</div>
							</form>
						</div>
						<hr>
						<form>
							<div class="input-group">
								<span class="input-group-btn"> <span
									class="btn btn-info btn-file"> Browse… <input
										type="file" name="file">
								</span>
								</span> <input id="avatar_upload" type="text" class="form-control"
									placeholder="file is not chosen" readonly="readonly">
							</div>
							<br>
							<div class="box-footer">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>