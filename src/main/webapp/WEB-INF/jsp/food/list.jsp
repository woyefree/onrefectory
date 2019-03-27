<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>菜谱列表</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="/onrefectory/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/onrefectory/static/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/onrefectory/static/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/onrefectory/static/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/onrefectory/static/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

  <%@ include file="../fragment/header.jspf" %>

  <!-- =============================================== -->

  <!-- Left side column. contains the sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <ul class="sidebar-menu" data-widget="tree">
	    <li>
          <a href="../blank.html">
            <i class="fa fa-th"></i> <span>首页</span>
          </a>
        </li>
		<li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>菜品管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i> 菜谱列表</a></li>
            <li><a href="food-type-list.jsp"><i class="fa fa-circle-o"></i> 菜谱类别</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>订单管理</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right">4</span>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../订单管理/blank.html"><i class="fa fa-circle-o"></i> 订单管理 v1</a></li>
            <li><a href="../订单管理/blank2.html"><i class="fa fa-circle-o"></i> 订单管理 v2</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>用户管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../用户管理/blank.html"><i class="fa fa-circle-o"></i> 用户管理 v1</a></li>
            <li><a href="../用户管理/blank2.html"><i class="fa fa-circle-o"></i> 用户管理 v2</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>评论管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../评论管理/blank.html"><i class="fa fa-circle-o"></i> 评论管理 v1</a></li>
            <li><a href="../评论管理/blank2.html"><i class="fa fa-circle-o"></i> 评论管理 v2</a></li>
          </ul>
        </li> 
      </ul>
    </section>
    <!-- /.sidebar -->	
  </aside>

  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>菜品列表</h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">Blank page</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <div class="input-group input-group-sm pull-left" style="width: 300px">
            <input type="text" class="form-control">
            <span class="input-group-btn">
              <button type="button" class="btn btn-info btn-flat">搜索</button>
            </span>
          </div>
          <a href="/onrefectory/food/add.do" class="btn btn-info btn-flat pull-right">添加菜品</a>
        </div>
        <div class="box-body">
			<table class="table table-hover">
                <tbody><tr>
                  <th style="width: 50px">序号</th>
                  <th>餐厅名称</th>  
                  <th>菜品名称</th>
                  <th>菜品类别</th>				  				  
                  <th>菜品状态</th>
                  <th>菜品图片</th>
                  <th>菜品价格</th>
                  <th>会员价格</th>
                  <th>菜品描述</th>
                  <th>上传时间</th>
                  <th>操作</th>
                </tr>
                <c:forEach items="${admins.data }" var="admin">
	                <tr>
	                  <td>${admin.id}</td>
	                  <td>${admin.name}</td>
	                  <td>${admin.gender == 1 ? '男'  : '女'}</td>
	                  <td>${admin.tel}</td>
	                  <td>${admin.pwd}</td>
	                  <td>${admin.tel}</td>
	                  <td>${admin.pwd}</td>
	                  <td>${admin.email}</td>
	                  <td>${admin.role == 1 ? '超级管理员'  : '普通管理员'}</td>
	                  <td>${admin.createTime}</td>
	                  <td>
						<a href="/onrefectory/admin/doEdit.do?id=${admin.id }">编辑</a>
						<a class="delete_admin_btn" href="#" admin-id="${admin.id }">删除</a>
					  </td>
	                </tr>
     	        </c:forEach>
              </tbody>
            </table>
		</div>
        <!-- /.box-body -->
        <div class="box-footer">
            <ul class="pagination pagination-sm no-margin pull-right">
              
              <c:if test="${admins.curPage >= 1}">
              	<c:if test="${admins.curPage == 1}">
              		<li><a href="#">«</a></li>
              	</c:if>
                <c:if test="${admins.curPage > 1}">
                	<li><a href="/onrefectory/admin/doList.do?page=${admins.curPage-1}&keyword=${keyword}">«</a></li>
                </c:if>
              </c:if>
              
              <c:forEach begin="1" var="pageNum" end="${admins.totalPage }" step="1">
              		<li><a href="/onrefectory/admin/doList.do?page=${pageNum}&keyword=${keyword}"> ${pageNum }</a></li>
              </c:forEach>
              
              <c:if test="${admins.curPage <= admins.totalPage}">
              	<c:if test="${admins.curPage == admins.totalPage}">
              		<li><a href="#">»</a></li>
              	</c:if>
                <c:if test="${admins.curPage < admins.totalPage}">
                	<li><a href="/onrefectory/admin/doList.do?page=${admins.curPage+1}&keyword=${keyword}">»</a></li>
                </c:if>
              </c:if>
            </ul>
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <!-- Control Sidebar -->
  
  <!-- /.control-sidebar -->
 
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="/onrefectory/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/onrefectory/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="/onrefectory/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/onrefectory/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/onrefectory/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/onrefectory/static/dist/js/demo.js"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
