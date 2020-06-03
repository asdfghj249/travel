<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>黑马旅游网</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--引入头部-->
<div id="header">
    <%@ include file="header.jsp"%>
</div>
<!-- banner start-->
<section id="banner">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="${pageContext.request.contextPath}/images/banner_1.jpg" alt="">
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/images/banner_2.jpg" alt="">
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/images/banner_3.jpg" alt="">
            </div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</section>
<!-- banner end-->
<!-- 旅游 start-->
<section id="content">
    <!-- 黑马精选start-->
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="${pageContext.request.contextPath}/images/icon_5.jpg" alt="">
                <span>黑马精选</span>
            </div>
            <!-- Nav tabs -->
            <ul class="jx_tabs" role="tablist">
                <li role="presentation" class="active">
                    <span></span>
                    <a href="#popularity" aria-controls="popularity" role="tab" data-toggle="tab">人气旅游</a>
                </li>
                <li role="presentation">
                    <span></span>
                    <a href="#newest" aria-controls="newest" role="tab" data-toggle="tab">最新旅游</a>
                </li>
                <li role="presentation">
                    <span></span>
                    <a href="#theme" aria-controls="theme" role="tab" data-toggle="tab">主题旅游</a>
                </li>
            </ul>
        </div>
        <div class="jx_content">
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="popularity">
                    <div class="row">
                        <c:forEach begin="4" end="7" items="${allroutes}" var="route">
                            <div class="col-md-3">
                                <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">
                                    <img src="${pageContext.request.contextPath}/${route.rimage}" style="width: 242px;height: 165px" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname}</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="newest">
                    <div class="row">
                        <c:forEach begin="14" end="17" items="${allroutes}" var="route">
                            <div class="col-md-3">
                                <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">
                                    <img src="${pageContext.request.contextPath}/${route.rimage}" style="width: 242px;height: 165px" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname}</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>

                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="theme">
                    <div class="row">
                        <c:forEach begin="24" end="27" items="${allroutes}" var="route">
                            <div class="col-md-3">
                                <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">
                                    <img src="${pageContext.request.contextPath}/${route.rimage}" style="width: 242px;height: 165px" alt="">
                                    <div class="has_border">
                                        <h3>${route.rname}</h3>
                                        <div class="price">网付价<em>￥</em><strong>${route.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- 黑马精选end-->
    <!-- 国内游 start-->
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="${pageContext.request.contextPath}/images/icon_6.jpg" alt="">
                <span>国内游</span>
            </div>
        </div>
        <div class="heima_gn">
            <div class="guonei_l">
                <img src="${pageContext.request.contextPath}/images/guonei.jpg" alt="">
            </div>
            <div class="guone_r">
                <div class="row">
                    <c:forEach items="${Guonei}" var="g">
                        <div class="col-md-4">
                            <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${g.rid}">
                                <img src="${pageContext.request.contextPath}/${g.rimage}" style="width: 242px;height: 165px" alt="">
                                <div class="has_border">
                                    <h3>${g.rname}</h3>
                                    <div class="price">网付价<em>￥</em><strong>${g.price}</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </section>
    <!-- 国内游 end-->
    <!-- 境外游 start-->
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="${pageContext.request.contextPath}/images/icon_7.jpg" alt="">
                <span>境外游</span>
            </div>
        </div>
        <div class="heima_gn">
            <div class="guonei_l">
                <img src="${pageContext.request.contextPath}/images/jinwai.jpg" alt="">
            </div>
            <div class="guone_r">
                <div class="row">
                    <c:forEach items="${Jinwai}" var="j">
                        <div class="col-md-4">
                            <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${j.rid}">
                                <img src="${pageContext.request.contextPath}/${j.rimage}" style="width: 242px;height: 165px" alt="">
                                <div class="has_border">
                                    <h3>${j.rname}</h3>
                                    <div class="price">网付价<em>￥</em><strong>${j.price}</strong><em>起</em></div>
                                </div>
                            </a>
                        </div>
                    </c:forEach>


                </div>
            </div>
        </div>
    </section>
    <!-- 境外游 end-->
</section>
<!-- 旅游 end-->
<!--导入底部-->
<div id="footer">
    <%@ include file="footer.jsp"%>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
</body>
</html>
