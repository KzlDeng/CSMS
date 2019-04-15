<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>校园运动会管理系统</title>
    <link rel="stylesheet" href="css/zgz.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <link rel="stylesheet" href="css/xcConfirm.css" />
</head>

<body>
    <div class="box">
        <!-- 页面头部 -->
        <header class="page-top" id="top">
            <nav class="navbar">
                <div class="navbar-inner">
                    <div class="container-fluid">
                        <button class="btn btn-primary navbar-toggle" data-toggle="collapse" data-target="#nav-menu">
                            <span class="sr-only">切换导航</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>

                        <a class="brand pull-left" href="#">
                            <img src="images/logo2.png" alt="云南工商学院" class="hidden-xs col-sm-7">
                            <span class="col-sm-5">校园运动会管理系统</span>
                        </a>
                        <div class="dropdown pull-right">
                            <button class="btn btn-primary dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
                                <b>你好，${loginuser.username }&nbsp</b>
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                <li role="presentation" id="myCenter">
                                    <a role="menuitem" tabindex="-1" class="sidebarclick" href="singleCenter.jsp">
                                        <b class="iconfont icon-smile"></b>
                                        <span>个人中心</span>
                                    </a>
                                </li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" class="sidebarclick" href="changePwd.jsp">
                                        <b class="iconfont icon-password"></b>
                                        <span>修改密码</span>
                                    </a>
                                </li>
                                <li role="presentation" class="divider"></li>
                                <li role="presentation">
                                    <a role="menuitem" tabindex="-1" href="logout.do">
                                        <i class="glyphicon glyphicon-off"></i>
                                        <span>退出登录</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
        </header>

        <!-- 中间区域 -->
        <div class="moddle" id="moddle">
            <!-- 左侧导航栏 -->
            <div class="page-left-nav col-sm-2 col-md-2 col-lg-1 collapse in" id="nav-menu">
                <nav role="navigation" class="row">
                    <ul class="nav nav-list nav-stacked">
                        <!-- 学生 -->
                        <li role="presentation">
                            <a href="sporttime.jsp" class="sidebarclick" data-toggle="collapse">
                                <i class="iconfont icon-set"></i>
                                <span>校运会时间</span>
                            </a>
                        </li>

                        <li role="presentation">
                            <a href="#reportStu" class="collapsed" data-toggle="collapse">
                                <i class="iconfont icon-survey1"></i>
                                <span>比赛报名</span>
                                <i class="iconfont icon-more"></i>
                            </a>
                            <ul class="collapse nav nav-list" id="reportStu">
                                <li role="presentation" id="openReport">
                                    <a href="projectregistrantionservlet.do" class="sidebarclick">
                                        <span>比赛项目查看</span>
                                    </a>
                                </li>
                                <li role="presentation" id="submitReport">
                                    <a href="venueArrangementServlet.do" class="sidebarclick">
                                        <span>比赛时间安排</span>
                                    </a>
                                </li>
                                <li role="presentation" id="mediiumQuality">
                                    <a href="myProjectServlet.do" class="sidebarclick">
                                        <span>查看我的项目</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li role="presentation">
                            <a href="#datasetting" class="collapsed" data-toggle="collapse">
                                <i class="iconfont icon-jifen"></i>
                                <span>成绩管理</span>
                                <i class="iconfont icon-more" id="trans"></i>
                            </a>
                            <ul class="collapse nav nav-list" id="datasetting">
                                <li role="presentation">
                                    <a href="allpersonalachievement.jsp" class="sidebarclick">
                                        <span>个人成绩</span>
                                    </a>
                                </li>
                                <li role="presentation">
                                    <a href="classachievement.jsp" class="sidebarclick">
                                        <span>班级成绩</span>
                                    </a>
                                </li>
                                <li role="presentation">
                                    <a href="collegechievement.do?action=all&opretion=all" class="sidebarclick">
                                        <span>学院成绩</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                </nav>
            </div>

            <!-- 右侧内容区 -->
            <div class="page-right-content col-sm-10 col-md-10 col-lg-11" id="content">
                <article class="">
                    <iframe id="iframe" style="margin-top: 20px;" frameborder="0" scrolling="auto" src="sporttime.jsp" width="100%"></iframe>
                </article>
            </div>
        </div>

        <!-- 页面尾部 -->
        <footer class="page-bottom">
        </footer>
    </div>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/xcConfirm.js"></script>
    <script src="js/main.js"></script>
</body>

</html>
