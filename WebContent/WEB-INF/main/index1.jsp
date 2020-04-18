<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript">
	function tijiao(){
		var uname = document.getElementById("uname").value;
		var pwd = document.getElementById("pwd").value;
		if(uname == ""){
		   alert("用户名不能为空!");
		   return false;
		}
		if(pwd == ""){
			alert("密码不能为空!");
			return false;
		}			
		var span = document.getElementById("myMsg");
		$.ajax({
			   type: "POST",
			   url: "<%=basePath%>regist",
			   data: "account=" + uname + "&pwd=" + pwd,
			   success: function(msg){
			      if(msg == "1"){
			    	  window.location.href="<%=basePath%>MainSvl";
			      }else if(msg == "2"){
			    	  span.innerHTML = "用户名或密码错误";
			      }else if (msg == "0"){
			    	  span.innerHTML = "用户名或密码不能为空";
			      }else if (msg == "-1"){
			    	  span.innerHTML = "网络异常，请和管理员联系...";
			      }
			   }
		});
	}	

</script>
<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}

		$(document).ready(function(){
		$("#submitlogin").submit(function(){
			$.ajax({
	            url:"<%=basePath%>login",
	            data:$('#submitlogin').serialize(),
	            type:"post",
	            success:function(msg){
	            	if(msg == 0){
	            		alert("操作成功");
				      }else if(msg == 1){
				    	  alert("用户名或密码错误");
				      }else if (msg == -1){
				    	  alert("网络异常，请和管理员联系...");
				      }
	            }
			})
		})
		$("#submitregist").submit(function(){
			$.ajax({
	            url:"<%=basePath%>regist",
	            data:$('#submitregist').serialize(),
	            type:"post",
	            success:function(data){
	            		alert("操作成功");
	            }
			})
		})
		})
		
	</script>
	<link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->

	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext"
	 rel="stylesheet">
</head>
<body>
<tr>
      	<td align=right>
<jsp:include page="sub/topnav.jsp"></jsp:include>  
      	</td>
      </tr>
		<div class="main-bg">
		<!-- title -->
		<h1>Triple Forms</h1>
		<!-- //title -->
		<div class="sub-main-w3">
			<div class="image-style">

			</div>
			<!-- vertical tabs -->
			<div class="vertical-tab">
				<div id="section1" class="section-w3ls">
					<input type="radio" name="sections" id="option1" checked>
					<label for="option1" class="icon-left-w3pvt"><span class="fa fa-user-circle" aria-hidden="true"></span>Login</label>
					<article>
						<form id="submitlogin" onsubmit="return false">
							<h3 class="legend">Login Here</h3>
							<div class="input">
								<span class="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="text" placeholder="Email" name="account" required />
							</div>
							<div class="input">
								<span class="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" required />
							</div>
							<button type="submit" class="btn submit">Login</button>
							<a href="#" class="bottom-text-w3ls">Forgot Password?</a>
						</form>
					</article>
				</div>
				<div id="section2" class="section-w3ls">
					<input type="radio" name="sections" id="option2">
					<label for="option2" class="icon-left-w3pvt"><span class="fa fa-pencil-square" aria-hidden="true"></span>Register</label>
					<article>
						<form id="submitregist" onsubmit="return false">
							<h3 class="legend">Register Here</h3>
							<div class="input">
								<span class="fa fa-user-o" aria-hidden="true"></span>
								<input type="text" placeholder="Username" name="account" required />
							</div>
							<div class="input">
								<span class="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" required />
							</div>
							<button type="submit" class="btn submit">Register</button>
						</form>
					</article>
				</div>
				<div id="section3" class="section-w3ls">
					<input type="radio" name="sections" id="option3">
					<label for="option3" class="icon-left-w3pvt"><span class="fa fa-lock" aria-hidden="true"></span>Forgot Password?</label>
					<article>
						<form action="#" method="post" onsubmit="return false">
							<h3 class="legend last">Reset Password</h3>
							<p class="para-style">Enter your email address below and we'll send you an email with instructions.</p>
							<p class="para-style-2"><strong>Need Help?</strong> Learn more about how to <a href="#">retrieve an existing
									account.</a></p>
							<div class="input">
								<span class="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="email" placeholder="Email" name="email" required />
							</div>
							<button type="submit" class="btn submit last-btn">Reset</button>
						</form>
					</article>
				</div>
			</div>
			<!-- //vertical tabs -->
			<div class="clear"></div>
		</div>
		<!-- copyright -->
		<div class="copyright">
			<h2>&copy; 2019 Triple Forms. All rights reserved | Design by
				<a href="http://xmoban.cn" target="_blank">xmoban.cn</a>
			</h2>
		</div>
		<!-- //copyright -->
	</div>
</body>
</html>