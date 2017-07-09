<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <title>Student - Feedback</title>

  <link rel="stylesheet" type="text/css" href="dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="dist/components/menu.css">
  <link rel="stylesheet" type="text/css" href="dist/components/table.css">
  <link rel="stylesheet" type="text/css" href="dist/components/card.css">
  
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
    <div class="ui centered grid cards">
      <div class="card">
        <div class="image">
          <img src="assets/images/avatar/tom.jpg">
        </div>
        <div class="content">
          <div class="header">${sessionScope.loginUser.name}</div>
          <div class="meta">
          <a class="group">管理员</a>
          </div>
          <div class="description">
            您拥有本系统最高权限
          </div>
        </div>
        <div class="extra content">
          <a class="right floated created">
            2017
          </a>
        </div>
      </div>
    </div>
    <div class="ui text centered grid admin">
      <p>欢迎管理员的使用，您拥有本系统<strong>最高权限</strong>，可以进行添加用户，添加班级，添加课程和对相关信息查询等功能，祝您使用愉快！</p>
    </div>
  </div>
	
</body>


</html>
