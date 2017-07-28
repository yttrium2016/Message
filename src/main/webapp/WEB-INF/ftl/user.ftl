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
<link href="${basePath}/css/user.css" rel="stylesheet">

</head>

<body>
<div class="alert" role="alert"> <s:actionerror/></div>
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

		<form class="form-horizontal" action="${basePath}/saveUser.do" method="post">


			<div class="form-group">
				<label for="userEmail" class="col-sm-3 control-label">注册邮箱:</label>
				<div class="divUser col-sm-9">
				<p class="form-control-static">${address!}</p>
				<input name = "userEmail" value="${address!}" hidden="hidden">
				</div>
			</div>


		<div class="form-group">
            <label for="inputName" class="col-sm-3 control-label">用户名:</label>
            <div class="col-sm-9">
                <input type="text" name="userName" class="form-control" id="inputName" placeholder="请输入用户名" required/> 
            </div>
        </div>

			<div class="form-group">
            <label for="inputPassword" class="col-sm-3 control-label">密码:</label>
            <div class="divPassword col-sm-9">
                 <input type="password" name="password" class="form-control" id="inputPassword" placeholder="请输入密码" required/> 
            </div>
        </div>

        <div class="form-group">
            <label for="inputRePassword" class="col-sm-3 control-label">确认密码:</label>
            <div class="divPassword col-sm-9">
                 <input type="password" name="repassword" class="form-control" id="inputRePassword" placeholder="请重新输入密码" required/> 
            </div>
        </div>


        
        

			<div class="form-group">
				
				<button class="btn btn-lg btn-primary reset" type="reset">重置</button>
				<button class="btn btn-lg btn-primary register" type="submit">注册</button>
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
