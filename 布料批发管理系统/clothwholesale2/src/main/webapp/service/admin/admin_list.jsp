<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="../other/layui/layui.js"></script>
<link rel="stylesheet" href="../other/layui/css/layui.css" />

</head>
<body>
  	<div class="layui-card">
	    <div class="layui-form layui-card-header layuiadmin-card-header-auto" >
	      	<div class="layui-inline">
			        <div class="layui-inline">
			          <label class="layui-form-label">编号</label>
			          <div class="layui-input-block">
			            <input type="text" name="adminCode" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			         </div>
			        
			        <div class="layui-inline">
			          <label class="layui-form-label">名字</label>
			          <div class="layui-input-block">
			            <input type="text" name="adminName" placeholder="请输入" autocomplete="off" class="layui-input">
			          </div>
			        </div>

			        <div class="layui-inline">
						<button class="layui-btn layui-btn-normal" lay-submit lay-filter="cws-user-search">
							<i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
						</button>
					</div>
			      </div>
	      	</div>
	    </div>
    
	    <div class="layui-card-body">
	    	
	      <div style="padding-bottom: 10px;">
	        <button class="layui-btn" admin-event-type="addUser">添加</button>
	      </div>
	      
	      <table id="cws-user-table" lay-filter="cws-user-table">
	      	
	      	
	      </table>
	    
	    </div>

<script>
	layui.use(['jquery','table','layer'],function(e){
	var $ = layui.$;
	var table = layui.table;
	var listTableId = "#cws-user-table"; 
	var form = layui.form; 
	var layer = layui.layer; 
	
	var events={ 
			addUser:function(){
				alert("ss")
			},
		deleteAdmin:function(ele){
  			var userId = ele.attr("data-id");
  			layer.confirm('确认删除该用户?', {icon: 3, title:'提示'}, function(index){
			  //do something
			  	$.ajax({
					type:"post",
					url:"user/delete",
					data:{
						"id":userId
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
	             '<a data-id='+d.adminCode+' admin-event-type="deleteAdmin" >删除</a>', 
		     	'</div>'
	     	].join('');
	    }, */ 
		
		renderListTable:function(){
			//渲染table
			table.render({
				elem : listTableId,
				height:'auto', //高度 
				url:'../../admin/list',//请求路径
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
	                {field: 'adminCode', title: '编号', sort: true } ,
	                {field: 'adminName', title: '名字', sort: true },
	                {field: 'mobile', title: '电话', sort: true },
	                {field: 'adminType', title: '管理员类型', sort: true
	                    ,templet: function(row){
	                    	if(row.adminType == 'CG'){
	                    		return '<span style="color: #c00;">采购</span>'
	                    	}else if(row.adminType == 'PF'){
	                    		return '<span style="color: #c00;">批发</span>'
	                    	}else if(row.adminType == 'GJ'){
	                    		return '<span style="color: #c00;">高级</span>'
	                    	}else if(row.adminType == 'XT'){
	                    		return '<span style="color: #c00;">系统</span>'
	                    	}else if(row.adminType == 'CK'){
	                    		return '<span style="color: #c00;">仓库</span>'
	                    	}
	                    }
	               }, 
	               {templet: function(d){
	       	   		return [
	       		   			'<div>',
	       		            '<a href="">编辑</a>', 
	       		             '<a data-id='+d.adminCode+' admin-event-type="deleteAdmin" >删除</a>', 
	       			     	'</div>'
	       		     	].join('');
	       		    }, title: '操作'}
		        ] ]
		         
			})
			
			
			//监听搜索
		  	form.on('submit(cws-user-search)', function(data){
		    	var field = data.field;
		    	//执行重载
		    	table.reload('cws-user-table',{
		    		where:field
		    	});
		    	 
		  	});
		},
		 
		
	}
	
	funs.renderListTable()
	$("body").on("click","*[admin-event-type]",function(){
 		var ele = $(this);
		var eventName = ele.attr("admin-event-type");
		events[eventName]&&events[eventName].call(this,ele)
 	}) 
})
	
	
</script>
  	
</body>
</html>