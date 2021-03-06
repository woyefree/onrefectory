<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>餐厅列表</title>
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
            <li><a href="../菜品管理/food-list.html"><i class="fa fa-circle-o"></i>菜谱列表</a></li>
            <li><a href="../菜品管理/food-type-list.html"><i class="fa fa-circle-o"></i>菜谱类别</a></li>
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
            <li><a href="blank.html"><i class="fa fa-circle-o"></i>用户管理 v1</a></li>
            <li><a href="blank2.html"><i class="fa fa-circle-o"></i> 用户管理 v2</a></li>
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
            <li><a href="../评论管理/blank.html"><i class="fa fa-circle-o"></i>评论管理 v1</a></li>
            <li><a href="../评论管理/blank2.html"><i class="fa fa-circle-o"></i>评论管理 v2</a></li>
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
      <h1>餐厅 </h1>
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
          <form action="/onrefectory/refectory/doList.do">
	          <div class="input-group input-group-sm pull-left" style="width: 300px">
	            <input type="text" value="${keyword}" name="keyword" class="form-control">
	            <span class="input-group-btn">
	              	<button type="submit" class="btn btn-info btn-flat">搜索</button>
	            </span>
	          </div>
	          <a href="/onrefectory/refectory/add.do" class="btn btn-info btn-flat pull-right">添加餐厅</a>
          </form>
        </div>
        <div class="box-body">
        	<table class="table table-hover">
                <tbody><tr>
                  <th style="width: 100px">序号</th>
                  <th>管理员</th>
                  <th>餐厅名称</th>
                  <th>联系电话</th>
                  <th>添加时间</th>
                  <th>操作</th>
                </tr>
                <c:forEach items="${refectorys.data }" var="refectory">
	                <tr>
	                  <td>${refectory.id}</td>	
	                  <td>${refectory.admin.name}</td>
	                  <td>${refectory.desc}</td>
	                  <td>${refectory.tel}</td>
	                  <td>${refectory.createTime}</td>
	                  <td>
						<a href="/onrefectory/refectory/doEdit.do?id=${refectory.id }">编辑</a>
						<a class="delete_refectory_btn" href="#" refectory-id="${refectory.id }">删除</a>
					  </td>
	                </tr>
     	           </c:forEach>
              </tbody>
            </table>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
            <ul class="pagination pagination-sm no-margin pull-right">
              
              <c:if test="${refectorys.curPage >= 1}">
              	<c:if test="${refectorys.curPage == 1}">
              		<li><a href="#">«</a></li>
              	</c:if>
                <c:if test="${refectorys.curPage > 1}">
                	<li><a href="/onrefectory/refectory/doList.do?page=${refectorys.curPage-1}&keyword=${keyword}">«</a></li>
                </c:if>
              </c:if>
              
              <c:forEach begin="1" var="pageNum" end="${refectorys.totalPage }" step="1">
              		<li><a href="/onrefectory/refectory/doList.do?page=${pageNum}&keyword=${keyword}"> ${pageNum }</a></li>
              </c:forEach>
              
              <c:if test="${refectorys.curPage <= refectorys.totalPage}">
              	<c:if test="${refectorys.curPage == refectorys.totalPage}">
              		<li><a href="#">»</a></li>
              	</c:if>
                <c:if test="${refectorys.curPage < refectorys.totalPage}">
                	<li><a href="/onrefectory/refectory/doList.do?page=${refectorys.curPage+1}&keyword=${keyword}">»</a></li>
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
<script src="/onrefectory/static/dist/js/refectory.js" type="text/javascript"></script>
<script>
  $(document).ready(function () {
    $('.sidebar-menu').tree()
  })
</script>
</body>
</html>
