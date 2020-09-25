<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.ncu.clothwholesale.pojo.Admin" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>create Purchase Order</title>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validate.js"></script>
<style type="text/css">
body{
	margin:10px; 
	padding:10px;
	font-family:"微软雅黑";
}

.title{
	padding: 10px;
    margin: 0 auto;
    width:100%;
    color: #4CAF50;
    font-size: 20px;
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
    background: #007ead;
}
table{
	width:100%;
	text-align:left;
}
select{
	margin:10px;
	height:40px;
	width:200px;
	border:1px #4CAF50 solid;
	border-radius:5px;
}
option:selected{
	background:#4CAF50;
	color:white;
}
</style>

</head>
<body>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<div>
<div class="title">添加采购订单</div>
<div><button  onclick="back()">返回</button></div>
<form id="createPurchaseItemForm">
	<div>
		<div class="info">
			<label>供应商编号：</label>
			<input type="text" id="supplierCode"  maxlength="5" size="5" disabled value="${param.supplierCode}">
			<label>订单编号：</label>
			<input type="text" id="purchaseOrdCode" name="purchaseOrdCode" maxlength="19" size="20" disabled value="${param.pOrdCode}">
		</div>
		<div><span id="message"></span></div>
	</div>
	<div>
		<table>
			<tr>
				<td>产品名称</td>
				<td>
					<select  id="productCode"  onchange="findModel()">
					</select>
				</td>
				<td>产品编号</td>
				<td>
					<input type="text"  id="code" disabled>
				</td>
			</tr>
			<tr>
				<td>产品型号编号</td>
				<td>
					<select name="modelCode" id="modelCode" onchange="loadPic()">
					
					</select>
				</td>
				<td>图片</td>
				<td><img id="picture" style="height:100px;" alt="" src=""></td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td>数量</td>
				<td><input type="text" name="totalNum" id="totalNum" size="5" >米</td>
			</tr> 
			<tr>
				<td>进价单价</td>
				<td><input type="text" name="originalPrice" id="originalPrice" size="5">元/米</td>
			</tr>
		</table>
	</div>
	<div><input class="submit" type="button" onclick="submitOrder()" value="提交"></div>
</form>
</div>
<script type="text/javascript">
var productList = null;
$(function(){
	findProduct();
});

function findProduct(){
	var value = $("#supplierCode").val();
	$.ajax({
		type:"post",
		url:"../../product/findBySupplier",
		data:{
			'supplierCode':value
		},
		success:function(ret){
			if(ret.success){
				productList = ret.data;
				$("#productCode").empty();
				$("#productCode").append("<option value=''>请选择</option>");
				for(var i=0; i<productList.length;i++){
					$("#productCode").append("<option value='"+productList[i].productCode+"'>"+productList[i].productName+"</option>");
				} 
			}else{
				alert(ret.message);
			}
		}
	});
}
function findModel(){
	var value = $("#productCode").val();
	$("#code").val(value);
	
	$.ajax({
		type:"post",
		url:"../../product/findModel",
		data:{
			'productCode':value
		},
		success:function(ret){
			if(ret.success){
				var list = ret.data;
				$("#modelCode").empty();
				$("#modelCode").append("<option value=''>请选择</option>");
				for(var i=1; i<list.length;i++){
					$("#modelCode").append("<option value='"+list[i].modelCode+"'>"+list[i].modelName+"</option>");
				}
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
	$.ajax({
		type:"post",
		url:"../../product/findPic",
		data:{
			'modelCode':value
		},
		success:function(ret){
			if(ret.success){
				var p = ret.data;
				$("#picture").attr("src",getBasePath()+"service/images/"+p.filename);
			}else{
				$("#picture").attr("src","");
				alert(ret.message);
				
			}
		}
	});
}
function back(){
	history.back(-1);
}
/* var ordCode = $("#purchaseOrdCode").val();
var model = $("#modelCode").val();
var num = $("#totalNum").val();
var price = $("#originalPrice").val(); */
/* JSON.stringify({
purchaseOrdCode:ordCode,
modelCode:model,
totalNum:num,
originalPrice:price
}) */
function submitOrder(){
	var ordCode = $("#purchaseOrdCode").val();
	var model = $("#modelCode").val();
	var num = $("#totalNum").val();
	var price = $("#originalPrice").val();
	
	var formData = new FormData();
	formData.append("purchaseOrdCode",ordCode);
	formData.append("modelCode",model);
	formData.append("totalNum",num);
	formData.append("originalPrice",price);
	
	$.ajax({
		type:"post",
		url:"../../purchase/addItem",
		data:formData,
		contentType:false,
		processData:false,
		success:function(ret){
			if(ret.success){
				if(confirm("是否现在付款："+(price*num)+"元")){
					$.ajax({
						type:"post",
						url:"../../purchase/payForItem",
						data:{
							'pItemCode':ret.message,
							'price':price*num
						},
						success:function(result){
							if(result.success){
								alert("付款成功！");
							}else{
								alert(ret.message);
							}
						}
					});
				}else{
					history.back(-1);
				}
			}else{
				alert(ret.message);
			}
		}
	});
}
</script>
</body>
</html>