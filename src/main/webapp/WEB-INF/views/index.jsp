<%--
  Created by IntelliJ IDEA.
  User: seo
  Date: 2015-12-01
  Time: 오후 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">


    <title>DBPIA & NAVER API RESTFULL</title>


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="../resources/assets/css/main.css" rel="stylesheet">

    <link rel="stylesheet" href="../resources/assets/css/font-awesome.min.css">

    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic" rel="stylesheet"
          type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Raleway:400,300,700" rel="stylesheet" type="text/css">

    <script src="../resources/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="../resources/assets/js/smoothscroll.js"></script>
    <script src="../resources/assets/js/Chart.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../resources/assets/js/html5shiv.js"></script>
    <script src="../resources/assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body data-spy="scroll" data-offset="0" data-target="#nav">
<c:set var="user" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/>
<div id="section-topbar">
    <div id="topbar-inner">
        <div class="container">
            <div class="row">
                <div class="dropdown">
                    <ul id="nav" class="nav">
                        <li class="menu-item"><a class="smoothScroll" href="#about" title="About"><i
                                class="icon-user"></i></a></li>
                        <li class="menu-item"><a class="smoothScroll" href="#resume" title="Resume"><i
                                class="icon-file"></i></a></li>
                        <li class="menu-item"><a class="smoothScroll" href="#work" title="Works"><i
                                class="icon-briefcase"></i></a></li>
                        <li class="menu-item"><a class="smoothScroll" href="#contact" title="Contact"><i
                                class="icon-envelope"></i></a></li>
                        <li class="menu-item"><a href="/user/signin" title="Sign in"><i
                                class="icon-signin"></i></a></li>
                        <li class="menu-item"><a href="/user/signup" title="Sign up"><i
                                class="icon-plus-sign"></i></a></li>
                        <sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
                            <li class="menu-item"><a href="/user/signup" title="Sign up"> 안녕하세요 ${user.name}님</a></li>
                            <c:url var="logoutUrl" value="/j_spring_security_logout"/>
                            <li class="menu-item"><a href="/user/signup" title="Sign up">
                                <form action="${logoutUrl}" method="post">
                                    <input type="submit" value="로그 아웃" style="color: #222222"/>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                            </a></li>
                        </sec:authorize>
                    </ul>
                    <!--/ uL#nav -->
                </div>
                <!-- /.dropdown -->


                <div class="clear"></div>
            </div>
            <!--/.row -->


        </div>
        <!--/.container -->

        <div class="clear"></div>
    </div>
    <!--/ #topbar-inner -->
</div>
<!--/ #section-topbar -->

<div id="headerwrap">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-12" style=" background-color: rgba( 255, 255, 255, 0.5 );">
                <h1 style="color: #222222;">Study Paper</h1>

                <h3 style="color: #222222;">Team | Mr. Heo,  Kim,  Seo</h3>
            </div>
            <!--/.col-lg-12 -->
        </div>
        <!--/.row -->
    </div>
    <!--/.container -->
</div>
<!--/.#headerwrap -->


<section id="about" name="about"></section>
<div id="intro">
    <div class="container">
        <div class="row">

            <div class="col-lg-2 col-lg-offset-1">
                <h5>소개</h5>
            </div>
            <div class="col-lg-6">
                <p style="line-height: 25px">스터디 페이퍼는 논문에 대해 공부를 할 때 관련된 서적 정보를 제공 해 주는  논문 관련 서적 제공 서비스입니다.
                    해당 검색어 (논문검색)와 관련 있는 논문들을 검색 후 검색한 논문들의 정보를 분석, 분석된 결과들을 바탕으로 논문과 관련 있는 책 정보들을 json 과 xml 형식으로 제공해줍니다.</p>
            </div>
            <div class="col-lg-3">
                <%--<p><a href="#"><i class="icon-file"></i></a>--%>
                    <%--<sm>DOWNLOAD PDF</sm>--%>
                <%--</p>--%>
            </div>

        </div>
        <!--/.row -->
    </div>
    <!--/.container -->
</div>
<!--/ #intro -->


<section id="resume" name="resume"></section>
<!--EDUCATION DESCRIPTION -->
<div class="container desc">
    </br></br></br></br>
    <div class="row">

        <div class="col-lg-2 col-lg-offset-1">
            <h5>API 사용법</h5>
        </div>
        <div class="col-lg-6">
            <p>
                <t>URL : end point</t>
                <br>
                http://localhost:8080/total/show/ <br>
            </p>
        </div>
        <div class="col-lg-3">
            <%--<p>--%>
                <%--<sm>GRADUATING IN MAY 2014</sm>--%>
                <%--<br>--%>
                <%--<imp>--%>
                    <%--<sm>IN PROGRESS</sm>--%>
                <%--</imp>--%>
            <%--</p>--%>
        </div>

        <div class="col-lg-6 col-lg-offset-3">
                <t>출력 형태(JSON, XML)</t>
                </br></br>
                JSON : http://localhost:8080/total/show/json?search="yourSearchWord" </br></br>
                XML  : http://localhost:8080/total/show/xml?search="yourSearchWord" </br></br>
            </p>
        </div>
        <div class="col-lg-3">

        </div>

    </div>
    <!--/.row -->
    <br>
    <hr>
