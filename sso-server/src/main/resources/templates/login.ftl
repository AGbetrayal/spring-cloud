
<html>
<head>
	<meta charset="UTF-8">
	<title>登录页面</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="../js/plugins/bootstrap-4.1.1-dist/css/bootstrap.min.css">
	<script src="../js/plugins/jquery/jquery.min.js" type="text/html"></script>
	<script src="../js/plugins/bootstrap-4.1.1-dist/js/bootstrap.min.js" type="text/html"></script>
	<link rel="stylesheet" href="../css/font/css/font-awesome.min.css" >
	<link rel="stylesheet" href="../css/reset.css" >
	<link rel="stylesheet" href="../css/login.css" >
	<link rel="stylesheet" href="../js/plugins/dialog2/dialog.css">
	<script src="../js/plugins/dialog2/dialog.js" type="text/html"></script>
	<script src="../js/plugins/jquery-form/jquery.form.js" type="text/html"></script>

	<#--<script>
        $(function () {
            $("#loginForm").ajaxForm(function (data) {
                if(data.success){
					//获取当前登录用户信息,先转为json字符串再缓存起来
                    sessionStorage.setItem("user",JSON.stringify(data.result));
                    window.parent.location.href = "/index.html";
                }else{
                    $(document).dialog({
                        titleShow: false,
                        content: data.msg
                    });
                }
            })
        })
	</script>-->
</head>
<body>
<div class="container" >
	<h5>登录</h5>

	<div class="card card-container ">
		<i id="profile-img" class="fa fa-user-circle fa-5x profile-img" ></i>
		<form class="form-signin" id="loginForm" action="/login" method="post">
			<input type="text"  name="username" value="AGbetrayal@163.com" class="form-control badge-pill" placeholder="邮箱"  >
			<input type="password"  name="password" value="123456" class="form-control badge-pill" placeholder="密码" >
			<a href="#" class="forgot-password">
				忘记密码？
			</a>
			<button class="btn btn-lg badge-pill" type="submit" >登录</button>
		</form>
	</div>


	<a href="register.html" class="registerLink" >
		新用户？点击这里注册
	</a>
</div>

</body>
</html>
