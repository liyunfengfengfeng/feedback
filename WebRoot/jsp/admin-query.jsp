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
    <h1 class="ui header">查询用户</h1>
    <p><strong>按需查询</strong>：</p>
    <form class="ui form" action="query.do">
      <div class="two fields">
      	<div class="field">
          <select class="ui dropdown" name="type">
          	<option value="student">查询学生</option>
            <option value="teacher">查询教师</option>
          </select>
        </div>
        <div class="field">
          <select class="ui dropdown" name="target">
          	<option value="account">按账号查询</option>
            <option value="name">按姓名查询</option>
            <option value="couorgra">按班级或课程号查询</option>
          </select>
        </div>
        <div class="field">
          <div class="field">
            <input type="text" name="message" placeholder="姓名或学号或课程班级号">
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
	          <th>所在班级</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
		      <c:forEach items="${list.datas}" var="data">
		        <tr>
		          <td>${data.stu_name}</td>
		          <td>${data.grade.gra_name}</td>
		          <td>
			          <a href="deletestudent.do?id=${data.id}">删除</a>
			          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			          <a href="updatestudent.do?id=${data.id}">更新</a>
		          </td>
		        </tr>
		      </c:forEach>
	      </tbody>
      </c:if>
      	<c:if test="${type == 'teacher'}">
      	  <thead>
	        <tr>
	          <th>教师姓名</th>
	          <th>所教课程</th>
	          <th>操作</th>
	        </tr>
	      </thead>
	      <tbody>
		     <c:forEach items="${list.datas}" var="data">
		        <tr>
		          <td>${data.tea_name}</td>
		          <td>${data.course.cou_name}</td>
		          <td>
			          <a href="deleteteacher.do?id=${data.id}">删除</a>
			          	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			          <a href="updateteacher.do?id=${data.id}">更新</a>
		          </td>
		        </tr>
		     </c:forEach>
	      </tbody>
      </c:if>
    </table>
    <c:if test="${list.total/list.size <= 1}">
    <div class="ui pagination menu">
	  <a class="icon item" href="query.do?currpage=0&type=${type}&target=${target}&message=${message}">
	    	首页
	  </a>
	  <c:forEach var="x" begin="1" end="${list.total/list.size + 1}" step="1">
	  	<a class="active item" href="query.do?currpage=${x-1}&type=${type}&target=${target}&message=${message}">
	      ${x}
	    </a>
	  </c:forEach>
	  <fmt:formatNumber var="c" value="${list.total/list.size}" pattern="#"/>
	  <a class="icon item" href="query.do?currpage=${c}&type=${type}&target=${target}&message=${message}">
	    	尾页
	  </a>
	</div>
	</c:if>
  </div>
</body>


</html>
