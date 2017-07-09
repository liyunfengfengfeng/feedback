<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <meta content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>Login - Feedback</title>
  <link rel="stylesheet" type="text/css" href="dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="dist/components/menu.css">

  <link rel="stylesheet" type="text/css" href="dist/components/divider.css">
  <link rel="stylesheet" type="text/css" href="dist/components/segment.css">
  <link rel="stylesheet" type="text/css" href="dist/components/form.css">
  <link rel="stylesheet" type="text/css" href="dist/components/input.css">
  <link rel="stylesheet" type="text/css" href="dist/components/button.css">
  <link rel="stylesheet" type="text/css" href="dist/components/list.css">
  <link rel="stylesheet" type="text/css" href="dist/components/message.css">
  <link rel="stylesheet" type="text/css" href="dist/components/icon.css">


  <style type="text/css">
    body {
      background-color: #DADADA;
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
  </style>

</head>
<body>

<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <img src="assets/images/logo60.jpg" class="image">
      
        教学反馈系统
      
    </h2>
    <form class="ui large form" action="login.do" method="post">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="account" placeholder="Username">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="password" placeholder="Password">
          </div>
        </div>
         <div class="fields">
          <div class="field">
            <div class="ui radio checkbox">
              <input type="radio" value="student" name="target" checked="checked">
              <label>学生</label>
            </div>
          </div>
          <div class="field">
            <div class="ui radio checkbox">
              <input type="radio" value="teacher" name="target">
              <label>教师</label>
            </div>
          </div>
          <div class="field">
            <div class="ui radio checkbox">
              <input type="radio" value="admin" name="target">
              <label>管理员</label>
            </div>
          </div>
        </div>
        <input type="submit" value="Login" class="ui fluid large teal button">
      </div>
	  
      <div class="ui error message"></div>

    </form>
	<div class="ui message">${error}</div>
    <div class="ui message">
      想注册？那就去找管理员吧！
    </div>
  </div>
</div>

  <script src="assets/library/jquery.min.js"></script>
  <script src="dist/components/form.js"></script>
  <script src="dist/components/transition.js"></script>
  <script>
  $(document)
    .ready(function() {
      $('.ui.form')
        .form({
          fields: {
            username: {
            identifier: 'username',
            rules: [
              {
                type   : 'empty',
                prompt : '请输入你的用户名'
              }
            ]
          },
            password: {
              identifier  : 'password',
              rules: [
                {
                  type   : 'empty',
                  prompt : '请输入你的密码'
                },
                {
                  type   : 'length[6]',
                  prompt : '你的密码最少是6位哦'
                }
              ]
            }
          }
        })
      ;
    })
  ;
  </script>
</body>

</html>
