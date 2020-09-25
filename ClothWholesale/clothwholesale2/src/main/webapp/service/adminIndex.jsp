<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.ncu.clothwholesale.pojo.Admin"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>布料批发管理系统</title>
<style type="text/css">
body{
	margin:0; 
	padding:0;
	font-family:"微软雅黑";
}
.MainContainer{width:100%;}
.nav{width:20%;float:left;}
.main{width:80%;float:right;broder-left:5px;}
.content{width:100%;}

li{list-style-type: none;}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 20%;
    position: fixed;
    background-color: #f1f1f1;
    height: 100%;
    overflow: auto;
}
 li {
    display: block;
    color: #4CAF50;
    padding: 5px 10px; 
    text-decoration: none;
}
.admin{
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
</style>
<script src="js/jquery.js"></script>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
var activePage = "admin/admin_view.jsp";
$(document).ready(function(){
	$("#mainiframe").attr("src",activePage);
	changeFrameHeight();
})

//iframe大小自适应
function changeFrameHeight(){
        var ifm= document.getElementById("mainiframe");
        ifm.height=document.documentElement.clientHeight+30;
    }
window.onresize=function(){ changeFrameHeight();}

//导航链接跳转
function go(button){
	$(".active").removeAttr("class");
	
	button.className = "active";
	activePage = button.href;
	//alert(activePage);
	
	changeFrameHeight();
}
function logout(){
	window.location.href= "<%=basePath%>/user/logout";
}
</script>
</head>

<body>
<%
String type = "";
Admin a = null;
if(request.getSession().getAttribute("admin")==null){
		response.sendRedirect("login.jsp");
}else{
	a =(Admin) request.getSession().getAttribute("admin");
	type = a.getAdminType();
	%>
<div class="MainContainer">
	<div class="nav" >
		<ul class="Amenu">
			<li class="admin">管理员：<%=a.getAdminName() %></li>

				<li><a target="mainiframe"  class="active" href="admin/admin_view.jsp" onclick="go(this)">查看自身信息</a></li>
				<li><a href="javascript:void(0)" onclick="logout()">退出</a></li>

			<li>基础信息管理</li>
				<!-- <ul class="Bmenu" id="baseInfoManageNav"> -->
					<%if(type.equals("GJ")){ %>
					<li><a target="mainiframe" href="admin/admin_list.jsp" onclick="go(this)">管理员信息管理</a></li>
					<li><a target="mainiframe" href="statistic/statistic_list_year.jsp" onclick="go(this)">财务统计管理</a></li>
					<%}
					if(type.equals("GJ") || type.equals("CG")){
					%>
					<li><a target="mainiframe" href="product/product_list.jsp" onclick="go(this)">产品信息管理</a></li>
					<li><a target="mainiframe" href="supplier/supplier_list.jsp" onclick="go(this)">供应商信息管理</a></li>
					<%}
					if(type.equals("GJ") || type.equals("CK")){
					%>
					<li><a target="mainiframe" href="warehouse/warehouse_list.jsp" onclick="go(this)">仓库信息管理</a></li>
					<%} %>
				<!-- </ul> -->
				<%
				if(type.equals("GJ") || type.equals("CG")){
				%>
			<li>采购管理</li>
				<!-- <ul class="Bmenu"> -->
					<li><a target="mainiframe" href="purchase/purchase_list.jsp" onclick="go(this)">采购订单管理</a></li>
					<li><a target="mainiframe" href="purchase/purchase_moneyIO.jsp" onclick="go(this)">查看采购款项流水</a></li>
				<!-- </ul> -->
			<%}
			if(type.equals("GJ") || type.equals("PF")){
			%>
			<li>批发管理</li>
				<!-- <ul class="Bmenu"> -->
					<li><a target="mainiframe" href="wholesale/wholesale_list.jsp" onclick="go(this)">批发订单管理</a></li><!-- 
					<li><a target="mainiframe" href="wholesale/wholesale_return.jsp" onclick="go(this)">批发退货</a></li>
					<li><a target="mainiframe" href="wholesale/wholesale_exchange.jsp" onclick="go(this)">批发换货</a></li>
					<li><a target="mainiframe" href="wholesale/wholesale_cancel.jsp" onclick="go(this)">批发订单取消</a></li> -->
					<li><a target="mainiframe" href="wholesale/wholesale_moneyIO.jsp" onclick="go(this)">查看批发款项流水</a></li>
				<!-- </ul> -->
			<%}
			if(type.equals("GJ") || type.equals("CK")){
			%>
			<li>库存管理</li>
				<!-- <ul class="Bmenu"> -->
					<li><a target="mainiframe" href="warehouse/inventory_in.jsp" onclick="go(this)">采购入库</a></li>
					<li><a target="mainiframe" href="warehouse/inventory_out.jsp" onclick="go(this)">批发出库</a></li>
					<li><a target="mainiframe" href="warehouse/inventory_content.jsp" onclick="go(this)">查看库存内容</a></li>
					<li><a target="mainiframe" href="warehouse/inventory_IO.jsp" onclick="go(this)">查看出入库流水</a></li>
				<!-- </ul> -->
			
			<%} %>
		</ul>
	</div>
	
	
	<div class="main" id="main" >
		<iframe class="content" id="mainiframe" name="mainiframe" frameborder="0" scrolling="no" >
		</iframe>
	</div>

</div>
<%
}
%>
</body>
</html>