<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.ncu.clothwholesale.pojo.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>view admin</title>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validate.js"></script>
<style type="text/css">
body{
	margin:10px; 
	padding:10px;
	TEXT-ALIGN: center;
	font-family:"微软雅黑";
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
input[type="password"]{
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
input[type="password"]:focus{
  border:1px solid #ff7496;
}
button {
    display: inline-block;
    outline: none;
    cursor: pointer;
    text-align: center;
    text-decoration: none;
    padding: 5px;
    margin:5px;
    border-radius: 5px;
    color: #d9eef7;
    border: solid 1px #0076a3;
    background: #4CAF50;
}
button:hover{
    background: #007ead;
} 
input[type="button"]{
	display: inline-block;
    outline: none;
    cursor: pointer;
    align:center;
    text-align: center;
    text-decoration: none;
    padding: 10px;
    margin:5px;
    border-radius: 5px;
    color: #d9eef7;
    border: solid 1px;
    background: #007ead;
}
input[type="button"]:hover{
    background: #4CAF50;
}
.sysName{
	font-size:30px;
    height:50px;
    width:100%;
	color:#4CAF50;
	text-align:center;
	background: #f1f1f1;
    border-radius: 5px;
}
table{
	width:600px;
	margin: 10px auto;
}
</style>
</head>
<body>
	<div class="sysName" >
	管理员信息
	</div>
		
	<div>
		<form action="">
			<table>
				<tr>
					<td>编号</td>
					<td><span id="adminCode"></span></td>
					<td>类型</td>
					<td><span id="adminType"></span></td>
				</tr>
				<tr>
					<td>状态</td>
					<td><span id="state"></span></td>
					<td>姓名</td>
					<td><input type="text" id="adminName" name="adminName" size="20"></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input type="text" id="mobile" name="mobile" size="20"></td>
					<td>电子邮箱</td>
					<td><input type="text" id="email" name="email" size="20"></td>
				</tr>
			</table>
		</form>
	</div>
	
<script>
$(function(){
	//发送信息
	$.ajax({
        url : "../../admin/view",
        type : "POST",
        //回调函数
        success:function(ret) {
            if(ret.success){
            	var admin = ret.data;
            	$("#adminCode").text(admin.adminCode);
            	$("#adminName").val(admin.adminName);
            	$("#mobile").val(admin.mobile);
            	$("#email").val(admin.email);
            	if(admin.adminType=="CG")
            		$("#adminType").text("采购");
            	if(admin.adminType=="PF")
            		$("#adminType").text("批发");
            	if(admin.adminType=="CK")
            		$("#adminType").text("仓库");
            	if(admin.adminType=="GJ")
            		$("#adminType").text("高级");
            	
            	if(admin.state=="T")
            		$("#state").text("启用");
            	if(admin.state=="F")
            		$("#state").text("停用");
            }else{
            	alert("查询失败");
            }
        },
        error:function(result){
        	//alert(result);
            alert("查询出错");
        }
    });
});
</script>
</body>
</html>