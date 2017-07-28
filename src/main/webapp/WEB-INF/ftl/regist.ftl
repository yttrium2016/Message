<#-- 取得 应用的绝对根路径 -->  
<#assign basePath=request.contextPath> 
<!DOCTYPE html >
<html lang="zh-CN">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册界面</title>
<load href="${basePath}/js/jquery.js" />
<link href="${basePath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${basePath}/css/regist.css" rel="stylesheet">

<script type="text/javascript">  
        /** 
         * 换验证码图片 
         */  
         function change(img) {  
            img.src = '${basePath}/coptcha.do?send=' + Math.random();  
         }   
    </script>  
</head>

<body>
<div class="alert" role="alert"><s:actionerror/></div>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">留言板注册界面</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"></li>
					<li></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="my">
		<H2>
			<label class="control-label">注 册</label>
		</H2>
	</div>



	<div class="container">

		<form class="form-horizontal" action="${basePath}/sendMail.do" method="post">


			<div class="form-group">
				<label for="emailAddress" class="col-sm-3 control-label">注册邮箱:</label>
				<div class="divUser col-sm-9">
					<input type="email" name="emailAddress" class="form-control "
						id="inputUsername" placeholder="请输入邮箱名" required autofocus />
				</div>
			</div>




			<div class="form-group">
				<label for="code" class="col-sm-3 control-label">验证码:</label>
				<div class="col-sm-6 ">
					<input type="text" name="code" class="form-control" id="code"
						placeholder="请输入验证码" required />
				</div>
				<div class="col-sm ">
					<img onclick="change(this)" src="${basePath}/coptcha.do"/> 
				</div>
			</div>


			<div class="form-group">
				<button class="btn btn-lg btn-primary register" type="submit">注册</button>
				<button class="btn btn-lg btn-primary reset" type="reset">重置</button>
				<a class="btn btn-lg btn-primary" href="#" onclick="location.href='${basePath}/login.html'" role="button">返回</a> 
			</div>
		</form>


	</div>
<div class="container body-content">
		<hr />
		<footer>
			<p>&copy; 2017 - 留言板2.0版本</p>
		</footer>
	</div>

</body>
</html>
