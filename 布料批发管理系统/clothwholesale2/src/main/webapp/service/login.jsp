<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

if(request.getSession().getAttribute("admin")!=null)
	response.sendRedirect("service/adminIndex.jsp");
else if(request.getSession().getAttribute("customer")!=null)
	response.sendRedirect("service/customerIndex.jsp");
%>

<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
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
	width:400px;
	margin: 10px auto;
}
</style>
<script type="text/javascript">
function validCheck(){
	var username =$("#username").val();
	var pwd = $("#password").val();
	var role = document.getElementsByName("role");
	var roleval = "";
	for(var i=0; i<role.length; i ++){
        if(role[i].checked){
        	roleval = role[i].value;
            break;
        }
    }
	if(roleval == "customer"){
		if(username == null || username == ""){
			$("#loginCheck").text("用户名不可为空");
		}else if(username.length>15){
			$("#loginCheck").text("用户名应在15长度以内");
		}else if(pwd == null || pwd == "")
			$("#loginCheck").text("密码不可为空");
		else
			$("#loginCheck").text("");
			
	}else if(roleval == "admin"){
		if(username == null || username == "")
			$("#loginCheck").text("工号不可为空");
		else if(username.length!=5){
			$("#loginCheck").text("工号长度为5");
		}else if(pwd == null || pwd == "")
			$("#loginCheck").text("密码不可为空");
		else
			$("#loginCheck").text("");
	}
}
	
function login() {
	//获取信息
	var name = $("#username").val();
	var pwd = $("#password").val();
	var role = document.getElementsByName("role");
	var roleval = "";
	for(var i=0; i<role.length; i ++){
        if(role[i].checked){
        	roleval = role[i].value;
            break;
        }
    }
	//发送信息
	$.ajax({
        url : "./user/login",
        type : "POST",
        dataType:"json",
        contentType : "application/json;charset=UTF-8",
        //发送的数据应为JSON字符串格式
        data : JSON.stringify({
        	username:name,
        	password:pwd,
        	role:roleval
        }),
        //回调函数
        success:function(result) {
            if(result.success){
            	//alert("登录成功");
            	$("#loginCheck").text("查询成功" + result.message);
            	if(result.message == "admin")
            		var href = '${pageContext.request.contextPath}/service/adminIndex.jsp';
            	else if(result.message == "customer")
            		var href = '${pageContext.request.contextPath}/service/customerIndex.jsp';
                window.top.location.href = href;
            }else{
            	//alert("查询不到");
            	$("#loginCheck").text(result.message);
            }
        },
        error:function(result){
        	//alert(result);
            $("#loginCheck").text("查询失败");
        }
    });
}
<!--
$(function(){
    $("#loginForm").validate({
        onsubmit:true,// 是否在提交是验证
        rules: {
            username: {
                required: true,
            },
            password: {
                required: true,
            }
        },
        messages: {
            username: {
                required: "请输入工号或用户名"
            },
            password: {
                required: "请输入密码"
            }
        },
        submitHandler: function() { 
        $.ajax({
            url:"${pageContext.request.contextPath}/user/login",
            method:"post",
            data:$('#loginForm').serialize(),
            dataType:'json',
            success:function(ret){
                if(ret.success){
                    $("#loginCheck").html("登录成功！");
                    var href = '${pageContext.request.contextPath}/index.jsp';
                    window.top.location.href = href;
                }else{
                    $("#loginCheck").html("用户名或密码错误！");
                }
            }
        });
        }
    })
});
-->
</script>
</head>

<body>
<%-- <span>path=<%=path %></span>
<span>basepath=<%=basePath %></span> --%>

		<div class="sysName" >
       		布料批发管理系统
       	</div>
		<form  id="loginForm" >
		
            <table >
            	<tr>
                    <td class="login_info" >选择类型：</td>
                    <td><input type="radio" name="role" value="customer" checked="checked">客户</td>
                    <td><input type="radio" name="role" value="admin" >管理员</td>
                </tr> 
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="username" name="username" size="25" type="text" onkeyup="validCheck()" placeholder="请输入用户名或工号"/></td>
                    
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="password" name="password" size="25" type="password" onkeyup="validCheck()" placeholder="长度6至20字符"/></td>
                </tr>
                   
                <tr>
                    <td class="login_info" colspan="3" class="login_error_info">
                        <span class="required" id="loginCheck"></span>
                    </td>             
                </tr>        
                <tr>
                    <td class="login_button" colspan="3">
                    	<input id="loginButton" onclick="login()" type="button" value="登录"> 
                    	 <!-- <button id="loginButton" onclick="login()">登录</button>-->
                        
                    </td>         
                </tr>
                <tr>
                    <td class="login_info" colspan="3">
                        <a href="<%=basePath %>service/register.jsp">客户注册</a>
                    </td>             
                </tr>
            </table>
        
       </form>

</body>
</html>