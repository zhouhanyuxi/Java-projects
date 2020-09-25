<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>批发下单</title>
<style type="text/css">
body{
	margin:10px 50px; 
	padding:10px;
	font-family:"微软雅黑";
}
.title{
	padding: 10px;
    margin: 10px auto;
    width:100%;
    color: #4CAF50;
    font-size: 20px;
}
.title1{
	padding: 10px;
    margin: 10px auto;
    width:100%;
    color: #4CAF50;
    font-size: 15px;
}
.otherInfo{color:red;}
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
    padding: 10px;
    margin:5px;
    border-radius: 5px;
    color: #d9eef7;
    border: solid 1px;
    background: #4CAF50;
}
input[type="button"]:hover{
    background: #007ead;
}
table{
	border:1px solid #c8cccf;
	margin:10px;
	text-align:center;
}
</style>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validate.js"></script>
</head>
<body>
<div>
	<div class="title">提交批发订单</div>
	<form  id="">
	<div>
		<div class="title1">选择收货地址</div>
		<table>
			<thead>
				<th></th><th>联系人</th><th>电话</th><th>地址</th><th>邮编</th>
			</thead>
			<tbody id="addressList">
				<!-- <tr>
					<td><input type="radio" name="address" value="1" checked="checked"></td>
					<td><input type="text" name="contactName" size="10" disabled value="周寒聿西"></td>
					<td><input type="text" name="mobile" size="15" disabled value="13844444444"></td>
					<td><input type="text" name="shippingAddr" size="50" disabled value="江西省南昌市南京东路235号南昌大学软件学院"></td>
					<td><input type="text" name="postcode" size="10" disabled value="330000"></td>
				</tr>
				<tr>
					<td><input type="radio" name="address" value="2"></td>
					<td><input type="text" name="contactName" size="10" disabled value="周寒"></td>
					<td><input type="text" name="mobile" size="15" disabled value="13844444444"></td>
					<td><input type="text" name="shippingAddr" size="50" disabled value="江西省宜春市南京东路235号"></td>
					<td><input type="text" name="postcode" size="10" disabled value="330000"></td>
				</tr> -->
			</tbody>
			
		</table>
	</div>
	<div>
		<div class="title1">确认订单信息</div>
		<table>
			<tr>
				<th>图片</th><th>产品</th><th>型号</th><th>单价</th><th>数量</th><th>小计</th>
			</tr>
			<tr>
				<td><img style="height:100px"alt="${param.modelCode}" src=""></td>
				<td class="productName"></td>
				<td class="modelName"></td>
				<td id="price">${param.realPrice}</td>
				<td id="totalNum">${param.number}</td>
				<td id="totalPrice"></td>
			</tr>
		</table>
		<div class="otherInfo">
			<table>
			<tr >
				<td rowspan="2" >
					<label>备注：</label>
					<textarea name="remark" rows="3" cols="30"></textarea>
				</td>
				<td><label>运费：￥</label></td><td><input type="text" name="shippingFee" id="shippingFee" size="5" disabled value="0.00"></td>
			</tr>
			<tr>
				<td><label>总计：￥</label></td><td><input type="text" id="sumPrice" name="sumPrice" size="5" disabled value="21500.00"></td>
			</tr>
			</table>
			<input type="button" onclick="orderSubmit()" value="提交">
		</div>
	</div>
	</form>
</div>
<script type="text/javascript">
$(function(){
	getAddress();
	getModelInfo();
});
function getAddress(){
	$.ajax({
		type:"post",
		url:"../../customer/findAddress",
		success:function(ret){
			if(ret.success){
				alert("成功得到地址");
				var list = ret.data;
				$("#addressList").empty();
				for(var i=0;i<list.length;i++){
					$("#addressList").append("<tr><td><input type='radio' name='shippingAddrNum' id='shippingAddrNum'  value='"+list[i].shippingAddrNum+"'></td>"+
							"<td><input type='text' name='contactName' size='10' disabled value='"+list[i].contactName+"'></td>"+
							"<td><input type='text' name='mobile' size='15' disabled value='"+list[i].mobile+"'></td>"+
							"<td><input type='text' name='shippingAddr' size='50' disabled value='"+list[i].shippingAddr+"'></td>"+
							"<td><input type='text' name='postcode' size='10' disabled value='"+list[i].postcode+"'></td></tr>");
				}
				$("input[name='address']:eq(0)").attr("checked","checked");
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
function getModelInfo(){
	var modelCode = $("img").attr("alt");
	var totalNum = $("#totalNum").text();
	var price = $("#price").text();
	var shippingFee = $("#shippingFee").val();
	
	$.ajax({
		type:"post",
		url:"../../product/findModelInfo",
		data:{
			'modelCode':modelCode
		},
		success:function(ret){
			if(ret.success){
				var info = ret.data;
				alert(info.filename);
				$(".productName").text(info.productName);
				$(".modelName").text(info.modelName);
				$("#totalPrice").text(price*totalNum);
				if(info.shippingFee!=null)
					$("#shippingFee").val(info.shippingFee);
				var totalPrice = $("#totalPrice").text();
				$("#sumPrice").val(price*totalNum+info.shippingFee);
				$("img").attr("src",getBasePath()+"service/images/"+info.filename);
			}else{
				alert(ret.message);
			}
		}
	});
}
function orderSubmit(){
	var shippingAddrNum = $("input[name='shippingAddrNum']:checked").val();
	var sumPrice = $("#sumPrice").val();
	var remark = $("#remark").text();
	var modelCode = $("img").attr("alt");
	var totalNum = $("#totalNum").text();
	var price = $("#price").text();
	
	/* var formData = new FormData();
	formData.append("shippingAddrNum",shippingAddrNum);
	formData.append("sumPrice",sumPrice);
	formData.append("modelCode",modelCode);
	formData.append("remark",remark);
	formData.append("totalNum",totalNum);
	formData.append("price",price); */
	
	$.ajax({
		type:"post",
		url:"../../wholesale/createOrd",
        dataType:"json",
        contentType : "application/json;charset=UTF-8",
		data:JSON.stringify({
			shippingAddrNum:shippingAddrNum,
			sumPrice:sumPrice,
			remark:remark,
			modelCode:modelCode,
			totalNum:totalNum,
			price:price
		}),
		success:function(ret){
			if(ret.success){
				alert("提交成功");
				alert("确认付款￥"+$("#sumPrice").val());
				var ordCode = ret.message;
				$.ajax({
					type:"post",
					url:"../../wholesale/pay",
					data:{
						'wOrderCode':ordCode
					},
					success:function(ret){
						if(ret.success){
							alert("付款成功");
						}else{
							alert(ret.message);
						}
					}
				});
			}else{
				alert(ret.message);
			}
		}
	});
	
}
</script>
</body>
</html>