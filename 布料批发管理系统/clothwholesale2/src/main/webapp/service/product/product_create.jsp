<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validate.js"></script>
<style type="text/css">
body{
	margin:10px; 
	padding:10px;
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
</style>
</head>
<body>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<div>
<div class="title">添加产品</div>
<div><button  onclick="back()">返回</button></div>
<form id="createProductForm" >
		<div><span id="message"></span></div>
	<div>
		<table>
			<tr>
				<td>供应商编号</td>
				<td>
					<input type="text" name="supplierCode" id="supplierCode">
				</td>
			</tr>
			<tr>
				<td>产品名称</td>
				<td>
					<input type="text" name="productName" id="productName" >
				</td>
			</tr>
			<tr>
				<td>产品原名</td>
				<td>
					<input type="text" name="originalName" id="originalName" >
				</td>
			</tr>
			<tr>
				<td>宽度</td>
				<td>
					<input type="text" name="width" id="width" >厘米
				</td>
			</tr>
			<tr>
				<td>克重</td>
				<td>
					<input type="text" name="weight" id="weight" >克每平方米
				</td>
			</tr>
			<tr>
				<td>原料</td>
				<td><input type="text" name="ingredient" id="ingredient"  ></td>
			</tr> 
			<tr>
				<td>纱支</td>
				<td><input type="text" name="thickness" id="thickness" ></td>
			</tr>
			<!-- <tr>
				<td>上传图片</td>
				<td><input type="file" id="uploadPic" value="上传图片" onclick="uploadPic()"></td>
				<td><img id="picture" name="file" style="height:100px;" alt="" src=""></td>
			</tr> -->
		</table>
	</div>
	<div><input class="submit" type="button" onclick="submitProduct()" value="提交"></div>
</form>
</div>
<script>
function back(){
	history.back(-1);
}

function submitProduct(){
	var formObject={};
	var formArray=$("#createProductForm").serializeArray();
	for(var i=0;i<formArray.length;i++){
		formObject[formArray[i].name] = formArray[i].value;
	}
	
	$.ajax({
        url : "../../product/addProduct",
        type : "post",
        dataType:"json",
        contentType : "application/json;charset=UTF-8",
        //发送的数据应为JSON字符串格式
        data :JSON.stringify(formObject),
        //回调函数
        success:function(result) {
        	console.log(result);
            if(result.success){
            	alert("添加成功");
            	window.location.href="product_list.jsp";
            }else{
            	alert(result.message);
            }
        },
        error:function(result){
            alert("查询失败");
        }
    });
}
</script>
</body>
</html>