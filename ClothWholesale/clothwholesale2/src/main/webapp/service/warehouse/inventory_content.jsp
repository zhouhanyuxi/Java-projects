<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../other/layui/layui.js"></script>
<link rel="stylesheet" href="../other/layui/css/layui.css" />
<!-- <link rel="stylesheet" href="../styles/main.css"/> -->
</head>
<body>
	    <div class="layui-form layui-card-header ">
	      	<div class="layui-inline">
			        
			        <div class="layui-inline">
			          <label class="layui-form-label">仓库编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="warehouseCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline">
			          <label class="layui-form-label">产品型号</label>
			          <div class="layui-input-block">
			            <input type="text" name="modelCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-inventoryIORec-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
			      </div>
	      	</div>
	    
    	<div class="message"><span id="message"></span></div>
    		<div class="layui-card-body">
	      
	      <table id="cws-inventoryIORec-table" lay-filter="cws-inventoryIORec-table">
	      	
	      	
	      </table>
	    
	    </div>


<script>
	layui.use(['jquery','table','layer','form'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-inventoryIORec-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	form.render();
	
	var events={ 
			addinventoryIORec:function(){
				layer.prompt({
					formType:0,
					title:"请输入供应商编号",
					maxlength:5
				},function(value,index,elem){
					$.ajax({
						type:"post",
						url:"supplier/findById",
						data:{
							"supplier":value
						},
						success:function(data){
							
							//关闭窗口
							layer.close(index);
							layer.alert('未找到供应商编号', {icon: 1}); 
							funs.renderListTable();
						},
						error:function(result){
							layer.close(index);
							layer.alert('查找供应商编号出错', {icon: 1}); 
							funs.renderListTable();
				        }
					});
				})
			},
		deleteinventoryIORec:function(ele){
  			var inventoryIORecId = ele.attr("data-id");
  			layer.confirm('确认删除该采购订单?', {icon: 3, title:'提示'}, function(index){
			  //do something
			  	$.ajax({
					type:"post",
					url:"purchase/deleteOrd",
					data:{
						"id":inventoryIORecId
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
	             '<a data-id='+d.inventoryIORecCode+' inventoryIORec-event-type="deleteinventoryIORec" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../inventory/list',//请求路径
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
	                {field: 'inventoryContInd', title: '记录编号', sort: true },
	                {field: 'warehouseCode', title: '仓库编号', sort: true },
	                {field: 'modelCode', title: '产品型号编号', sort: true },
	                {field: 'ContentSum', title: '数量（米）', sort: true }
	                ] ]
			})
			
			
			//监听搜索
		  	form.on('submit(cws-inventoryIORec-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-inventoryIORec-table',{
		    		where:field
		    	});
		    	 
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[inventoryIORec-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("inventoryIORec-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
</body>
</html>