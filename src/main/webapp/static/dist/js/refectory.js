$(function(){
	$("#add_refectory_btn").click(function(event){
		//验证表单
		event.preventDefault();
		var telFormat = /^9[0-9]{8}$/;
		//取出表单中的值
		var tel = $("#add_refectory_form input[name='tel']").val().trim();
		var name = $("#add_refectory_form input[name='desc']").val().trim();
		
        
		/*$("#admins").change(function(){
		    var admin = $('#admins option:selected').val().trim();
		    
		});*/
		
		//验证手机号
		if(!telFormat.test(tel)){
			return alert("手机号格式不合法");	
		}
		//验证手机号是否已经存在
		var telExist = false;
		$.ajax({
			url:"/onrefectory/refectory/validTel.do",
			data:{'tel':tel},
			type:"POST",
			async:false,//同步请求
			success:function(data){
				var rs = JSON.parse(data);   //JSON.parse();将接受到的数据转换成js对象
				if(rs.data.exist){
					telExist = true;
				}
			},
			error:function(data){
				return alert("请求失败。");
			}
		});
		if(telExist){
			return alert("电话号码已存在。。");
		}
		
		//验证name
		if(!name){
			return alert("姓名不能为空");
		}
	
		//提交表单
		$("#add_refectory_form").submit();
	});
	//修改餐厅信息
	$("#update_refectory_btn").click(function(){
		
		//取出表单中的值
		var tel = $("#update_refectory_form input[name='tel']").val().trim();
		var desc = $("#update_refectory_form input[name='desc']").val().trim();
		
		//验证desc
		if(!desc){
			return alert("餐厅名不能为空");
		}
		//验证tel
		if(!tel){
			return alert("电话号不能为空");
		}

		var url = $("#update_refectory_form").attr("action");
		var postData = $("#update_refectory_form").serialize();
		//向后台发送post请求，提交数据
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200) {
				alert("修改成功");
				location.href="/onrefectory/refectory/doList.do";
			}else{
				alert("修改失败");
			}
		})
	});
	//删除餐厅
	$(".delete_refectory_btn").click(function(event){
		event.preventDefault();
		var areYouSure = confirm("确定要删除该条信息吗？");  
		if(!areYouSure){
			return ;
		}
		//删除操作
		var id = $(this).attr("refectory-id");
		var url = "/onrefectory/refectory/delete.do";
		$.get(url,{"id":id},function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200) {
				alert("删除成功");
				location.reload();
			}else{
				alert("删除失败");
			}
		});
	});
});
