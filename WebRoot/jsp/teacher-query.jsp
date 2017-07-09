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
      <a href="teacherqueryscore.do" class="item">成绩查询</a>
      <a href="student.do?id=${sessionScope.loginUser.id}" class="item">你的学生</a>
      <a href="newscore.do?id=${sessionScope.loginUser.id}" class="item">新增成绩</a>
      <div class="ui simple dropdown item right">
         <i class="icon user"></i>${sessionScope.loginUser.tea_name}<i class="dropdown icon"></i>
        <div class="menu">
          <a class="item" href="goteacherinfo.do">个人信息</a>
          <a class="item" href="goteacherchange.do">修改密码</a>
          <a class="item" href="exit.do">退出</a>
        </div>
      </div>
    </div>
  </div>

  <div class="ui main text container">
    <h1 class="ui header">成绩查询</h1>
    <p>您所教的学生列表，点击可<strong>单独查询</strong>该学生成绩。</p>
    <p>您也可以选择<strong>按需查询</strong>：</p>
    <form class="ui form" action="teacherquery.do">
      <div class="two fields">
        <div class="field">
          <select class="ui dropdown" name="target">
          	<option value="account">按学号查询</option>
            <option value="name">按姓名查询</option>
            <option value="grade">按班级查询</option>
          </select>
        </div>
        <div class="field">
          <div class="field">
            <input type="text" name="message" placeholder="姓名或学号">
          </div>
        </div>
        <div class="field">
            <input type="submit" value="查询" class="ui fluid teal submit button" />
        </div>
      </div>
    </form>
    
    <table class="ui celled table">
      <c:if test="${type == 'student'}">
      	
      	<thead>
	        <tr>
	          <th>学生姓名</th>
	          <th>班级</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
		      <c:forEach items="${list}" var="data">
		        <tr>
		          <td>${data.stu_name}</td>
		          <td>${data.grade.gra_name}</td>
		          <td><a href="teacherquery.do?target=account&message=${data.account}">查看成绩</a></td>
		        </tr>
		      </c:forEach>
	      </tbody>
      </c:if>
      	<c:if test="${type == 'score'}">
      	  <strong>${stu_name}</strong>的成绩
      	  <thead>
	        <tr>
	          <th>科目</th>
	          <th>分数</th>
	        </tr>
	      </thead>
	      <tbody>
		      <c:forEach items="${list}" var="data">
		        <tr>
		          <td>${data.course.cou_name}</td>
		          <td>${data.score}</td>
		        </tr>
		      </c:forEach>
	      </tbody>
      </c:if>
    </table>
  </div>
</body>


</html>
