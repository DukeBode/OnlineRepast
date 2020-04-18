<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<!DOCTYPE html>

<html class="no-js">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>Cook</title>
<link rel="stylesheet" type="text/css" href="gouwuche_files/bootstrap.css">
<link rel="stylesheet" type="text/css" href="gouwuche_files/font-awesome.css">
<link rel="stylesheet" type="text/css" href="gouwuche_files/style.css">
<style>
<jsp:include page="sub/account.css.jsp"></jsp:include>
</style>
<script type="text/javascript" src="<%=host%>/js/jquery.min.js"></script>
<jsp:include page="sub/account.js.jsp"></jsp:include>
</head>

<body>
<jsp:include page="sub/account.jsp"></jsp:include>
  <div class="wrapper">
    <header>
      <jsp:include page="sub/topnav.jsp"></jsp:include>
      </header>
      </div>

<div class="ct-pageWrapper">
  <main>
	<div class="container">
	  <div class="row">
		<div class="col-md-3">
		  <div class="widget">
			<h2 class="widget-header">购物车</h2>
			<div class="ct-cart"><span class="ct-cart-empty">Your cart is empty</span></div>
			<div class="ct-cart"><span class="ct-cart-total">$159.92</span><ol>
			<li class="animated fadeIn" data-id="1999_1"><span class="ct-cart-name">七彩马卡龙</span><span class="ct-cart-price">$19.99</span><input type="number" min="1" value="1" class="ct-cart-input"><button class="ct-cart-remove">×</button></li></ol>
			<button class="ct-cart-clear">Clear Cart</button>
			<button type="submit" class="ct-cart-checkout">Checkout</button></div>
		  </div>
		</div>
		
	  </div>
	</div>
  </main>
<script src="gouwuche_files/jquery-1.js"></script>
<script src="gouwuche_files/shop.js"></script>
<script>
$('body').ctshop({
  currency: '$',
  paypal: {
	currency_code: 'EUR'
  }
});
</script>
</div>
<div style="text-align:center;">

</div>

</body></html>