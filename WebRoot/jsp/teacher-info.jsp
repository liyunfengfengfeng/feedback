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
    <h1 class="ui header">个人信息</h1>
    <p>下表就是你的个人信息</p>

    <table class="ui celled striped table">
    <thead>
      <tr>
        <th colspan="2">
          Personal information
        </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="collapsing">
          <i class="user icon"></i>姓名
        </td>
        <td>${teacher.tea_name}</td>
      </tr>
      <tr>
        <td>
          <i class="info icon"></i>账号
        </td>
        <td>${teacher.account}</td>
      </tr>
   <!--    <tr>
        <td>
          <i class="student icon"></i>年龄
        </td>
        <td>23</td>
      </tr> -->
      <tr>
        <td>
          <i class="outline icon gender"></i>性别
        </td>
        <td class="gender-name">${teacher.gender}</td>
      </tr>
      <tr>
        <td class="collapsing">
          <i class="child outline icon"></i>出生日期
        </td>
        <td>${teacher.birthday}</td>
      </tr>
      <tr>
        <td>
          <i class="users outline icon"></i>民族
        </td>
        <td>${teacher.nation}</td>
      </tr>
    </tbody>
  </table>
  </div>

<script src="assets/library/jquery.min.js"></script>
<script>
  $(document).ready(function () {
    var $genderIcon = $('.icon.gender');
    var $gender = $('.gender-name');
    if ($gender.html() == '男') {
      $genderIcon.addClass('male');
    } else {
      $genderIcon.addClass('female');
    }
  });
</script>
</body>
</html>
