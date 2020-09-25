<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../other/layui/layui.js"></script>
<link rel="stylesheet" href="../other/layui/css/layui.css" />
</head>

<body>
<div class="">
  	<div class="layui-card">
	    <div class="layui-form layui-card-header " >
	      	<div>
			      <div class="layui-form-item">
			        <div class="layui-inline">
			          <label class="layui-form-label">供应商名称</label>
			          <div class="layui-input-block">
			            <input type="text" name="supplierName" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        <div class="layui-inline">
			          <label class="layui-form-label">供应商编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="supplierCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-supplier-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
			      </div>
	      	</div>
	    </div>
    
	    <div class="layui-card-body">
	    	
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" supplier-event-type="addsupplier">添加</button>
	      </div>
	      
	      <table id="cws-supplier-table" lay-filter="cws-supplier-table">
	      	
	      	
	      </table>
	    
	    </div>
	</div>
</div>

<script>
	layui.use(['jquery','table','layer'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-supplier-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	var events={ 
			addsupplier:function(){
				alert("ss")
			},
		deletesupplier:function(ele){
  			var supplierId = ele.attr("data-id");
  			layer.confirm('确认删除该产品?', {icon: 3, title:'提示'}, function(index){
			  //do something
			  	$.ajax({
					type:"post",
					url:"supplier/delete",
					data:{
						"id":supplierId
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
	             '<a data-id='+d.supplierCode+' supplier-event-type="deletesupplier" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../supplier/list',//请求路径
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
	                {field: 'supplierCode', title: '供应商编号', sort: true } ,
	                {field: 'supplierName', title: '供应商名称', sort: true },
	                {field: 'mobile', title: '电话', sort: true },
	                {field: 'contactName', title: '联系人', sort: true}, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		            '<a href="">查看</a>', 
	       		             '<a data-id='+d.supplierCode+' supplier-event-type="deletesupplier" >删除</a>', 
	       			     	'</div>'
	       		     	].join('');
	       		    }, title: '操作'}
		        ] ]
		         
			})
			
			
			//监听搜索
		  	form.on('submit(cws-supplier-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-supplier-table',{
		    		where:field
		    	});
		    	 
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[supplier-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("supplier-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
</body>
</html>