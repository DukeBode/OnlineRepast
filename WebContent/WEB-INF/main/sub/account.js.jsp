<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<script>
$(document).ready(function(){
	$("#login-btn").click(function () {
		$("#popup-overlay").css('display', 'block');
		$("#popup-login").fadeIn()
	});
	$(".register-btn").click(function () {
		$('.popup').css('display', 'none');
		$("#popup-overlay").css('display', 'block');
		$("#popup-register").fadeIn()
	});
	$("#popup-overlay, .popup a.close").click(function () {
		$('.popup, #popup-overlay').css('display', 'none')
	});
		$("#submitlogin").submit(function(){
			$.ajax({
	            url:"<%=host%>/login",
	            data:$('#submitlogin').serialize(),
	            type:"post",
	            success:function(msg){
	            	//var span = document.getElementById("myMsg");
	            	if(msg == 0){
	            		location.reload();
	            		//alert("操作成功");
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
	            url:"<%=host%>/regist",
	            data:$('#submitregist').serialize(),
	            type:"post",
	            success:function(data){
	            		alert("操作成功");
	            }
			})
		})
		})
	
	</script>