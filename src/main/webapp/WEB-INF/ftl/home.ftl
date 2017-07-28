<#-- 取得 应用的绝对根路径 -->  
<#assign basePath=request.contextPath> 
<!DOCTYPE html >
<html lang="zh-CN">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>留言板</title>
    <load href="${basePath}/js/jquery.js"/>
<link href="${basePath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${basePath}/css/home.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><label>留言板</label></a>
        </div>
        <p class="navbar-text navbar-right">欢迎您 ,
			<#if Session.loginUser?exists>  
        		${Session.loginUser.userName}   
  			</#if>  <a href="${basePath}/exit.do" target="_top">退出</a></p>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">主页</a></li>
                <li><a href="#message">留言</a></li>

            </ul>
        </div>
    </div>
</nav>

<div class="container">
 <div class="jumbotron" >
 	<img class="img-responsive" alt="Responsive image"  src="${basePath}/img/bz.jpg">
 </div>
</div>


<section class="about-section" id="home">
    <div class="container">
    
    <#list messageList! as message>  
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">留言标题：${message.messageTitle! }</h3>
            </div>
            <div class="panel-body">
                <p>内容：${message.messageContent! }<br/>
                </p>

                <div class="right">
                用户名：${message.userName!} 时间：
                
                ${message.messageTime!?string("yyyy-MM-dd HH:mm:ss")}
                </div>
            </div>
        </div>
    </#list>  
        <hr>
    </div> <!-- End of container -->

</section>



<section class="about-section" id="message">
    <div class="container">

            <div class="jumbotron" >
                <div class="center">
                <div class="container" >
                    <h2><label>欢迎留言</label></h2>
                    <form class="form-horizontal" action="${basePath}/addMessage.do" method="post">
                    <input name = "userId" value="<#if Session.loginUser?exists>  
			        		${Session.loginUser.userId}   
			  			</#if>" hidden="hidden">
                    	
                        <div class="form-group">
                            <label for="title" class="col-sm-2 control-label">留言标题：</label>
                            <div class="col-sm-10">
                                <input name="messageTitle" type="text" class="form-control" id="messageTitle" required  placeholder="请输入留言标题">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="content" class="col-sm-2 control-label">内容：</label>
                            <div class="col-sm-10">
                                <textarea id="messageContent" name="messageContent" class="form-control" rows="5" required placeholder="请输入留言内容" ></textarea>
                            </div>
                        </div>
                       
                        <div class="right">
                        <button class="btn btn-primary register"  type="submit" >提交</button></div>
                    </form>

                </div>
                </div>
            </div>


    </div>
</section> <!-- End of section -->
<div class="container body-content">
		<hr />
		<footer>
			<p>&copy; 2017 - 留言板2.0版本</p>
		</footer>
	</div>
</body>
</html>
