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
			          <label class="layui-form-label">订单编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="wholesaleOrdCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        <div class="layui-inline">
			          <label class="layui-form-label">管理员编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="adminCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline" >
			          <label class="layui-form-label">记录状态</label>
			          <div class="layui-input-block">
			          	<select name="recordState" lay-verify="required" lay-filter="peroid">
			          		<option value="-1">请选择</option>
			          		<option value="DQ">待确认</option>
							<option value="YQ">已确认</option>
							<option value="QX">已取消</option>
							<option value="JJ">已拒绝</option>
			          	</select>
			          </div>
			        </div>
			        

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-wholesaleOrd-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
			      </div>
	      	</div>
	    </div>
    
	    <div class="layui-card-body">
	    	
	      <table id="cws-wholesaleOrd-table" lay-filter="cws-wholesaleOrd-table">
	      	
	      	
	      </table>
	    
	    </div>
	</div>
</div>

<script>
	layui.use(['jquery','table','layer'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-wholesaleOrd-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	var events={ 
			addwholesaleOrd:function(){
				alert("ss")
			},
		out:function(ele){
  			var wholesaleOrdId = ele.attr("data-id");
  			layer.confirm('确认删除该产品?', {icon: 3, title:'提示'}, function(index){
			  //do something
			  	$.ajax({
					type:"post",
					url:"wholesale/delete",
					data:{
						"id":wholesaleOrdId
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
	             '<a data-id='+d.wholesaleOrdCode+' wholesaleOrd-event-type="deletewholesaleOrd" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../wholesale/listCancel',//请求路径
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
	                {field: 'wholesaleOrdCode', title: '订单编号', sort: true } ,
	                {field: 'adminCode', title: '管理员', sort: true },
	                {field: 'recordState', title: '记录状态', sort: true 
	                	,templet: function(row){
	                    	if(row.orderState == 'DQ'){
	                    		return '<span style="color: #c00;">待确认</span>'
	                    	}else if(row.orderState == 'YQ'){
	                    		return '<span style="color: #c00;">已确认</span><a data-id='+row.wholesaleOrdCode+' product-event-type="out" >出库</a>'
	                    	}else if(row.orderState == 'QX'){
	                    		return '<span style="color: #c00;">已取消</span>'
	                    	}else if(row.orderState == 'JJ'){
	                    		return '<span style="color: #c00;">已拒绝</span>'
	                    	}
	                    }
	                },
	                {field: 'moneyState', title: '款项状态', sort: true
	                	,templet: function(row){
	                    	if(row.orderState == 'DT'){
	                    		return '<span style="color: #c00;">待付款</span>'
	                    	}else if(row.orderState == 'YT'){
	                    		return '<span style="color: #c00;">已付款</span><a data-id='+row.wholesaleOrdCode+' product-event-type="out" >出库</a>'
	                    	}
	                    }
	               }, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		            '<a href="">查看</a>', 
	       			     	'</div>'
	       		     	].join('');
	       		    }, title: '操作'}
		        ] ]
		         
			})
			
			
			//监听搜索
		  	form.on('submit(cws-wholesaleOrd-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-wholesaleOrd-table',{
		    		where:field
		    	});
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[wholesaleOrd-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("wholesaleOrd-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
</body>
</html>