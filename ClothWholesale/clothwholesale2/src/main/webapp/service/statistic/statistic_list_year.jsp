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
			      <div class="layui-form-item">
			        <div class="layui-inline">
			          <label class="layui-form-label">年份</label>
			          <div class="layui-input-block">
			            <input type="text" name="year" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>
			        
			        <div class="layui-inline" >
			          <label class="layui-form-label">记录种类</label>
			          <div class="layui-input-block">
			          	<select name="type" lay-verify="required" lay-filter="peroid">
			          		<option value="-1"selected>请选择</option>
			          		<option value="C">采购</option>
							<option value="P">批发</option>
			          	</select>
			          </div>
			        </div>

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-statisticYear-search">
							<i class="layui-icon layui-icon-search "></i>
						</button>
					</div>
			      </div>
	      	</div>
	     </div>
	    
    	<div class="message"><span id="message"></span></div>
    	
	    <div class="layui-card-body">
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" statisticYear-event-type="updateAll">更新全部记录</button>
	      </div>
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" statisticYear-event-type="findMonth">查看月记录</button>
	      </div>
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" statisticYear-event-type="findDay">查看日记录</button>
	      </div>
	      
	      <table id="cws-statisticYear-table" lay-filter="cws-statisticYear-table">
	      	
	      	
	      </table>
	    
	    </div>


<script>
	layui.use(['jquery','table','layer','form'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-statisticYear-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	form.render();
	
	var events={ 
			updateAll:function(){
				$.ajax({
					type:"post",
					url:"../../statistic/update",
					data:{
					},
					success:function(data){
						alert("更新成功");
						funs.renderListTable();
					}
				});
			},
			findMonth:function(ele){
			  //do something
			  window.location.href="statistic_list_month.jsp";
  			},
			findDay:function(ele){
				  //do something
				  window.location.href="statistic_list_day.jsp";
	  			}
	}
	
	var funs={ 
		
		
		//操作中显示的内容
	 /*    opComplain:function(d){
	   		return [
	   			'<div>',
	            '<a href="">编辑</a>', 
	             '<a data-id='+d.statisticYearCode+' statisticYear-event-type="deletestatisticYear" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../statistic/listYear',//请求路径
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
	                {field: 'ordYearRecCode', title: '记录编号', sort: true },
	                {field: 'ordYearRecCode', title: '记录类型', sort: true 
	                	,templet: function(row){
	                    	if(row.ordYearRecCode.substring(0,1) == 'C'){
	                    		return '<span style="color: #c00;">采购</span>'
	                    	}else if(row.ordYearRecCode.substring(0,1) == 'P'){
	                    		return '<span style="color: #c00;">批发</span>'
	                    	}
	                    }	
	                },
	                {field: 'year', title: '年份', sort: true },
	                {field: 'orderNum', title: '订单数', sort: true },
	                {field: 'moneyNum', title: '金额', sort: true },
	               /* {templet: function(d){
	       	   		return [
	       		   			'<div>', 
	       		             '<a data-id='+d.ordYearRec+' statisticYear-event-type="listMonth" >查看月记录</a>', 
	       			     	'</div>'
	       		     	].join('');
	       		    }, title: '操作'} */
		        ] ]
		         
			})
			
			
			//监听搜索
		  	form.on('submit(cws-statisticYear-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-statisticYear-table',{
		    		where:field
		    	});
		    	 
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[statisticYear-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("statisticYear-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
</body>
</html>