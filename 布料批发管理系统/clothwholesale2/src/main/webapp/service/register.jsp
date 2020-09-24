<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="service/js/jquery.js"></script>
<script src="service/js/jquery.validate.js"></script>
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
.login_error_info{
	font-size:15px;
	width:95%;
	padding: 10px;
    margin:5px;
	color:red;
	text-align:center;
	background: #f1f1f1;
    border-radius: 5px;
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
	width:550px;
	margin: 10px auto;
}
</style>
</head>

<body>
	<div class="sysName" >
       		布料批发管理系统
    </div>
    <div>
	<form id="registerForm">
		<table>
			<tr>
                <td class="login_info">用户名：</td>
                <td ><input id="username" name="username" size="25" type="text"  /></td>
            </tr>
            <tr>
                <td class="login_info">姓名：</td>
                <td ><input id="customerName" name="customerName" size="25" type="text"  /></td>
            </tr>
            <tr>
                <td class="login_info">密码：</td>
                <td ><input id="password" name="password" size="25" type="password"  /></td>
            </tr>
            <tr>
                <td class="login_info">确认密码：</td>
                <td><input id="password2" name="password2" size="25" type="password"  /></td>
            </tr>
            <tr>
                <td class="login_info">手机号：</td>
                <td ><input id="mobile" name="mobile" size="25" type="text"  /></td>
            </tr>
            <tr>
                <td class="login_info">邮箱：</td>
                <td ><input id="email" name="email" size="25" type="text"  /></td>
            </tr>
            <tr>
                <td class="login_info">地址：</td>
                <td ><input id="contactAddr" name="contactAddr" size="50" type="text"  /></td>
            </tr>
            <tr>
                <td class="login_info">邮编：</td>
                <td ><input id="postcode" name="postcode" size="25" maxlength="6" type="text" /></td>
            </tr>
            <tr>
                <td class="login_info" colspan="3" class="login_error_info">
                    <span class="required" id="loginCheck"></span>
                </td>             
            </tr>
            <tr>
                <td class="login_button" colspan="2">
                	<input id="loginButton" onclick="register()" type="button" value="注册"> 
                    
                </td>         
            </tr>
            <tr>
                <td class="login_info" colspan="2">
                    <a href="<%=basePath %>service/login.jsp">登录</a>
                </td>             
            </tr>
		</table>
	</form>
	</div>
<script>
function register(){
	var username = $("#username").val();
	var customerName = $("#customerName").val();
	var password = $("#password").val();
	var password2 = $("#password2").val();
	var mobile = $("#mobile").val();
	var email = $("#email").val();
	var contactAddr = $("#contactAddr").val();
	var postcode = $("#postcode").val();
	
	$.ajax({
        url : "./user/register",
        type : "POST",
        dataType:"json",
        contentType : "application/json;charset=UTF-8",
        data:JSON.stringify({
        	username:username,
        	customerName:customerName,
        	password:password,
        	password2:password2,
        	mobile:mobile,
        	email:email,
        	contactAddr:contactAddr,
        	postcode:postcode
        }),
        
        //回调函数
        success:function(result) {
            if(result.success){
            	alert("注册成功");
                window.top.location.href = "service/login.jsp";
            }else{
            	alert(result.message);
            	$("#loginCheck").text(result.message);
            }
        },
        error:function(result){
        	alert(result.message);
            $("#loginCheck").text("注册失败");
        }
    });
}
</script>
</body>
</html>