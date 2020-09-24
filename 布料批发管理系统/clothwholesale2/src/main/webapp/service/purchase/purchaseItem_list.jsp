<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script src="../other/layui/layui.js"></script>
<link rel="stylesheet" href="../other/layui/css/layui.css" />
<!-- <link rel="stylesheet" href="../styles/main.css"/> -->
</head>
<body>
	    <div class="layui-form layui-card-header " >
	      	<div class="layui-inline">
			      <div class="layui-inline">
			          <label class="layui-form-label">订单项编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="purchaseItemCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline" >
			          <label class="layui-form-label">款项</label>
			          <div class="layui-input-block">
			          	<select name="type" lay-verify="required" lay-filter="peroid">
			          		<option value="-1" selected>请选择</option>
			          		<option value="YF">已付款</option>
							<option value="DF">待付款</option>
							<option value="YR">已入库</option>
							<option value="DR">待入库</option>
			          	</select>
			          </div>
			        </div>
			        

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-purchaseOrd-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
			      </div>
	      	</div>
	    
    	<div class="message"><span id="message"></span></div>
    	
	    <div class="layui-card-body">
	      
	      
	      <table id="cws-purchaseOrd-table" lay-filter="cws-purchaseOrd-table">
	      	
	      	
	      </table>
	    
	    </div>


<script>
	layui.use(['jquery','table','layer','form'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-purchaseOrd-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	form.render();
	
	var events={ 
			pay:function(ele){
				var purchaseItemCode = ele.attr("data-id");
				var price = parseFloat(ele.attr("data-price"));
				var num = parseInt(ele.attr("data-num"));
				$.ajax({
					type:"post",
					url:"../../purchase/payForItem",
					data:{
						'pItemCode':purchaseItemCode,
						'price':price*num
					},
					success:function(result){
						if(result.success){
							alert("付款成功！");
						}else{
							alert(result.message);
						}
						funs.renderListTable();
					}
				});
			},
			applyIn:function(ele){
				var purchaseItemCode = ele.attr("data-id");
				$.ajax({
					type:"post",
					url:"../../purchase/applyIn",
					data:{
						'pItemCode':purchaseItemCode,
					},
					success:function(result){
						if(result.success){
							alert("申请成功！");
						}else{
							alert(result.message);
						}
						funs.renderListTable();
					}
				});
			},
		deletepurchaseOrd:function(ele){
  			var purchaseOrdId = ele.attr("data-id");
  			layer.confirm('确认删除该采购订单?', {icon: 3, title:'提示'}, function(index){
			  //do something
			  	$.ajax({
					type:"post",
					url:"purchase/deleteOrd",
					data:{
						"id":purchaseOrdId
					},
					success:function(data){
						//删除成功关闭窗口
						layer.close(index);
						layer.alert('删除成功', {icon: 1}); 
						funs.renderListTable();
					}
				});
			  
			});
  		}
	}
	
	var funs={ 
		
		
		//操作中显示的内容
	 /*    opComplain:function(d){
	   		return [
	   			'<div>',
	            '<a href="">编辑</a>', 
	             '<a data-id='+d.purchaseOrdCode+' purchaseOrd-event-type="deletepurchaseOrd" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../purchase/listItem',//请求路径
				page:true,//开启分页
				page:!0,//页码
				limit:10,//每页大小
				request:{
					pageName:'page', //页码的参数名称 ，默认page
					limitName:'size' //每页数据量的参数名称 , 默认 limit
				},
				text:{
					none:'暂无相关数据'
				},
				parseData: function(res){ //res 即为原始返回的数据
			        return {
			            "code": 0, //解析接口状态
			            "msg": '', //解析提示文本
			            "count": res.data.total, //解析数据长度
			            "data": res.data.list //解析数据列表
			        }
			    },
			    cols:[[ //表头
	                {field: 'purchaseItemCode', title: '订单项编号', sort: true },
	                {field: 'modelCode', title: '产品型号', sort: true },
	                {field: 'totalNum', title: '数量(米)', sort: true },
	                {field: 'orignalPrice', title: '金额', sort: true },
	                {field: 'state', title: '状态', sort: false
	                	,templet: function(row){
	                    	if(row.state == 'DF'){
	                    		return '<span style="color: #c00;">待付款</span>'
	                    	}else if(row.state == 'YF'){
	                    		return '<span style="color: #c00;">已付款</span>'
	                    	}else if(row.state == 'DR'){
	                    		return '<span style="color: #c00;">待入库</span>'
	                    	}else if(row.state == 'YR'){
	                    		return '<span style="color: #c00;">已入库</span>'
	                    	}
	                    }	
	                }, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		   			'<a data-price='+d.orignalPrice+' data-num='+d.totalNum+' data-id='+d.purchaseItemCode+' purchaseOrd-event-type="pay" >付款</a>', 
	       		   			'<a data-id='+d.purchaseItemCode+' purchaseOrd-event-type="applyIn" >申请入库</a>', 
	       		             '<a data-id='+d.purchaseItemCode+' purchaseOrd-event-type="deletepurchaseOrd" >删除</a>', 
	       			     	'</div>'
	       		     	].join('');
	       		    }, title: '操作'}
		        ] ]
		         
			})
			
			
			//监听搜索
		  	form.on('submit(cws-purchaseOrd-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-purchaseOrd-table',{
		    		where:field
		    	});
		    	 
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[purchaseOrd-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("purchaseOrd-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
</body>
</html>