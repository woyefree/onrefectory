$(function(){
	$("#add_admin_btn").click(function(event){
		//验证表单
		event.preventDefault();
		var telFormat = /^1[0-9]{10}$/;
		var emailFormat = /[_0-9a-zA-Z]{1,}@[_0-9a-zA-Z]{1,}\.((com)|(cn))/;
		//取出表单中的值
		var tel = $("#add_admin_form input[name='tel']").val().trim();
		var pwd = $("#add_admin_form input[name='pwd']").val().trim();
		var repwd = $("#add_admin_form input[name='repwd']").val().trim();
		var email = $("#add_admin_form input[name='email']").val().trim();
		var name = $("#add_admin_form input[name='name']").val().trim();
		
		//验证手机号
		if(!telFormat.test(tel)){
			return alert("手机号格式不合法");	
		}
		//验证手机号是否已经存在
		var telExist = false;
		$.ajax({
			url:"/onrefectory/admin/validTel.json",
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
		//验证密码
		if(!pwd){
			return alert("密码不能为空");
		}
		
		//验证repwd
		if(pwd != repwd){
			return alert("两次密码不相同");
		}
		
		//验证name
		if(!name){
			return alert("姓名不能为空");
		}
		

		//验证邮箱
		if(!emailFormat.test(email)){
			return alert("邮箱格式不合法");
		}
		
		//提交表单
		$("#add_admin_form").submit();
	});
	//修改admin信息
	$("#update_admin_btn").click(function(){
		
		//取出表单中的值
		var gender = $("#update_admin_form input[name='gender']").val().trim();
		var name = $("#update_admin_form input[name='name']").val().trim();
		
		//验证name
		if(!name){
			return alert("姓名不能为空");
		}
		var url = $("#update_admin_form").attr("action");
		var postData = $("#update_admin_form").serialize();
		//向后台发送post请求，提交数据
		$.post(url,postData,function(data){
			var rs = JSON.parse(data);
			if(rs.code == 200) {
				alert("修改成功");
				location.href="/onrefectory/admin/list.do";
			}else{
				alert("修改失败");
			}
		})
	});
	//删除admin
	$(".delete_admin_btn").click(function(event){
		event.preventDefault();
		var areYouSure = confirm("确定要删除该条信息吗？");  
		if(!areYouSure){
			return ;
		}
		//删除操作
		var id = $(this).attr("admin-id");
		var url = "/onrefectory/admin/delete.do";
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
