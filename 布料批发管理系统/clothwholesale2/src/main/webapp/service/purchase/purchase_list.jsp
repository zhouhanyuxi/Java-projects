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
			          <label class="layui-form-label">订单编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="purchaseOrdCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline" >
			          <label class="layui-form-label">款项</label>
			          <div class="layui-input-block">
			          	<select name="type" lay-verify="required" lay-filter="peroid">
			          		<option value="-1" selected>请选择</option>
			          		<option value="0">未付清</option>
							<option value="1">已付清</option>
			          	</select>
			          </div>
			        </div>
			        
			        
			        <div class="layui-inline">
			          <label class="layui-form-label">供应商编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="supplierCode" placeholder="请输入" autocomplete="off" class="layui-input">
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
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" purchaseOrd-event-type="addpurchaseOrd">添加采购订单</button>
	      </div>
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" purchaseOrd-event-type="viewItem">查看采购订单项</button>
	      </div>
	      
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
			addpurchaseOrd:function(){
				layer.prompt({
					formType:0,
					title:"请输入供应商编号",
					maxlength:5
				},function(value,index,elem){
					
					$.ajax({
						type:"post",
						url:"../../purchase/createOrd",
						data:{
							"supplierCode":value
						},
						success:function(ret){
							if(ret.success){
								layer.close(index);
								var pOrder = ret.message;
								window.location.href("purchaseItem_create.jsp?supplierCode="+pOrder.supplierCode+"&pOrdCode="+pOrder.purchaseOrdCode);
							}else{
								//关闭窗口
								layer.close(index);
								layer.alert(ret.message);
								funs.renderListTable();
							}
						}
					});
				})
			},
			viewItem:function(ele){
				window.location.href="purchaseItem_list.jsp";
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
  		},
  		addpurchaseItem:function(ele){
  			var purchaseOrdId = ele.attr("data-id");
  			var supplierCode = ele.attr("data-supplier");
  			
  			window.location.href("purchaseItem_create.jsp?supplierCode="+supplierCode+"&pOrdCode="+purchaseOrdId);
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
				url:'../../purchase/listOrder',//请求路径
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
	                {field: 'purchaseOrdCode', title: '订单编号', sort: true },
	                {field: 'supplierCode', title: '供应商编号', sort: true },
	                {field: 'adminCode', title: '管理员编号', sort: true },
	                {field: 'sumPrice', title: '订单金额', sort: true },
	                {field: 'paidPrice', title: '已付金额', sort: true },
	                {field: 'remark', title: '备注', sort: false}, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		   			'<a data-supplier='+d.supplierCode+' data-id='+d.purchaseOrdCode+' purchaseOrd-event-type="addpurchaseItem" >添加订单项</a>', 
	       		             '<a data-id='+d.purchaseOrdCode+' purchaseOrd-event-type="deletepurchaseOrd" >删除</a>', 
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