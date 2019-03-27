<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>菜品添加</title>
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
            <li><a href="food-list.jsp"><i class="fa fa-circle-o"></i>菜谱列表</a></li>
            <li><a href="food-type-list.jsp"><i class="fa fa-circle-o"></i>菜谱类别</a></li>
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
      <h1>添加菜品</h1>
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
          <c:if test="${!empty info }">
	        	<div class="alert alert-success alert-dismissible" role="alert">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <strong>提示!</strong> 添加成功.
				</div>
				<script>
					setTimeout(function(){
						location.href = "/onrefectory/food/add.do";
					},3000);
				</script>
		   </c:if>
        </div>
        <div class="box-body">
			<form id="add_food_form" enctype="multipart/form-data" method="POST" action="/onrefectory/food/doAdd.do" class="form-horizontal col-md-offset-2 col-sm-8">
              <div class="box-body">
               <div class="form-group">
                  <label for="name" class="col-sm-2 control-label">菜品名称</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" name="name" id="name"  placeholder="菜品名称">
                  </div>
                </div>
				<div class="form-group">
                  <label for="price" class="col-sm-2 control-label">菜品价格</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" name="price" id="price" placeholder="菜品价格">
                  </div>
                </div>
				<div class="form-group">
                  <label for="vipPrice" class="col-sm-2 control-label">会员价格</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" name="vipPrice" id="vipPrice" placeholder="会员价格">
                  </div>
                </div>
			   <div class="form-group">
                  <label for="type" class="col-sm-2 control-label">菜品类别</label>

                  <div class="col-sm-6">
                    <select type="text" name="type" id="type"  class="form-control">
                      <option value="盖饭">盖饭</option>
                      <option value="凉菜">凉菜</option>
                    </select>
                  </div>
                </div>
			   <div class="form-group">
                  <label for="image" class="col-sm-2 control-label">图片</label>

                  <div class="col-sm-6">
                    <input type="file" name="image" id="image" placeholder="请选择图片">
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="createTime" class="col-sm-2 control-label">上传时间</label>

                  <div class="col-sm-6">
                    <input type="date" class="form-control" name="createTime" id="createTime" placeholder="上传时间">
                  </div>
                </div>
                <div class="form-group">
                  <label for="descc" class="col-sm-2 control-label">菜品简介</label>

                  <div class="col-sm-6">
                    <textarea id="descc" name="descc" class="form-control"></textarea>
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label"></label>

                  <div class="col-sm-6">
                    <button id="add_food_btn" type="button" class="btn pull-right btn-primary">添加</button>
                  </div>
                </div>
              </div>
            </form>
		</div>
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
