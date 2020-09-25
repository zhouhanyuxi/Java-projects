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
			      
			        <div class="layui-inline">
			          <label class="layui-form-label">产品名称</label>
			          <div class="layui-input-block">
			            <input type="text" name="productName" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        <!-- 
			        <div class="layui-inline">
			          <label class="layui-form-label">克重上限</label>
			          <div class="layui-input-block">
			            <input type="text" name="weight1" placeholder="请输入" size="5" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        <div class="layui-inline">
			          <label class="layui-form-label">-</label>
			          <div class="layui-input-block">
			            <input type="text" name="weight2" placeholder="请输入" size="5" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			            
			        
			        <div class="layui-inline">
			          <label class="layui-form-label">幅宽上限</label>
			          <div class="layui-input-block">
			            <input type="text" name="width1" placeholder="请输入" size="5" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline">
			          <label class="layui-form-label">-</label>
			          <div class="layui-input-block">
			            <input type="text" name="width2" placeholder="请输入" size="5" autocomplete="off" class="layui-input">
			          </div>
			        </div> -->

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-product-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
	      	</div>
	    </div>
    
	    <div class="layui-card-body">
	    
	      
	      <table id="cws-product-table" lay-filter="cws-product-table">
	      	
	      	
	      </table>
	    
	    </div>
	</div>
</div>

<!-- <div class="row">
	<div class="input-group">
		<span class="input-group-addon">型号名称</span>
		<input id="modelName" type="text" class="form-control" placeholder="请输入" >
	</div>
	<div class="input-group">
		<span class="input-group-addon">数量</span>
		<input id="modelName" type="text" class="form-control" placeholder="请输入" >
	</div>
</div> -->
<script>
	layui.use(['jquery','table','layer','form'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-product-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	var events={ 
			
			detail:function(ele){
  			var productId = ele.attr("data-id");
  			window.location.href="viewProduct.jsp?productCode="+productId;
  		}
	}
	
	var funs={ 
		
		
		//操作中显示的内容
	 /*    opComplain:function(d){
	   		return [
	   			'<div>',
	            '<a href="">编辑</a>', 
	             '<a data-id='+d.productCode+' product-event-type="deleteproduct" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../product/listPic',//请求路径
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
	                {field: 'productCode', title: '产品编号', sort: true } ,
	                {field: 'productName', title: '产品名称', sort: true },
	                {field: 'typeTotal', title: '型号数', sort: true },
	               /*  {field: 'filename', title: '图片', sort: false
	                    ,templet: function(row){
	                    		return '<img id="picture" style="height:50px;" alt="" src="'+row.filename+'">'
	                    }
	               	},  */
	                {field: 'width', title: '幅宽', sort: true },
	                {field: 'weight', title: '克重', sort: true },
	               	{templet: function(d){
	       	   			return [
	       		   			'<div>', 
	       		            '<a data-id='+d.productCode+' product-event-type="detail" >查看</a>&nbsp;',  
	       			     	'</div>'
	       		     	].join('');
	       		    }, title: '操作'}
		        ] ]
		         
			})
			
			
			//监听搜索
		  	form.on('submit(cws-product-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-product-table',{
		    		where:field
		    	});
		    	 
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[product-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("product-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
</body>
</html>