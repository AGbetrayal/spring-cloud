
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
	<script src="/../js/vue-2.4.0.js" ></script>
	<script src="/../js/vue-resource-1.3.4.js" ></script>
	<script src="/../js/vue-router-3.0.1.js" ></script>
	<script src="/../js/axios.js"></script>

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
<div class="container" id="applg">
	<h5>登录</h5>

	<div class="card card-container ">
		<i id="profile-img" class="fa fa-user-circle fa-5x profile-img" ></i>
		<form class="form-signin" id="loginForm" action="/login" method="post">
			<input type="text"  name="username" value="admin" class="form-control badge-pill" placeholder="账号"  >
			<input type="password"  name="password" value="123456" class="form-control badge-pill" placeholder="密码" >
			<a href="#" class="forgot-password">
				忘记密码？
			</a>
			<button class="btn btn-lg badge-pill" type="submit" >登录</button>
		</form>
		<img src="./img/login/timg.jpg" width="30px" height="30px">
	</div>


	<a href="register.html" class="registerLink" >
		新用户？点击这里注册
	</a>
	<mycomponent>888</mycomponent>

	<script type="text/x-template" id="mycomponent">
		<div>
			<input type="text"  name="username" value="admin" class="form-control badge-pill" placeholder="手机号"  >


		</div>
	</script>
	<input type="password"  v-model="smsCode" value="123456" class="form-control badge-pill" placeholder="验证码" >
	<a @click="sendValidate()"> 发送验证码 </a>
	<a @click="smslogin()"> 短信登录 </a>
</div>
<script>
	Vue.component('mycomponent',{
		template: `#mycomponent`,
		data () {
			return {
				message: 'hello world'
			}
		}
	});

	var vn = new Vue({
		el:'#applg',
		data:{
			showLogin: true,
			smsCode: ""
		},
		methods: {
			sendValidate: function () {
				axios.get('/code/sms', {
					params: {
						mobile: '18814127211'
					}

				})
			},
			smslogin: function () {
				// axios({
				// 	method: 'post',
				// 	url: '/authentication/mobile',
				// 	data: {
				// 		mobile: '18814127211',
				// 		smsCode: this.smsCode
				// 	}
				// });

				axios.post('/authentication/mobile?mobile=18814127211&smsCode='+ this.smsCode)

			}

		}
	})

</script>
</body>
</html>
