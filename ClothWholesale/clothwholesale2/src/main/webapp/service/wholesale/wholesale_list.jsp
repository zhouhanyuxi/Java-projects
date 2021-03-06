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
			          <label class="layui-form-label">用户名</label>
			          <div class="layui-input-block">
			            <input type="text" name="username" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        <div class="layui-inline">
			          <label class="layui-form-label">订单编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="wholesaleOrdCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline" >
			          <label class="layui-form-label">订单状态</label>
			          <div class="layui-input-block">
			          	<select name="orderState" lay-verify="required" lay-filter="peroid">
			          		<option value="-1" selected>请选择</option>
			          		<option value="DF">待付款</option>
							<option value="YF">已付款</option>
							<option value="QX">已取消</option>
							<option value="DC">待出库</option>
							<option value="YC">已出库</option>
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
  			
		  	$.ajax({
				type:"post",
				url:"../../wholesale/outApply",
				data:{
					"wholesasleOrdCode":wholesaleOrdId
				},
				success:function(ret){
					if(ret.success){
						layer.alert('成功', {icon: 1}); 
						funs.renderListTable();
					}else{
						alert(ret.message);
					}
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
	             '<a data-id='+d.wholesaleOrdCode+' wholesaleOrd-event-type="deletewholesaleOrd" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../wholesale/list',//请求路径
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
	                {field: 'username', title: '用户名', sort: true },
	                {field: 'sumPrice', title: '金额', sort: true },
	                {field: 'orderState', title: '订单状态', sort: true
	                    ,templet: function(row){
	                    	if(row.orderState == 'DF'){
	                    		return '<span style="color: #c00;">待付款</span>'
	                    	}else if(row.orderState == 'YF'){
	                    		return '<span style="color: #c00;">已付款</span>'
	                    	}else if(row.orderState == 'QX'){
	                    		return '<span style="color: #c00;">已取消</span>'
	                    	}else if(row.orderState == 'DC'){
	                    		return '<span style="color: #c00;">待出库</span>'
	                    	}else if(row.orderState == 'YC'){
	                    		return '<span style="color: #c00;">已出库</span>'
	                    	}
	                    }
	               }, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		            '<a href="">查看</a>', 
	       		       		'&nbsp;<a data-id='+d.wholesaleOrdCode+' wholesaleOrd-event-type="out" >申请出库</a>',
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