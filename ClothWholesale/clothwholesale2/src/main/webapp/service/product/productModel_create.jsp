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
input[type="file"]:focus{
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
<div class="title">添加产品型号</div>
<div><button  onclick="back()">返回</button></div>
<form id="createProductModelForm">
		<div>
		<div class="info">
			<label>产品编号</label>
			<input type="text" id="productCode" name="productCode"  disabled value="${param.productCode}">
		</div>
		<div><span id="message"></span></div>
	</div>
	<div>
		<table>
			<tr>
				<td>型号名称</td>
				<td>
					<input type="text" name="modelName" id="modelName">
				</td>
			</tr>
			
			<tr>
				<td>上传图片</td>
				<td><input type="file" id="file" name="file" value="上传图片" ></td>
				<td><img id="filename"  style="height:100px;" alt="" src=""></td>
			</tr>
		</table>
	</div>
	<div><input class="submit" type="button" onclick="submitProduct()" value="提交"></div>
</form>
</div>
<script>
function back(){
	history.back(-1);
}
/* function uploadPic(){
	var files = $("#uploadPic").prop('files');
	var data = new Formdata();
	data.append('uploadPic',files[0]);
	
	$.ajax({
		url:"../../product/upload",
		type:"POST",
		data:data,
		cache:false,
		processData:false,
		contentType:false
	});
} */
function getBasePath(){
	var curPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curPath.indexOf(pathName);
	var localhost = curPath.substring(0,pos);
	var project = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var basePath = localhost+project+"/";
	return basePath;
}
function submitProduct(){
	var formData = new FormData();
	formData.append("file",$("#file")[0].files[0]);
	formData.append("productCode",$("#productCode").val());
	formData.append("modelName",$("#modelName").val());
	
	$.ajax({
		type:"post",
		url:"../../product/addModel",
		data:formData,
		async:false,
		cache:false,
		contentType:false,
		processData:false,
		success:function(ret){
			if(ret.success){
				$("#filename").attr("src",getBasePath()+"service/images/" +ret.message);
				alert("保存成功");
			}else{
				alert(ret.message);
				$("#filename").attr("src","");
			}
		},error:function(ret){
			alert("保存出错");
		}
	});
	
	/* var formObject={};
	var formArray=$("#createProductModelForm").serializeArray();
	for(var i=0;i<formArray.length;i++){
		formObject[formArray[i].name] = formArray[i].value;
	}
	$.ajax({
        url : "../../product/addModel",
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
            	window.location.href="productModel_create.jsp?productCode="+result.message;
            }else{
            	alert(result.message);
            }
        },
        error:function(result){
            alert("查询失败");
        }
    }); */
}
</script>
</body>
</html>