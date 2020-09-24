<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.ncu.clothwholesale.pojo.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>布料批发</title>
<style type="text/css">
body{
	margin:0; 
	padding:0;
	font-family:"微软雅黑";
}
.MainContainer{width:100%;}
.nav{height:45px;width:100%;background-color: #f1f1f1;}
.search{float:right;width:40%;}
.main{width:100%;}
.content{width:100%;}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #f1f1f1;
}

li {
    float: left;
    display: block;
    color: #4CAF50;
    padding: 5px 10px; 
    text-decoration: none;
}
.customer{
	background-color: #4CAF50;
	color:#000;
}
li a {
    display: block;
    color: #000;
    padding: 5px 10px;
    text-decoration: none;
}

li a.active {
    background-color: #4CAF50;
    color: white;
}

li a:hover:not(.active) {
    background-color: #555;
    color: white;
} 
input[type="text"]{
	-web-kit-appearance:none;
 	-moz-appearance: none;
  	border-radius:4px;
	border:1px solid #c8cccf;
	color:#6a6f77;
	outline:0;
	padding: 5px;
    margin:5px;
	font-size:15px;
}
input[type="text"]:focus{
  border:1px solid #ff7496;
}
input[type="button"]{
	display: inline-block;
    outline: none;
    cursor: pointer;
    align:center;
    text-align: center;
    text-decoration: none;
    padding: 5px;
    margin:5px;
    border-radius: 5px;
    color: #d9eef7;
    border: solid 1px;
    background: #007ead;
}
input[type="button"]:hover{
    background: #007ead;
}
</style>
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
var activePage = "customer/searchProduct.jsp";
$(document).ready(function(){
	$("#mainiframe").attr("src",activePage);
	changeFrameHeight();
})

//iframe大小自适应
function changeFrameHeight(){
        var ifm= document.getElementById("cmainiframe");
        ifm.height=document.documentElement.clientHeight+100;
    }
window.onresize=function(){ changeFrameHeight();}

//导航链接跳转
function go(button){
	$(".active").removeAttr("class");
	
	button.className = "active";
	activePage = button.href;
	
	changeFrameHeight();
}
function logout(){
	window.location.href= "<%=basePath%>/user/logout";
}
</script>
</head>
<body>
<%
Customer c  = null;
if(request.getSession().getAttribute("customer")==null){
		response.sendRedirect("login.jsp");
}else{
	c =(Customer) request.getSession().getAttribute("customer");
	%>
<div class="MainContainer">
	<div class="nav" >
		<ul class="menu">
            <li class="customer"><a target="cmainiframe" href="customer/customer_info.jsp"  onclick="go(this)"><%=c.getCustomerName() %></a></li>
            <li><a href="javascript:void(0)" onclick="logout()">退出</a></li>
            <li><a target="cmainiframe" href="customer/searchProduct.jsp"  onclick="go(this)">主页</a></li>
            <li><a target="cmainiframe" href="customer/order_list.jsp"  onclick="go(this)">订单</a></li>
            <!-- <li><a target="cmainiframe" href="">进货单</a></li> -->
            <li><a target="cmainiframe" href="customer/money_IO.jsp"  onclick="go(this)">款项流水</a></li>
        </ul>
    </div>
    
    <div class="main" id="main" >
		<iframe class="content" id="cmainiframe" name="cmainiframe" src="customer/searchProduct.jsp" frameborder="0"  scrolling="no">
		</iframe>
	</div>
</div>
<%
}
%>
</body>
</html>