</div>
<!--/.container -->


<!--WORK DESCRIPTION -->
<div class="container desc">
    <div class="row">

        <div class="col-lg-2 col-lg-offset-1">
            <h5>상세설명</h5>
        </div>
        <div class="col-lg-6">
            <p>
                <t>요청 변수(request parameter)</t>
                <br>
            </p>
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>요청변수</th>
                        <th>값</th>
                        <th>설명</th>
                    </tr>
                    <tr>
                        <td>search</td>
                        <td>검색어</td>
                        <td>검색할 내용(사람 이름, 분야 등)</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="col-lg-6 col-lg-offset-3">
            <p>
                <t>Web Designer - Intern</t>
                <br>
                Onassis Ltd. <br>
            </p>
            <p>
                <more>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                    the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of
                    type and scrambled it to make a type specimen book.
                </more>
            </p>
        </div>
        <div class="col-lg-3">
            <p>
                <sm>JUNE 2010 - JULY 2012</sm>
            </p>
        </div>
    </div>
    <!--/.row -->
    <br>
    <hr>
</div>
<!--/.container -->


<!--AWARDS DESCRIPTION -->
<div class="container desc">
    <div class="row">
        <div class="col-lg-2 col-lg-offset-1">
            <h5>AWARDS</h5>
        </div>
        <div class="col-lg-6">
            <p>
                <t>Best Web Design</t>
                <br>
                Black Tie Site <br>
            </p>
        </div>
        <div class="col-lg-3">
            <p>
                <sm>NOVEMBER 2013</sm>
            </p>
        </div>

        <div class="col-lg-6 col-lg-offset-3">
            <p>
                <t>Designer of the Year</t>
                <br>
                Awwwards Site
            </p>
            <p>
                <more>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                    the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of
                    type and scrambled it to make a type specimen book.
                </more>
            </p>
        </div>
        <div class="col-lg-3">
            <p>
                <sm>2013</sm>
            </p>
        </div>

    </div>
    <!--/.row -->
    <br>
</div>
<!--/.container -->


<!--SKILLS DESCRIPTION -->
<div id="skillswrap">
    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-lg-offset-1">
                <h5>SKILLS</h5>
            </div>
            <div class="col-lg-3 centered">
                <canvas id="javascript" height="130" width="130" style="width: 130px; height: 130px;"></canvas>
                <p>Javascript</p>
                <br>
                <script>
                    var doughnutData = [
                        {
                            value: 70,
                            color: "#1abc9c"
                        },
                        {
                            value: 30,
                            color: "#ecf0f1"
                        }
                    ];
                    var myDoughnut = new Chart(document.getElementById("javascript").getContext("2d")).Doughnut(doughnutData);
                </script>
            </div>
            <div class="col-lg-3 centered">
                <canvas id="illustrator" height="130" width="130" style="width: 130px; height: 130px;"></canvas>
                <p>restFULL</p>
                <br>
                <script>
                    var doughnutData = [
                        {
                            value: 50,
                            color: "#1abc9c"
                        },
                        {
                            value: 50,
                            color: "#ecf0f1"
                        }
                    ];
                    var myDoughnut = new Chart(document.getElementById("illustrator").getContext("2d")).Doughnut(doughnutData);
                </script>
            </div>

        </div>
        <!--/.row -->
        <br>
    </div>
    <!--/.container -->
</div>
<!--/ #skillswrap -->


<section id="work" name="work"></section>
<!--PORTFOLIO DESCRIPTION -->
<!--/.container -->


<section id="contact" name="contact"></section>
<!--FOOTER DESCRIPTION -->
<div id="footwrap">
    <div class="container">
        <div class="row">

            <div class="col-lg-2 col-lg-offset-1">
                <h5>CONTACT</h5>
            </div>
            <div class="col-lg-6">
                <p>
                    <t>Email</t>
                    <br>
                    william@blacktie.co <br>
                </p>
                <p>
                    <t>Adress</t>
                    <br>
                    Some Ave. 987 <br>
                    Postal 23892 <br>
                    London, England. <br>
                </p>
                <p>
                    <t>Phone</t>
                    <br>
                    +55 8933-2383 <br>
                </p>
            </div>
            <div class="col-lg-3">
                <p>
                    <sm>SOCIAL LINKS</sm>
                </p>
                <p>
                    <a href="#"><i class="icon-dribbble"></i></a>
                    <a href="#"><i class="icon-twitter"></i></a>
                    <a href="#"><i class="icon-facebook"></i></a>
                    <a href="#"><i class="icon-linkedin"></i></a>
                    <a href="#"><i class="icon-apple"></i></a>

                </p>
            </div>
        </div>
        <!--/.row -->
    </div>
    <!--/.container -->
</div>
<!--/ #footer -->

<div id="c">
    <div class="container">
        <p>Created by <a href="http://www.blacktie.co">LINK</a></p>

    </div>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./resources/assets/js/bootstrap.js"></script>
</body>
</html>
