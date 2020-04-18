<%@ page language="java" contentType="text/html;" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<% String host = request.getContextPath(); %>

body {
	border: 0;
	padding: 0;
	margin: 0;
}

 -moz-box-sizing:border-box;
 box-sizing:border-box;
}
html, body, div, span, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
abbr, address, cite, code, del, dfn, em, images, ins, kbd, q, samp,
small, strong, sub, sup, var, b, i, dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, figcaption, figure,
footer, header, hgroup, menu, nav, section, summary,
time, mark, audio, video, a img {
  margin: 0;
  padding: 0;
  border: 0 none;
  list-style: none;
}
body {
  font-family: 'Microsoft yahei',Arial, Helvetica, sans-serif;
  font-size: 12px;
  background: #ebcc96 url('<%=host%>/images/body-bg.png') repeat-x;
}
article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
  display: block;
}
h1, h2, h3, h4, h5, h6 {
	font-family: 'Microsoft yahei',Georgia, sans-serif;
}
.clearfix:after {
  content: ".";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}
input {  
  font-family: 'Microsoft yahei',Arial, Helvetica, sans-serif;
  border: none;
}

.wrapper {
  width: 970px;
  margin: 0 auto;
	padding: 0 115px;
}
/*=============================================== Header*/
header {
  width: 970px;
  height: 265px;
  margin-bottom: -19px;
}
hr {
  clear: both;
  display: block;
  height: 2px;
  padding: 20px 0;
  margin: 0;
  border: none;
  background: url("<%=host%>/images/separator.png") repeat-x 0 20px;
}
ul li {background: url(../images/breadcrumbs-arrow.png) no-repeat left 5px; list-style: none; padding: 0 0 0 15px}
ol li {list-style-position: inside}
.home header {
  position: relative;
  padding: 0 115px;
  margin: 0 0 0 -115px;
  height: 655px;
}

input, textarea {box-shadow:inset 1px 1px 10px rgba(0, 0, 0, 0.3); padding:5px 10px; border-radius: 10px; border: none; background-color: #cfb27e}
.button {
	cursor: pointer;
  display: block;
  padding: 10px;
  font-size: 14px;
  color: #FFF;
  font-weight: bold;
  text-decoration: none;
  font-family: Arial, sans-serif;
  border: none;
  border-radius: 5px;
  background: #c21702;
  background: -moz-linear-gradient(top center, #d31602, #b11801);
  background: -webkit-gradient(linear, left top, left bottom, from(#c51501), to(#9b1600));
}

.form label {
  float: left;
  display: block;
  width: 110px;
  font-size: 14px;
  font-weight: bold;
  color: #321a0a;
  padding: 10px 0 0;
}
.form .text, .form textarea {clear: right; width: 280px; background: #d5c6b1; padding: 10px; margin-bottom: 10px; background: #d8c7aa; -moz-border-radius: 3px; -webkit-border-radius: 3px; border-radius: 3px}
.form .error {-moz-box-shadow:inset 1px 1px 10px rgba(192, 25, 4, 1); -webkit-box-shadow:inset 1px 1px 10px rgba(192, 25, 4, 1); box-shadow:inset 1px 1px 10px rgba(192, 25, 4, 1); color: #be1904; text-align: center}
.form textarea {height: 100px}
.form .checkbox {width: 15px; padding: 0; background: none; -moz-border-radius: 2px}
.form .required {color: #b31a05}
.form .button {
  float: right;
  font-size: 16px;
}
.form .required-desr {
  float: left;
  margin: 14px 0 0 118px;
  color: #b31a05;
}

.top-nav {
  float: left;
  width: 100%;
  height: 45px;
}
.top-nav nav {
  float: left;
}
.top-nav nav ul {
  float: left;
  margin-left: 257px;
  margin: 15px 0 0 257px;
}
.top-nav nav ul li {
  float: left;
  height: 14px;
  border-left: 1px solid #934b42;
  padding-left: 10px;
  margin-left: 9px;
	background: none;
	color: #FFF;
}
.top-nav nav ul li:first-child {
  margin-left: 0;
  padding-left: 0;
  border: none;
}
.top-nav nav ul li a {
  line-height: 14px;
  text-transform: uppercase;
  color: #FFF;
  font-size: 11px;
  font-weight: bold;
  text-decoration: none;
}
.top-nav nav ul li a:hover {
	color: #e95b45;
}
.top-nav .search-form{
  float: right;
  width: 211px;
  height: 24px;
  margin-top: 10px;
  background: url('<%=host%>/images/sprite.png') no-repeat 0 0;
}
.top-nav .search-form input.search {
  float: left;
  width: 180px;
  height: 24px;
  line-height: 24px;
  background: none;
  border: none;
  color: #c6b6b3;
  text-indent: 12px;
  padding: 0;
}
.top-nav .search-form input.search-submit{
  float: right;
  width: 31px;
  height: 24px;
  cursor: pointer;
  border: none;
  background: none;
}
/*================================= Pop-up */

.popup,.popup *{
 -webkit-box-sizing:content-box;
 -moz-box-sizing:content-box;
 box-sizing:content-box;
 margin:0;
 border:0;
};

#popup-overlay {
	display: none;
	width: 100%; 
	height: 100%; 
	background: rgba(0, 0, 0, 0.8); 
	position: fixed; 
	z-index: 9999; 
	top: 0; 
	left: 0;
}
.popup {
	display: none;
	padding: 16px 30px 12px;
	background: #f7e8ce;
	background:-moz-linear-gradient(top center, #fbf3e3, #f3e1c0);
	background: -webkit-linear-gradient(#fbf3e3, #f3e1c0);
	background: linear-gradient(#fbf3e3, #f3e1c0); -moz-border-radius: 8px; -webkit-border-radius: 8px;
	border-radius: 8px;
	position: absolute;
	top: 200px;
	left: 50%;
	z-index: 10000;
}
.popup hr {
	padding: 15px 0;
	background-position: 0 16px;
	line-height:normal;
}
.wrapper {
box-sizing:content-box;
line-height:normal;}
.popup .button {
	font-size: 18px;
}
#popup-register .check-row label {
	width: 100%;
	font-size: 13px;
	font-weight: normal;
	color: #5b3922;
	padding: 0;
	border:0 none;
}
.popup .close {
	width: 29px;
	height: 29px;
	display: block;
	background: url("<%=host%>/images/sprite.png") no-repeat scroll -150px -400px transparent;
	position: absolute;
	top: -13px;
	right: -13px;
}
.popup h2 {font-size: 24px; font-family: Georgia, sans-serif; text-transform: uppercase; text-align: center; font-weight: normal; color: #321a0a}
.popup input:last-of-type {margin-bottom: 0}
.popup a {color: #b31a05; text-decoration: none}
.popup .links {float: right; font-size: 12px; padding: 10px; margin: 0 58px 0 0}
.popup .button {float: right; text-transform: uppercase}

#popup-login {width: 355px; height: 270px; margin-left: -208px}
#popup-login .input {width: 235px}
#popup-login label {width: 100px}
#popup-login .button {width: 255px}
#popup-login fieldset {padding: 10px 0}

#popup-register {width: 455px; margin-left: -258px}
#popup-register input.text {width: 285px}
#popup-register label {width: 150px}
#popup-register .button {width: 305px}
#popup-register fieldset {padding: 10px 0}
#popup-register .checks {width: 305px; float: right; color: #5b3922; font-size: 13px; margin-bottom: 10px;}
#popup-register .check-row {overflow: hidden; padding: 0 0 10px}
#popup-register .checkbox {margin-right: 4px}