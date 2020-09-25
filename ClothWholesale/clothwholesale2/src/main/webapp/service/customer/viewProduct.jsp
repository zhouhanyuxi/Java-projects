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
	text-align:center;
	font-family:"微软雅黑";
}
.title{
	padding: 10px;
    margin: 0 auto;
    width:100%;
    color: #4CAF50;
    font-size: 20px;
}
.left{
	float:left;
	width:50%;
	height:350px;
}
.right{
	overflow:hidden;
	height:350px;
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
select{
	margin:10px;
	height:40px;
	width:100px;
	border:1px #4CAF50 solid;
	border-radius:5px;
}
table{
	margin: 10px auto;
}
</style>
</head>
<body>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<div id="content" style="width:100%;">
<div><button  onclick="back()">返回</button></div>
<div class="title" id=title></div>
<div><span id="message"></span></div>
<form id="createProductForm" >	
	<div style="width:100%" >
		<div class="left">
			<img id="picture" style="height:350px;width:350px" alt="" src="../images/GYS0100001000-1.jpg">
		</div>
		<div class="right">
			<table >
				<tbody id="priceList">
					
				</tbody>
				<tr>
					<td><label>产品型号</label></td>
					<td>
					<select name="modelCode" id="modelCode" onchange="loadPic()">
					</select>
					</td>
				</tr>
				<tr>
					<td><label>库存</label></td>
					<td><input type="text"  id="totalNum" name="totalNum" size="5" disabled>米</td>
				</tr>
				<tr>
					<td><label>数量</label></td>
					<td><input type="text"  id="number" name="number" size="5">米</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" onclick="createOrder()" value="下单">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div>
		<table style="text-align:left">
			<tr>
				<td>产品编号</td>
				<td>
					<input type="text" name="productCode" id="productCode" size="10" disabled value="${param.productCode}">
				</td>
				<td>产品原名</td>
				<td>
					<input type="text" name="originalName" id="originalName" size="10" disabled>
				</td>
				<td>原料</td>
				<td>
					<input type="text" name="ingredient" id="ingredient" size="10" disabled>
				</td>
			</tr>
			<tr>
				<td>宽度</td>
				<td>
					<input type="text" name="width" id="width" size="5" disabled>厘米
				</td>
				<td>克重</td>
				<td>
					<input type="text" name="weight" id="weight" size="5" disabled>克/平方米
				</td>
				<td>纱支</td>
				<td>
					<input type="text" name="thickness" id="thickness" size="10" disabled>
				</td>
			</tr>
	</table>
	</div>
</form>
</div>
<script>
var list=null;
function back(){
	history.back(-1);
}
$(function(){
	findModel();
	findPrice();
	var value = $("#productCode").val();
	$.ajax({
		type:"post",
		url:"../../product/findById",
		data:{
			'productCode':value
		},
		success:function(ret){
			if(ret.success){
				var p = ret.data;
				$("#title").text(p.productName);
				$("#productCode").val(p.productCode);
				$("#originalName").val(p.originalName);
				$("#ingredient").val(p.ingredient);
				$("#width").val(p.width);
				$("#weight").val(p.weight);
				$("#thickness").val(p.thickness);
			}else{
				alert(ret.message);
			}
		}
	});
	
	
	
});
function findPrice(){
	var value = $("#productCode").val();
	$.ajax({
		type:"post",
		url:"../../product/findPrice",
		data:{
			'productCode':value
		},
		success:function(ret){
			if(ret.success){
				list = ret.data;
				$("#priceList").empty();
				for(var i=0;i<list.length;i++){
					$("#priceList").append("<tr><td>>=<input name='lowerLimit' type='text' size='5' disabled value='"+list[i].lowerLimit+"'>米</td><td><input name='price' type='text' size='5' disabled value='"+list[i].price+"'>元</td></tr>");
				}
			}else{
				alert(ret.message);
			}
		}
	});
}
function findModel(){
	var value = $("#productCode").val();
	
	$.ajax({
		type:"post",
		url:"../../product/findModel",
		data:{
			'productCode':value
		},
		success:function(ret){
			if(ret.success){
				list = ret.data;
				$("#modelCode").empty();
				for(var i=1; i<list.length;i++){
					$("#modelCode").append("<option value='"+list[i].modelCode+"'>"+list[i].modelName+"</option>");
				}
				$("#modelCode option:eq(0)").attr("selected","selected");
				loadPic();
			}else{
				alert(ret.message);
			}
		}
	});
}
function getBasePath(){
	var curPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curPath.indexOf(pathName);
	var localhost = curPath.substring(0,pos);
	var project = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	var basePath = localhost+project+"/";
	return basePath;
}
function loadPic(){
	var value = $("#modelCode").val();
	for(var i=1;i<list.length;i++){
		if(list[i].modelCode == value){
			$("#totalNum").val(list[i].totalNum);
			break;
		}	
	}
	$.ajax({
		type:"post",
		url:"../../product/findPic",
		data:{
			'modelCode':value
		},
		success:function(ret){
			if(ret.success){
				var p = ret.data;
				
				var src = getBasePath()+"service/images/" +p.filename;
				$("#picture").attr("src",src);
				
			}else{
				alert(ret.message);
				
			}
		}
	});
}
function createOrder(){
	var number = $("#number").val();
	var totalNum = $("#totalNum").val();
	var lowerLimit = $("input[name='lowerLimit']");
	var price = $("input[name='price']");

	if(number>totalNum){
		alert("库存不足");
	}else{
		var realPrice = 0;
		for(var i=0;i<lowerLimit.length;i++){
			if(parseInt(number)>=parseInt($("input[name='lowerLimit']:eq("+i+")").val())){
				realPrice = $("input[name='price']:eq("+i+")").val();
			}
		}
		window.location.href="wholesaleOrder_create.jsp?modelCode="+$("#modelCode").val()+"&number="+number+"&realPrice="+realPrice;
	}
}
</script>
</body>
</html>