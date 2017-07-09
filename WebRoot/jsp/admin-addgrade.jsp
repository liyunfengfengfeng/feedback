<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>Teacher - Feedback</title>

  <link rel="stylesheet" type="text/css" href="dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="dist/components/menu.css">
  <link rel="stylesheet" type="text/css" href="dist/components/table.css">
  <link rel="stylesheet" type="text/css" href="dist/components/form.css">
  <link rel="stylesheet" type="text/css" href="dist/components/input.css">
  <link rel="stylesheet" type="text/css" href="dist/components/button.css">
  <link rel="stylesheet" type="text/css" href="dist/components/checkbox.css">

  <link rel="stylesheet" type="text/css" href="dist/components/divider.css">
  <link rel="stylesheet" type="text/css" href="dist/components/list.css">
  <link rel="stylesheet" type="text/css" href="dist/components/segment.css">
  <link rel="stylesheet" type="text/css" href="dist/components/dropdown.css">
  <link rel="stylesheet" type="text/css" href="dist/components/icon.css">

  <style type="text/css">
    body {
      background-color: #FFFFFF;
    }

    .ui.menu .item img.logo {
      margin-right: 1.5em;
    }

    .main.container {
      margin-top: 7em;
    }
  </style>

</head>
<body>

  <div class="ui fixed inverted menu">

    <div class="ui container">
      <a href="#" class="header item">
        <img class="logo" src="assets/images/logo35.jpg">
        Feedback SYS
      </a>
       <div class="ui simple dropdown item">
        添加用户 <i class="dropdown icon"></i>
        <div class="menu">
          <a class="item" href="addstudent.do">添加学生</a>
          <a class="item" href="addteacher.do">添加教师</a>
        </div>
      </div>
      <a href="addgrade.do" class="item">添加班级</a>
      <a href="addcourse.do" class="item">添加课程</a>
	  <div class="ui simple dropdown item">
        用户列表 <i class="dropdown icon"></i>
        <div class="menu">
          <a class="item" href="allstudent.do">所有学生</a>
          <a class="item" href="allteacher.do">所有教师</a>
          <a class="item" href="allcourse.do">所有课程</a>
          <a class="item" href="allgrade.do">所有班级</a>
          <a class="item" href="adminquery.do">按条件查询</a>
        </div>
      </div>
      <div class="ui simple dropdown item right">
        <i class="user icon"></i>${sessionScope.loginUser.name}<i class="dropdown icon"></i>
        <div class="menu">
          <a class="item" href="exit.do">退出</a>
        </div>
      </div>
    </div>
  </div>

  <div class="ui main text container">
    <h1 class="ui header">添加班级</h1>
    <div class="ui message">${success}${error}</div>
    <form class="ui large form" action="newgrade.do" method="post">
      <div class="ui warning form segment">
        <div class="field">
          <label>班级名称</label>
          <input placeholder="格式:年级-班级" name="gra_name" type="text">
        </div>
        <div class="field">
          <label>该班教师</label>
          	<c:forEach items="${data}" var="d">
          		<div class="ui checkbox">
         		 <input name="id" type="checkbox" value="${d.id}">
         		 <label>${d.tea_name}</label>
         		</div>
          	</c:forEach>
        </div>
        <div class="ui primary submit button">确认添加</div>
        <div class="ui error message"></div>
      </div>
    </form>
  </div>

<script src="assets/library/jquery.min.js"></script>
<script src="dist/components/form.js"></script>
<script src="dist/components/transition.js"></script>
<script>
  $('.ui.form')
    .form({
      fields: {
        gra_name: {
          identifier: 'gra_name',
          rules: [
            {
              type   : 'empty',
              prompt : '班级号不能为空'
            }
          ]
        },
      }
    });
</script>
</body>



</html>
