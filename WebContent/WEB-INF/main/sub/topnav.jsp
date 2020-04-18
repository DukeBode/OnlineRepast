<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>
<div class="top-nav">
        <nav>
          <ul>
          <c:if test="${user==null}">
            <li id="login-btn">登录</li>
            <li class="register-btn">注册</li>
          </c:if>
          <c:if test="${user!=null}">
      	    <li>欢迎： ${user.id}</li>
      	    <li><a href="<%=host%>/cart/detail">购物车</a></li>
            <li><a href="contact.html">配送地址</a></li>
      	  	<c:if test="${user.role == 1 }">
      	  	<li><a href="#">后台</a></li>
      	  	</c:if> 
      	  	<li><a href="<%=host%>/logout">退出</a></li>     
      	  </c:if> 
            <li><a href="menu.html">菜单</a></li>
          </ul>
        </nav>
        
      	     
      	    
        <form class="search-form" method="post">
          <input value="search..." class="search" type="text">
          <input class="search-submit" value="" type="submit">
        </form>
  
      </div>
      
      <a href="<%=host %>" class="logo"><img src="<%=host%>/index_files/logo.png" alt="your logo"></a>