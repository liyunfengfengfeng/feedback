<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  <link rel="stylesheet" type="text/css" href="dist/components/form.css">
  <link rel="stylesheet" type="text/css" href="dist/components/button.css">

  <link rel="stylesheet" type="text/css" href="dist/components/message.css">
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
    <h1 class="ui header">增加成绩</h1>
    <form class="ui large form" action="score.do" method="post">
      <div class="ui warning form segment">
        <div class="field">
          <label>学生姓名</label>
          <input type="text" value="${data.stu_name}">
          <input type="hidden" name="student" value="${data.id}">
        </div>
        <div class="field">
          <label>所在班级</label>
          <input type="text" value="${data.grade.gra_name}">
        </div>
        <div class="field">
          <label>成绩</label>
          <input name="score" type="text">
        </div>
        <div class="ui  submit ">
        	<input type="submit" value="确认添加" class="ui primary submit button">
        </div>
        <div class="ui error message"></div>
      </div>
    </form>
  </div>

<script src="assets/library/jquery.min.js"></script>
<script src="../dist/components/form.js"></script>
<script src="../dist/components/transition.js"></script>
<script>
  $('.ui.form')
    .form({
      fields: {
        oldPassword: {
          identifier: 'oldPassword',
          rules: [
            {
              type   : 'empty',
              prompt : '请输入当前密码'
            },
            {
              type   : 'minLength[6]',
              prompt : '你的当前密码至少是6位'
            }
          ]
        },
        newPassword: {
          identifier: 'newPassword',
          rules: [
            {
              type   : 'empty',
              prompt : '请输入新密码'
            },
            {
              type   : 'minLength[6]',
              prompt : '你的新密码至少是6位'
            }
          ]
        },
        rePassword: {
          identifier: 'rePassword',
          rules: [
            {
              type   : 'empty',
              prompt : '请输入确认密码'
            },
            {
              type   : 'minLength[6]',
              prompt : '你的确认密码至少是6位'
            }
          ]
          },
      }
    });
</script>
</body>
</html>
