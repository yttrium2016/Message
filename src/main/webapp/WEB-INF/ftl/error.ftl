<#-- 取得 应用的绝对根路径 -->  
<#assign basePath=request.contextPath> 
    <!DOCTYPE html >
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录界面</title>
    <load href="${basePath}/js/jquery.js"/>
<link href="${basePath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${basePath}/css/login.css" rel="stylesheet">
</head>
<body>
<div class="alert" role="alert"><s:actionerror/></div>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand"  
				href="">留言板错误界面</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"></li>
					<!-- <li></li>  -->
					<!-- <li><a href="#contact">Contact</a></li> -->
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<a href="javascript:history.go(-1)" ><h1>${error!"未知错误 应该是404吧"}<h1></a>
	</div>
	<script src="${basePath}/js/ie10-viewport-bug-workaround.js"></script>
<div class="container body-content">
		<hr />
		<footer>
			<p>&copy; 2017 - 留言板2.0版本</p>
		</footer>
	</div>
</body>
</html>

