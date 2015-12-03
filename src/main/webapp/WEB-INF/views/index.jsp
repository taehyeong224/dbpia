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

                <h3 style="color: #222222;">Team | Mr. Heo, Kim, Seo</h3>
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
                <p style="line-height: 25px">스터디 페이퍼는 논문에 대해 공부를 할 때 관련된 서적 정보를 제공 해 주는 논문 관련 서적 제공 서비스입니다.
                    해당 검색어 (논문검색)와 관련 있는 논문들을 검색 후 검색한 논문들의 정보를 분석, 분석된 결과들을 바탕으로 논문과 관련 있는 책 정보들을 json 과 xml 형식으로
                    제공해줍니다.</p>
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

        <div class="col-lg-8 col-lg-offset-3">
            <t>출력 형태(JSON, XML)</t>
            </br></br>
            JSON : http://localhost:8080/total/show/json?key="yourkey"&search="yourSearchWord" </br></br>
            XML : http://localhost:8080/total/show/xml?key="yourkey"&search="yourSearchWord" </br></br>
            발급 받은 키 : ${user.key}<br/><br/>

        </div>
        <div class="col-lg-1">

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
                        <td>string</td>
                        <td>검색할 내용(사람 이름, 분야 등)</td>
                    </tr>
                    <tr>
                        <td>display</td>
                        <td>int</td>
                        <td>검색할 책 갯수</td>
                    </tr>
                    <tr>
                        <td>key</td>
                        <td>String</td>
                        <td>발급받은 키</td>
                    </tr>
                </table>
            </div>
        </div>

        <div class="col-lg-6 col-lg-offset-3">
            <p>
                <t>출력 결과 필드</t>
                <br>
            </p>
            <p>
                <more> 아래 테이블은 결과 값에 대한 요약 정보입니다.
                </more>
            </p>

            <table class="table">
                <tr>
                    <td>필드</td>
                    <td>값</td>
                    <td>설명</td>
                </tr>
                <tr>
                    <td>ctype</td>
                    <td>string</td>
                    <td>
                        콘텐츠 유형<br/>
                        series=시리즈 | book=간행물 | db=데이터베이스<br/>
                        article =논문 | chapter=챕터 | record=항목<br/>
                        public=첫단추(논문)<br/>
                    </td>
                </tr>
                <tr>
                    <td>title</td>
                    <td>string</td>
                    <td>
                        제목<br/>
                        콘텐츠 유형에 따라 시리즈제목, 간행물제목, 데이터베이스명, 논문제목, 챕터제목, 항목명 등이 됩니다.
                    </td>
                </tr>
                <tr>
                    <td>authors</td>
                    <td>-</td>
                    <td>
                        저자명들<br/>
                        여러명의 저자를 child element인 author로 구분합니다.<br/>
                    </td>
                </tr>
                <tr>
                    <td>author</td>
                    <td>-</td>
                    <td>
                        하위요소<br/>
                        order = 저자순서, url=식별된 저자의 url, name=저자명 <br/>
                    </td>
                </tr>
                <tr>
                    <td>publisher</td>
                    <td>-</td>
                    <td>
                        하위요소<br/>
                        url = 발행기관 url, name = 발행기관명
                    </td>
                </tr>
                <tr>
                    <td>publication</td>
                    <td>-</td>
                    <td>
                        간행물명<br/>
                        콘텐츠 유형이 논문, 챕터, 항목일 경우에만 표시됩니다.<br/>
                        하위요소<br/>
                        url = 간행물 url, name = 간행물명
                    </td>
                </tr>
                <tr>
                    <td>issue</td>
                    <td>-</td>
                    <td>
                        권호<br/>
                        하위요소. <br/>
                        name = 권호명(콘텐츠 유형이 논문일 경우에만 표시됩니다.)<br/>
                        num = 권(호) (콘텐츠 유형이 논문일 경우에만 표시됩니다.)<br/>
                        yymm = 발행연월(전자저널 간행물의 경우에는 표시되지 않습니다.)<br/>
                    </td>
                </tr>
                <tr>
                    <td>pages</td>
                    <td>string</td>
                    <td>
                        페이지<br/>
                        시작페이지~끝페이지(총페이지수)로 구성되어 있습니다.<br/>
                        콘텐츠 유형이 논문일 경우에만 표시됩니다.<br/>
                    </td>
                </tr>
                <tr>
                    <td>preview</td>
                    <td>string</td>
                    <td>미리보기 링크</td>
                </tr>
                <tr>
                    <td>link_url</td>
                    <td>string</td>
                    <td>상세정보 링크</td>
                </tr>
                <tr>
                    <td>link_api</td>
                    <td>string</td>
                    <td>비즈니스 API 링크<br/>
                        논문에만 표시됩니다.
                    </td>
                </tr>
                <tr>
                    <td>books</td>
                    <td>-</td>
                    <td>하위요소. <br/>
                        아래 테이블을 참고하세요
                    </td>
                </tr>
            </table>
            <p>
                <t>books 세부 정보 필드</t>
                <br>
            </p>
            <table class="table">
                <tr class="odd">
                    <th>필드</th>
                    <th> 값</th>
                    <th> 설명</th>
                </tr>
                <tr class="odd">
                    <td>title</td>
                    <td> string</td>
                    <td>검색 결과 문서의 제목을 나타냅니다. 제목에서 검색어와 일치하는 부분은 <b> 태그로 감싸져 있습니다.</b></td>
                </tr>
                <tr>
                    <td>link</td>
                    <td> string</td>
                    <td>검색 결과 문서의 하이퍼텍스트 link를 나타냅니다.</td>
                </tr>
                <tr class="odd">
                    <td>image</td>
                    <td> string</td>
                    <td>썸네일 이미지의 URL입니다. 이미지가 있는 경우만 나타납니다.</td>
                </tr>
                <tr>
                    <td>author</td>
                    <td> string</td>
                    <td>저자정보입니다.</td>
                </tr>
                <tr class="odd">
                    <td>price</td>
                    <td> integer</td>
                    <td>정가 정보입니다. 절판도서 등으로 가격이 없으면 나타나지 않습니다.</td>
                </tr>
                <tr>
                    <td>discount</td>
                    <td> integer</td>
                    <td>할인 가격정보입니다. 절판도서 등으로 가격이 없으면 나타나지 않습니다.</td>
                </tr>
                <tr class="odd">
                    <td>publisher</td>
                    <td> string</td>
                    <td>출판사 정보입니다.</td>
                </tr>
                <tr>
                    <td>pubdate</td>
                    <td> date</td>
                    <td>출간일 정보입니다.</td>
                </tr>
                <tr class="odd">
                    <td>isbn</td>
                    <td> integer</td>
                    <td>ISBN 넘버입니다.</td>
                </tr>
                <tr>
                    <td>description</td>
                    <td> string</td>
                    <td>검색 결과 문서의 내용을 요약한 패시지 정보입니다. 문서 전체의 내용은 link 를 따라가면 <br/>읽을 수 있습니다. 패시지에서 검색어와 일치하는 부분은 <b> 태그로
                        감싸져 있습니다.</b></td>
                </tr>
            </table>
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
            <h5>example</h5>
        </div>
        <div class="col-lg-9">
            <ul>
                <li>샘플 페이지 - JSON
                </li>
            </ul>
            <div class="prettify">
                <pre>{
  &quot;keyword&quot;: &quot;\ud55c\uc5f0\ud76c&quot;,
  &quot;result&quot;: {
    &quot;items&quot;: {
      &quot;item&quot;: [
        {
          &quot;ctype&quot;: &quot;article&quot;,
          &quot;title&quot;: &quot;IEEE 802.16\uc640 IPv6 \ucee8\ubc84\uc804\uc2a4\uc5d0 \ub300\ud55c \uae30\uc220 \ubc0f \uad6d\uc81c \ud45c\uc900\ud654\uc758 \uc18c\uac1c&quot;,
          &quot;authors&quot;: {
            &quot;authors&quot;: [
              {
                &quot;order&quot;: &quot;1&quot;,
                &quot;name&quot;: &quot;&lt;span class='kwd_hilighting'&gt;\ud55c\uc5f0\ud76c&lt;\/span&gt;&quot;,
                &quot;url&quot;: null
              }
            ]
          },
          &quot;pages&quot;: &quot;33-37 (5 pages)&quot;,
          &quot;preview&quot;: &quot;http:\/\/image.dbpia.co.kr\/PreView\/NODE00813101&quot;,
          &quot;link_url&quot;: null,
          &quot;link_api&quot;: null,
          &quot;publisher&quot;: {
            &quot;url&quot;: &quot;http:\/\/www.dbpia.co.kr\/Publisher\/IPRD00010353&quot;,
            &quot;name&quot;: &quot;\ud55c\uad6d\uc815\ubcf4\uae30\uc220\ud559\ud68c&quot;
          },
          &quot;publication&quot;: {
            &quot;issn&quot;: &quot;1738-0847&quot;,
            &quot;url&quot;: &quot;http:\/\/www.dbpia.co.kr\/Publication\/PLCT00000959&quot;,
            &quot;name&quot;: &quot;\ud55c\uad6d\uc815\ubcf4\uae30\uc220\ud559\ud68c\uc9c0&quot;
          },
          &quot;books&quot;: {
            &quot;book&quot;: [
              {
                &quot;title&quot;: &quot;&lt;b&gt;\uad6d\uc81c\ud45c\uc900&lt;\/b&gt;\uc740\ud589\uad00\ud589 ISBP 745 (\uc2e0\uc6a9\uc7a5\ud1b5\uc77c\uaddc\uce59 UCP600\uc5d0 \ub530\ub978, \uacf5\uc2dd\ubc88\uc5ed \ubc0f \uc2e4\ubb34\uac00\uc774\ub4dc)&quot;,
                &quot;link&quot;: &quot;http:\/\/openapi.naver.com\/l?AAAC2NTavCMBREf83NRig3X7ZZZBFtu3AhKrjQjbTmlkrV1hJ99P16owgDMxw4zONJ42ShcLDQ4HIoluAQzHIGRQ6Gx\/VFCjJkYRrI1n3fsY4mi8rgmSslmoqwMXOdViQ4KsLaS51lrB2psW0IA0gHooz5uMm9etGYnPvbD\/j6N06eQnW5JkMbjbK+eJB5KlItpWDBxieDSmaac4HsZteHqG31\/2ETmzfHVV5u13\/u5ef7zXXXRfcNhx\/01NsAAAA=&quot;,
                &quot;image&quot;: &quot;http:\/\/bookthumb.phinf.naver.net\/cover\/072\/753\/07275332.jpg?type=m1&amp;udate=20140303&quot;,
                &quot;author&quot;: &quot;\ud55c\uad6d\uae08\uc735\uc5f0\uc218\uc6d0&quot;,
                &quot;price&quot;: &quot;25000&quot;,
                &quot;discount&quot;: &quot;22500&quot;,
                &quot;publisher&quot;: &quot;\ud55c\uad6d\uae08\uc735\uc5f0\uc218\uc6d0&quot;,
                &quot;pubdate&quot;: &quot;20130708&quot;,
                &quot;isbn&quot;: &quot;8928706386 9788928706389&quot;,
                &quot;description&quot;: &quot;\u300e&lt;b&gt;\uad6d\uc81c\ud45c\uc900&lt;\/b&gt;\uc740\ud589\uad00\ud589 ISBP 745\u300f\uc740 \uc2e0\uc6a9\uc7a5\ud1b5\uc77c\uaddc\uce59\ud558\uc5d0\uc11c \uc11c\ub958 \uc2ec\uc0ac \uc2dc \uc801\uc6a9\ub418\uc5b4\uc57c \ud560 &lt;b&gt;\uad6d\uc81c\ud45c\uc900&lt;\/b&gt;\uc740\ud589\uc5d0 \uad00\ud574 \ud574\uc124\ud55c \ucc45\uc790\uc774\ub2e4. \uc2e4\ubb34\uc790\ub4e4\uc744 \uc704\ud574 \uc2e4\ubb34\uc5d0\uc11c \ubc14\ub85c \uc801\uc6a9\ud560 \uc218 \uc788\ub3c4\ub85d \uc9d1\ud544\ud558\uc600\uc73c\uba70 \uac01\ud56d\uc5d0 \ub300\ud55c \uc124\uba85\uacfc \ud48d\ubd80\ud55c \uc0ac\ub840\ub97c \ud1b5\ud574 \uc27d\uac8c \uc774\ud574\ub97c \ub3d5\ub294\ub2e4. \ub610\ud55c 298\uac1c\ub85c \ud56d\uc774 \ud655\ub300\ub418\uba74\uc11c \uae30\uc874\uc5d0 \ub2e4\ub8e8\uc9c0 \uc54a\uc558\ub358... &quot;
              },

            ]
          }
        },
        ....
}
</pre>
            </div>

            <ul>
                <li>샘플 페이지 - XML
                </li>
            </ul>
            <div class="prettify">
                <pre>
            &lt;Total xmlns=""&gt;
            &lt;keyword&gt;한연희&lt;/keyword&gt;
            &lt;result&gt;
            &lt;items&gt;
            &lt;item&gt;
            &lt;item&gt;
            &lt;ctype&gt;article&lt;/ctype&gt;
            &lt;title&gt;IEEE 802.16와 IPv6 컨버전스에 대한 기술 및 국제 표준화의 소개&lt;/title&gt;
            &lt;authors&gt;
            &lt;authors&gt;
            &lt;authors&gt;
            &lt;order&gt;1&lt;/order&gt;
            &lt;name&gt;&lt;span class='kwd_hilighting'&gt;한연희&lt;/span&gt;&lt;/name&gt;
            &lt;url/&gt;
            &lt;/authors&gt;
            &lt;/authors&gt;
            &lt;/authors&gt;
            &lt;pages&gt;33-37 (5 pages)&lt;/pages&gt;
            &lt;preview&gt;http://image.dbpia.co.kr/PreView/NODE00813101&lt;/preview&gt;
            &lt;link_url/&gt;
            &lt;link_api/&gt;
            &lt;publisher&gt;
            &lt;url&gt;http://www.dbpia.co.kr/Publisher/IPRD00010353&lt;/url&gt;
            &lt;name&gt;한국정보기술학회&lt;/name&gt;
            &lt;/publisher&gt;
            &lt;publication&gt;
            &lt;issn&gt;1738-0847&lt;/issn&gt;
            &lt;url&gt;http://www.dbpia.co.kr/Publication/PLCT00000959&lt;/url&gt;
            &lt;name&gt;한국정보기술학회지&lt;/name&gt;
            &lt;/publication&gt;
            &lt;books&gt;
            &lt;book&gt;
            &lt;book&gt;
            &lt;title&gt;
            &lt;b&gt;국제표준&lt;/b&gt;은행관행 ISBP 745 (신용장통일규칙 UCP600에 따른, 공식번역 및 실무가이드)
            &lt;/title&gt;
            &lt;link&gt;
            http://openapi.naver.com/l?AAAC2NSwuCQBRGf82dTSDXeaSzmIWlEj1oVVSb0LxmmGk2Ff77pgi+xeHA4bs/qR8MJBFMFEQxJFOIEPR0BEkM2nf0UxJCZHboyORtW7OaBoNS48mXkpcZYanHKsiI+ygJ80KoMGRVT6WprO1ARMBTt2/r3bIX9d6pbf6iyP9wLMhml6vXVa5I80sBIg54oITgzBr3pFGOkQcSQ9aY4dBsr6sDzc/irh+7zVpt/P1CLWfPt+s+WCa+mtcAAAA=
            &lt;/link&gt;
            &lt;image&gt;
            http://bookthumb.phinf.naver.net/cover/072/753/07275332.jpg?type=m1&udate=20140303
            &lt;/image&gt;
            &lt;author&gt;한국금융연수원&lt;/author&gt;
            &lt;price&gt;25000&lt;/price&gt;
            &lt;discount&gt;22500&lt;/discount&gt;
            &lt;publisher&gt;한국금융연수원&lt;/publisher&gt;
            &lt;pubdate&gt;20130708&lt;/pubdate&gt;
            &lt;isbn&gt;8928706386 9788928706389&lt;/isbn&gt;
            &lt;description&gt;
            『&lt;b&gt;국제표준&lt;/b&gt;은행관행 ISBP 745』은 신용장통일규칙하에서 서류 심사 시 적용되어야 할 &lt;b&gt;국제표준&lt;/b&gt;은행에 관해 해설한 책자이다. 실무자들을 위해 실무에서 바로 적용할 수 있도록 집필하였으며 각항에 대한 설명과 풍부한 사례를 통해 쉽게 이해를 돕는다. 또한 298개로 항이 확대되면서 기존에 다루지 않았던...
            &lt;/description&gt;
            &lt;/book&gt;
            &lt;book&gt;
            &lt;title&gt;
            Wirelessman : Inside the &lt;b&gt;IEEE 802.16&lt;/b&gt; Standard for Wireless Metropolitan Area Networks (Paperback ) (Inside the &lt;b&gt;IEEE 802.16&lt;/b&gt; Standard for Wireless Metropolitan Area Networks)
            &lt;/title&gt;
            &lt;link&gt;
            http://openapi.naver.com/l?AAAC3NzwuCMBwF8L/GXQKZ25zbYQejGUFRl7qGuq8o/mzNSP/6Fgjv8Hjw4b1msIs6aa13ApMw4sgtE6hiHFvUwqIwk7iMGCNVDriSPE5yIBFmgAtDYyFQbaFStXNTQNOAZD5/Gw75B2xYjv02mGIrTwMub7pwqr3IisYE9EAkT4gUyCn/JDHjmCRMUNSrVq+Pewfz+7gn35u7PuwlW4dz2i/aux9LGjl4vQAAAA==
            &lt;/link&gt;
            &lt;image&gt;
            http://bookthumb.phinf.naver.net/cover/029/672/02967298.jpg?type=m1&udate=20091228
            &lt;/image&gt;
            &lt;author&gt;
            Eklund, Carl|Marks, Roger B.|Ponnuswamy, Subbu|Stanwood, Kenneth L
            &lt;/author&gt;
            &lt;price&gt;123540&lt;/price&gt;
            &lt;discount&gt;101310&lt;/discount&gt;
            &lt;publisher&gt;TrafalgarSquare&lt;/publisher&gt;
            &lt;pubdate&gt;20070715&lt;/pubdate&gt;
            &lt;isbn&gt;0738148423 9780738148427&lt;/isbn&gt;
            &lt;description&gt;
            [해외주문원서] 고객님의 요청으로 수입 주문하는 도서이므로, 주문취소 및 반품이 불가합니다. (단, 재고부족인 경우는 가능)
            &lt;/description&gt;
            &lt;/book&gt;
            &lt;book&gt;
            &lt;title&gt;&lt;b&gt;IPv6&lt;/b&gt; Network의 이해 (GNS3 시뮬레이터를 활용한)&lt;/title&gt;
            &lt;link&gt;
            http://openapi.naver.com/l?AAAC2NywqDMBQFv8Ys5RoTjYssKsUqdVFoi90VHzdVrI1KGvDvm4JwFsOBYZYvrpssLjYiZptRNlqPZMRNAkugDRijqkZQScTjGmkADKHpQi4E6VdUsjdm9sKDRzO3v+t/aour3+ppP7pmh2eHph7e/tw7I2uGzguPMYNQCJeWrpQAi4DGnAsyyTQtVHbX1Sm1QBc8p2V1tbc8f5Qv5/0AyVviw7YAAAA=
            &lt;/link&gt;
            &lt;image&gt;
            http://bookthumb.phinf.naver.net/cover/074/038/07403886.jpg?type=m1&udate=20150723
            &lt;/image&gt;
            &lt;author&gt;고득녕|김종민&lt;/author&gt;
            &lt;price&gt;20000&lt;/price&gt;
            &lt;discount&gt;18000&lt;/discount&gt;
            &lt;publisher&gt;성안당&lt;/publisher&gt;
            &lt;pubdate&gt;20140110&lt;/pubdate&gt;
            &lt;isbn&gt;8931552688 9788931552683&lt;/isbn&gt;
            &lt;description&gt;
            실제 기간통신사업자가 상용 가입자들에게 &lt;b&gt;IPV6&lt;/b&gt; NETWORK를 제공하면서 생기는 여러 이슈들을 바탕으로 했습니다. 차세대 IP 주소인 &lt;b&gt;IPV6&lt;/b&gt;에 대해 쉽게 설명했습니다. 본서에 수록된 예제는 CISCO ROUTER SIMULATOR인 GNS3를 활용해 동일한 환경에서 실습할 수 있도록 구성했습니다. 표준 RFC 문서의...
            &lt;/description&gt;
            &lt;/book&gt;
            &lt;book&gt;
            &lt;title&gt;클라우드 컴퓨팅과 SOA &lt;b&gt;컨버전스&lt;/b&gt; (전사적 도입을 통한 기업의 생존 전략)&lt;/title&gt;
            &lt;link&gt;
            http://openapi.naver.com/l?AAAC2NwY6CMBRFv+Z1SR5thXbRRRE00ZgYM4vZTSh9iEEFSZXg14sTkrs4OcnJfTxpmAwUa8gysAqKDDIOSn6NxQWUBfsPOgWNLEw9Gdd1LWtpMig1VrGUvC4Ja52s0pJ4jJLQebFSijUD1aYJoQdhgW/mfdvoXr5oiKrutgjvFvjzFMrLNeqbudi4iweRa6mUSAULZn7SKBPkaRJrdjP7wrXHqxrH8ZA/t+ef/PfdEPkT7dq5+wBI+6iu3wAAAA==
            &lt;/link&gt;
            &lt;image&gt;
            http://bookthumb.phinf.naver.net/cover/094/883/09488373.jpg?type=m1&udate=20150902
            &lt;/image&gt;
            &lt;author&gt;데이비드 린시컴&lt;/author&gt;
            &lt;price&gt;28000&lt;/price&gt;
            &lt;discount&gt;25200&lt;/discount&gt;
            &lt;publisher&gt;에이콘출판&lt;/publisher&gt;
            &lt;pubdate&gt;20150831&lt;/pubdate&gt;
            &lt;isbn&gt;8960777455 9788960777453&lt;/isbn&gt;
            &lt;description&gt;
            에이콘 클라우드 컴퓨팅 시리즈. 가트너에 따르면, 세계 클라우드 컴퓨팅 시장은 2016년까지 대략 2100억 달러에 이를 것으로 추정되고, 기업 내 클라우드 관련 예산은 2014년 12.3%를 넘어 2018년에는 22%를 차지할 것으로 예상된다. 이 책은 이렇게 모든 기업들이 필수 생존전략으로 인지하고 있는 클라우드...
            &lt;/description&gt;
            &lt;/book&gt;
            &lt;/book&gt;
            &lt;/books&gt;
            &lt;/item&gt;
                ....
            &lt;/items&gt;
            &lt;/result&gt;
            &lt;/Total&gt;
</pre>
            </div>
        </div>
    </div>
    <!--/.row -->
    <br>
</div>
<!--/.container -->

<!--SKILLS DESCRIPTION -->
<%--<div id="skillswrap">--%>
    <%--<div class="container">--%>
        <%--<div class="row">--%>
            <%--<div class="col-lg-2 col-lg-offset-1">--%>
                <%--<h5>SKILLS</h5>--%>
            <%--</div>--%>
            <%--<div class="col-lg-3 centered">--%>
                <%--<canvas id="javascript" height="130" width="130" style="width: 130px; height: 130px;"></canvas>--%>
                <%--<p>Javascript</p>--%>
                <%--<br>--%>
                <%--<script>--%>
                    <%--var doughnutData = [--%>
                        <%--{--%>
                            <%--value: 70,--%>
                            <%--color: "#1abc9c"--%>
                        <%--},--%>
                        <%--{--%>
                            <%--value: 30,--%>
                            <%--color: "#ecf0f1"--%>
                        <%--}--%>
                    <%--];--%>
                    <%--var myDoughnut = new Chart(document.getElementById("javascript").getContext("2d")).Doughnut(doughnutData);--%>
                <%--</script>--%>
            <%--</div>--%>
            <%--<div class="col-lg-3 centered">--%>
                <%--<canvas id="illustrator" height="130" width="130" style="width: 130px; height: 130px;"></canvas>--%>
                <%--<p>restFULL</p>--%>
                <%--<br>--%>
                <%--<script>--%>
                    <%--var doughnutData = [--%>
                        <%--{--%>
                            <%--value: 50,--%>
                            <%--color: "#1abc9c"--%>
                        <%--},--%>
                        <%--{--%>
                            <%--value: 50,--%>
                            <%--color: "#ecf0f1"--%>
                        <%--}--%>
                    <%--];--%>
                    <%--var myDoughnut = new Chart(document.getElementById("illustrator").getContext("2d")).Doughnut(doughnutData);--%>
                <%--</script>--%>
            <%--</div>--%>

        <%--</div>--%>
        <%--<!--/.row -->--%>
        <%--<br>--%>
    <%--</div>--%>
    <%--<!--/.container -->--%>
<%--</div>--%>
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
