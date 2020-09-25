<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script src="../other/layui/layui.js"></script>
<script src="../js/jquery.js"></script>
<script src="../js/jquery.validate.js"></script>
<link rel="stylesheet" href="../other/layui/css/layui.css" />
<style>
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
</style>
</head>
<body>
<div class="">
  	<div class="layui-card">
	    <div class="layui-form layui-card-header " >
	      	<div>
			      <div class="layui-form-item">
			        <div class="layui-inline">
			          <label class="layui-form-label">产品名称</label>
			          <div class="layui-input-block">
			            <input type="text" name="productName" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        <div class="layui-inline">
			          <label class="layui-form-label">产品编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="productCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-product-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
			      </div>
	      	</div>
	    </div>
    
	    <div class="layui-card-body">
	    	
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" product-event-type="addproduct">添加</button>
	      </div>
	      
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
			addproduct:function(){
				alert("添加");
				window.location.href="product_create.jsp";
			},
		deleteproduct:function(ele){
  			var productId = ele.attr("data-id");
  			layer.confirm('确认删除该产品?', {icon: 3, title:'提示'}, function(index){
			  //do something
			  	$.ajax({
					type:"post",
					url:"product/delete",
					data:{
						"id":productId
					},
					success:function(data){
						//删除成功关闭窗口
						layer.alert('删除成功', {icon: 1}); 
						funs.renderListTable();
					}
				});
			  
			});
  		},
  		changeState:function(ele){
  			var productId = ele.attr("data-id");
  			$.ajax({
					type:"post",
					url:"../../product/changeState",
					data:{
						"productCode":productId
					},
					success:function(ret){
						//删除成功关闭窗口
						if(ret.success){
							alert("改变成功");
							funs.renderListTable();
						}else{
							alert(ret.message);
						}
					},
					error:function(ret){
						//关闭窗口
						alert("改变出错");
						funs.renderListTable();
					}
  			});
  		},
  		addmodel:function(ele){
  			var productId = ele.attr("data-id");
  			window.location.href="productModel_create.jsp?productCode="+productId;
  			
  		},
  		addPrice:function(ele){
  			var productId = ele.attr("data-id");
  			layer.open({
  				id:1,
  				type:1,
  				title:'向产品'+productId+'添加价格',
  				skin:'layui-layer-rim',
  				area:['300px','auto'],
  				content:
  					"<div class='row col-sm-12' style='margin-left:50px'><form class='form-horizontal m-t' novalidate='novalidate'>"+
  					"<div class='form-group'><label class='col-sm-3 control-label'>数量下限：</label>"+
  					"<div class='col-sm-8'><input type='text' id='lowerLimit' class='form-control' required='' aria-required='true'></div></div>"+
  					"<div class='form-group'><label class='col-sm-3 control-label'>价格：</label>"+
  					"<div class='col-sm-8'><input type='text' id='price' class='form-control' required='' aria-required='true'></div></div>"+
  					"</form></div>"
  				,
  				btn:['确定','取消'],
  				btn1:function(index,layero){
  					var low = $("#lowerLimit").val();
  					var price = $("#price").val();
  					
  					$.ajax({
  						type:"post",
  						url:"../../product/addPrice",
  						data:{
  							"productCode":productId,
  							"lowerLimit":low,
  							"price":price
  						},
  						success:function(ret){
  							//删除成功关闭窗口
  							if(ret.success){
  								alert("添加成功");
  	  							funs.renderListTable();
  							}else{
  								alert(ret.message);
  							}
  						},
  						error:function(ret){
  						//关闭窗口
  							alert("添加出错");
  							funs.renderListTable();
  						}
  					});
  					
  					layer.close(index);
					funs.renderListTable();
  				},
  				btn2:function(index,layero){
  					layer.close(index);
  				}
  			});
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
				url:'../../product/list',//请求路径
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
	                {field: 'state', title: '状态', sort: false
	                    ,templet: function(row){
	                    	if(row.state == 'T'){
	                    		return '<span style="color: #c00;">上架</span>'
	                    	}else{
	                    		return '<span style="color: #c00;">下架 </span>'
	                    	}
	                    }
	               }, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		            '<a href="">编辑</a>&nbsp;', 
	       		       		'&nbsp;<a data-id='+d.productCode+' product-event-type="changeState" >改变状态</a>',
	       		          	'&nbsp;<a data-id='+d.productCode+' product-event-type="addPrice" >添加价格</a>',
	       		       		'&nbsp;<a data-id='+d.productCode+' product-event-type="addmodel" >添加型号</a>', 
	       		       		'&nbsp;<a data-id='+d.productCode+' product-event-type="deleteproduct" >删除</a>',
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