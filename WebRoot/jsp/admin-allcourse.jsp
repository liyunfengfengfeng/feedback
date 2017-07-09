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
    <h1 class="ui header">所有课程</h1>
    <p>下表就是所有课程</p>

    <table class="ui celled table">
      <thead>
        <tr>
          <th>课程名</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${list.datas}" var="data">
        <tr>
          <td>${data.cou_name}</td>
          <td>
	          <a href="deletecourse.do?id=${data.id}">删除</a>
          </td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    <div class="ui pagination menu">
	  <a class="icon item" href="allcourse.do?currpage=0">
	    	首页
	  </a>
	  <c:forEach var="x" begin="1" end="${list.total/list.size + 1}" step="1">
	  	<a class="active item" href="allcourse.do?currpage=${x-1}">
	      ${x}
	    </a>
	  </c:forEach>
	  <fmt:formatNumber var="c" value="${list.total/list.size}" pattern="#"/>
	  <a class="icon item" href="allcourse.do?currpage=${c}">
	    	尾页
	  </a>
	</div>
  </div>
	
</body>


</html>
