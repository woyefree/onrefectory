<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>餐厅编辑界面</title>
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
            <li><a href="../订单管理/blank.html"><i class="fa fa-circle-o"></i> 订单管理 v2</a></li>
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
      <h1>
       	餐厅信息修改
      </h1>
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
        
        </div>
        <div class="box-body">
        	<form id="update_refectory_form" method="POST" action="/onrefectory/refectory/update.do" class="form-horizontal col-md-offset-2 col-sm-8">
              <div class="box-body">
                <div class="form-group">
                  <input type="hidden" name="id" value="${refectory.id }"  />
                  <label for="desc" class="col-sm-2 control-label">餐厅名称</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${refectory.desc }" name="desc" id="desc" placeholder="餐厅名称">
                  </div>
                </div>
                <div class="form-group">
                  <label for="type" class="col-sm-2 control-label">管理员</label>
				  <!-- 实现下选框功能 -->
                  <div class="col-sm-6">
                    <select name="admin_id"  class="form-control">
               		  <c:forEach items="${admins }" var="admin">
               		   	<option <c:if test="${admin.id == refectory.admin.id}">selected</c:if> value="${admin.id }">${admin.name }</option>
               		  </c:forEach>
                    </select>
                  </div>
                </div>
                <%-- <div class="form-group">
                  <label for="admin_id" class="col-sm-2 control-label">管理员</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" readonly value="${refectory.admin.id }" name="admin_id" id="admin_id" placeholder="管理员">
                  </div>
                </div> --%>
                <div class="form-group">
                  <label for="tel" class="col-sm-2 control-label">手机号</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" value="${refectory.tel }" name="tel" id="tel" placeholder="手机号码">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label"></label>

                  <div class="col-sm-6">
                    <button id="update_refectory_btn" type="button" class="btn pull-right btn-primary">确定</button>
                  </div>
                </div>
              </div>
            </form>
        </div>
        <!-- /.box-body -->
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
