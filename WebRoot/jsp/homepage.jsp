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
  <title>Homepage - Semantic</title>
  <link rel="stylesheet" type="text/css" href="dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="dist/components/menu.css">

  <link rel="stylesheet" type="text/css" href="dist/components/divider.css">
  <link rel="stylesheet" type="text/css" href="dist/components/dropdown.css">
  <link rel="stylesheet" type="text/css" href="dist/components/segment.css">
  <link rel="stylesheet" type="text/css" href="dist/components/button.css">
  <link rel="stylesheet" type="text/css" href="dist/components/list.css">
  <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
  <link rel="stylesheet" type="text/css" href="dist/components/sidebar.css">
  <link rel="stylesheet" type="text/css" href="dist/components/transition.css">

  <style type="text/css">

    .hidden.menu {
      display: none;
    }

    .masthead.segment {
      min-height: 700px;
      padding: 1em 0em;
    }
    .masthead .logo.item img {
      margin-right: 1em;
    }
    .masthead .ui.menu .ui.button {
      margin-left: 0.5em;
    }
    .masthead h1.ui.header {
      margin-top: 3em;
      margin-bottom: 0em;
      font-size: 4em;
      font-weight: normal;
    }
    .masthead h2 {
      font-size: 1.7em;
      font-weight: normal;
    }

    .ui.vertical.stripe {
      padding: 8em 0em;
    }
    .ui.vertical.stripe h3 {
      font-size: 2em;
    }
    .ui.vertical.stripe .button + h3,
    .ui.vertical.stripe p + h3 {
      margin-top: 3em;
    }
    .ui.vertical.stripe .floated.image {
      clear: both;
    }
    .ui.vertical.stripe p {
      font-size: 1.33em;
    }
    .ui.vertical.stripe .horizontal.divider {
      margin: 3em 0em;
    }
    .ui.centered.mini.image {
      margin-bottom: 2em;
    }
    .quote.stripe.segment {
      padding: 0em;
    }
    .quote.stripe.segment .grid .column {
      padding-top: 5em;
      padding-bottom: 5em;
    }

    .footer.segment {
      padding: 5em 0em;
    }

    .secondary.pointing.menu .toc.item {
      display: none;
    }

    @media only screen and (max-width: 700px) {
      .ui.fixed.menu {
        display: none !important;
      }
      .secondary.pointing.menu .item,
      .secondary.pointing.menu .menu {
        display: none;
      }
      .secondary.pointing.menu .toc.item {
        display: block;
      }
      .masthead.segment {
        min-height: 350px;
      }
      .masthead h1.ui.header {
        font-size: 2em;
        margin-top: 1.5em;
      }
      .masthead h2 {
        margin-top: 0.5em;
        font-size: 1.5em;
      }
    }


  </style>
</head>
<body>

<!-- Following Menu -->
<div class="ui large top fixed hidden menu">
  <div class="ui container">
    <a class="active item" href="/feedback/homepage.do">Home</a>
    <div class="right menu">
      <div class="item">
        <a class="ui primary button" href="gologin.do">登陆</a>
      </div>
    </div>
  </div>
</div>

<!-- Sidebar Menu -->
<div class="ui vertical inverted sidebar menu">
  <a class="active item" href="/feedback/homepage.do">Home</a>
  <a class="item" href="gologin.do">登陆</a>
</div>


<!-- Page Contents -->
<div class="pusher">
  <div class="ui inverted vertical masthead center aligned segment">

    <div class="ui container">
      <div class="ui large secondary inverted pointing menu">
        <a class="toc item">
          <i class="sidebar icon"></i>
        </a>
        <a class="active item" href="/feedback/homepage.do">Home</a>
        <div class="right item">
          <a class="ui inverted button" href="gologin.do">登陆</a>
        </div>
      </div>
    </div>

    <div class="ui text container">
      <h1 class="ui inverted header">
        Feedback System
      </h1>
      <h2>你可以在这里查询成绩和生成分析图表</h2>
    </div>

  </div>

  <div class="ui vertical stripe segment">
    <div class="ui middle aligned stackable grid container">
      <div class="row">
        <div class="eight wide column">
          <h3 class="ui header">如果你是学生</h3>
          <p>我们能帮你查询自己的考试成绩，并根据成绩生成分析图表。</p>
          <p>不要因为一次考试的失利就放弃，分析自己的弱项所在，我们一起努力进步！</p>
          <h3 class="ui header">如果你是老师</h3>
          <p>我们能帮你查询您所教班级的同学的考试成绩，以及一个学生或者整个班级的分析图表。</p>
          <p>给予学生鼓励，让他们快乐成长！</p>
        </div>
        <div class="six wide right floated column">
          <img src="assets/images/wireframe/white-image.png" class="ui large bordered rounded image">
        </div>
      </div>
    </div>
  </div>


  <div class="ui vertical stripe quote segment">
    <div class="ui equal width stackable internally celled grid">
      <div class="center aligned row">
        <div class="column">
          <h3>你想使用？</h3>
          <p>那就联系管理员同学吧！</p>
        </div>
        <div class="column">
          <h3>我们不支持对外注册</h3>
          <p>
            只有<b>管理员</b>同学能添加修改学生和教师
          </p>
        </div>
      </div>
    </div>
  </div>

  <div class="ui vertical stripe segment">
    <div class="ui text container">
      <h3 class="ui header">如果你选择生成柱状图</h3>
      <p>柱状图适合表现单个数据的高低程度，根据它你可以看出自己每门科目的具体高度，从而发现最好的科目有多好，差一点的科目差的程度，发现自己的真实情况。</p>
      <a class="ui large button" href="https://zh.wikipedia.org/wiki/%E6%9D%A1%E5%BD%A2%E7%BB%9F%E8%AE%A1%E5%9B%BE">关于柱状图</a>
      <div class="ui divider">
        
      </div>
      <h3 class="ui header">如果你选择生成扇形图</h3>
      <p>扇形图适合表现数据相对于总数的百分比关系，根据它你可以看出自己哪门科目是自己的弱项，可以更有针对性的分配学习时间从而获得更好的学习效果。</p>
      <a class="ui large button" href="https://zh.wikipedia.org/wiki/%E9%A5%BC%E5%9B%BE">关于扇形图</a>
    </div>
  </div>


  <div class="ui inverted vertical footer segment">
      <div class="ui center aligned container">
        <img src="assets/images/logo35.jpg" class="ui centered mini image">
        <p>Copyright © 2017 feedback.edu All Rights Reserved</p>
      </div>
  </div>
</div>
  <script src="assets/library/jquery.min.js"></script>
  <script src="dist/components/visibility.js"></script>
  <script src="dist/components/sidebar.js"></script>
  <script src="dist/components/transition.js"></script>
  <script>
  $(document)
    .ready(function() {

      // fix menu when passed
      $('.masthead')
        .visibility({
          once: false,
          onBottomPassed: function() {
            $('.fixed.menu').transition('fade in');
          },
          onBottomPassedReverse: function() {
            $('.fixed.menu').transition('fade out');
          }
        })
      ;
      // create sidebar and attach to menu open
      $('.ui.sidebar')
        .sidebar('attach events', '.toc.item')
      ;

    })
  ;
  </script>
</body>
</html>