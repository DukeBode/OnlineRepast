<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<!-- LOGIN POP UPS -->
<div style="display: none;" id="popup-overlay"></div>
<div style="display: none;" class="popup" id="popup-login">
	<h2>客官这边请</h2>
	<hr class="separator">
	<form id="submitlogin" class="form clearfix" onsubmit="return false">
		<fieldset>
			<label for="login-username">客官名讳:</label>
			<input name="account" id="login-username" class="input text" type="text">
			<label for="login-password">进店密令:</label>
			<input name="password" id="login-password" class="input text" type="password">
	<hr class="separator">
			<button type="submit" class="button submit">进店</button>
		</fieldset>
	</form>
	<div class="links"><a href="#">忘记密令 </a> | <a href="#" class="register-btn"> 进店登记</a></div>
	<a class="close" href="#"></a>
</div>
<div style="display: none;" class="popup" id="popup-register">
		<h2>进店登记</h2>
		<hr class="separator">
		<form id="submitregist" onsubmit="return false" class="form clearfix">
			<fieldset>
				<label for="login-username">客官名讳:</label>
				<input name="account" id="login-username" class="input text" type="text">
				<label for="login-email">您的邮箱:</label>
				<input name="email" id="login-email" class="input text" type="email">
				<label for="login-password">进店密令:</label>
				<input name="password" id="login-password" class="input text" type="password">
				<label for="login-confirm-password">确认密令:</label>
				<input name="password2" id="login-confirm-password" class="input text" type="password">
		
			<hr class="separator">
			
			<div class="checks">
				<div class="check-row">
					<label><input class="input checkbox" type="checkbox">I have read and agree to the <a href="#">Terms &amp; Conditions</a></label>
				</div>
				<div class="check-row">
					<label><input class="input checkbox" type="checkbox">I agree to recieve promotional mails</label>
				</div>
			</div>

			<button class="button submit">正在登记</button>
			</fieldset>
		</form>
		<a class="close" href="#"></a>
	</div>
<!-- END LOGIN POP UPS -->