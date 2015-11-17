<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ include file="base.jsp"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<!DOCTYPE html>
<html>
<title>Welcome</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${basedir}/resources/css/main.css">
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery-1.11.3.min.js"></script>
<!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script> -->
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery.localscroll-1.2.7-min.js"></script>
<script type="text/javascript"
	src="${basedir}/resources/js/lib/jquery.scrollTo-1.4.2-min.js"></script>
<script src="${basedir}/resources/js/main.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div id="sticky-anchor"></div>
				<div class="input-group" id="sticky">
					<input type="text" class="form-control" placeholder="Search..." />
					<div class="input-group-btn">
						<div class="btn-group" role="group">
							<div class="dropdown dropdown-lg">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-expanded="false">
									<span class="caret"></span>
								</button>
								<div class="dropdown-menu dropdown-menu-right" role="menu">
									<form class="form-horizontal" role="form">
										<div class="form-group">
											<label for="filter">Filter by</label> <select
												class="form-control">
												<option value="0" selected>All categories</option>
												<option value="1">Audio</option>
												<option value="2">Video</option>
												<option value="3">Image</option>
												<option value="4">Text</option>
											</select>
										</div>
										<div class="form-group">
											<label for="contain">Author</label> <input
												class="form-control" type="text" />
										</div>
										<div class="form-group">
											<label for="contain">Contains the words</label> <input
												class="form-control" type="text" />
										</div>
										<button type="submit" class="btn btn-primary">
											<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										</button>
									</form>
								</div>
							</div>
							<button type="button" class="btn btn-primary">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="intro">
		<div class="story">
			<div class="float-left">
				<h2>Что такое «parallax scrolling» ?</h2>
				<p>Parallax scrolling — это процесс 2D анимации, который создаёт
					иллюзию глубины. Анимация передних слоёв быстрее, чем анимация
					фона..</p>
			</div>
		</div>
		<!--.story-->
	</div>
	<!--#intro-->

	<div id="second">
		<div class="story">
			<div class="bg"></div>
			<div class="float-right">
				<h2>Основная идея параллакса</h2>
				<p>Когда вы наблюдаете за движущимся автомобилем, вам кажется,
					что объекты расположенные перед автомобилем, движутся быстрее, чем
					объекты расположенные за автомобилем.</p>
				<p>Parallax scrolling использует тот же принцип, чтобы заставить
					зрителя думать, что он наблюдает за 3D сценой.</p>
			</div>
		</div>
		<!--.story-->

	</div>
	<!--#second-->

	<div id="third">
		<div class="story">
			<div class="float-left">
				<h2>Принцип работы</h2>
				<p>Вы можете скролить обычным способом, использовать меню
					навигации в правой части страницы или кнопки следующий/предыдущий,
					которые появляются под каждой статьёй. Страница содержит три,
					независимо друг от друга анимированных слоя, для создания иллюзии
					глубины.</p>
			</div>
		</div>
		<!--.story-->
	</div>
	<!--#third-->

	<%
		for (GrantedAuthority c : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
	%>
	<h2><%=c%></h2>
	<%
		}
	%>
</body>
</html>