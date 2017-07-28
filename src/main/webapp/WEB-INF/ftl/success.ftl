<#-- 取得 应用的绝对根路径 -->  
<#assign basePath=request.contextPath>

<!DOCTYPE html >
<html lang="zh-CN">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<load href="${basePath}/js/jquery.js" />
<link href="${basePath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${basePath}/css/success.css" rel="stylesheet">
<title>注册成功</title>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	onload = function() {
		function tiaozhuan() {
			window.location = '${basePath}/login.html';
		}
		setTimeout(tiaozhuan, 2000);
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">${success!}</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"></li>
					<li></li>
					<!-- <li><a href="#contact">Contact</a></li> -->
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="jumbotron">
			<h1>${success!}</h1>
			<p>${doc!}</p>
			<p>
				<a onclick="location.href='${basePath}/login.html'" class="btn btn-primary btn-lg" href="#" role="button">返回登录界面</a>
			</p>
		</div>
	</div>
<div class="container body-content">
		<hr />
		<footer>
			<p>&copy; 2017 - 留言板2.0版本</p>
		</footer>
	</div>
</body>
</html>
