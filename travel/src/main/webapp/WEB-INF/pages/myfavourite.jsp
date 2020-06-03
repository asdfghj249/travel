<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>黑马旅游网-我的收藏</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <style>
        .tab-content .row>div {
            margin-top: 16px;
        }
        .tab-content {
            margin-bottom: 36px;
        }
    </style>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header">
    <%@include file="header.jsp"%>
</div>
<!-- 排行榜 start-->
<section id="content">
    <section class="hemai_jx">
        <div class="jx_top">
            <div class="jx_tit">
                <img src="${pageContext.request.contextPath}/images/icon_5.jpg" alt="">
                <span>我的收藏</span>
            </div>
            <p> 共<span>${page.totalPage}</span>页><span>${total}</span>条</p>
        </div>
        <div class="jx_content">
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="home">
                    <div class="row">
                        <c:forEach items="${myfavRoutes}" var="favRoute">
                            <div class="col-md-3">
                                <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${favRoute.rid}">
                                    <img src="${pageContext.request.contextPath}/${favRoute.rimage}" style="width: 275px;height:164px " alt="">
                                    <div class="has_border">
                                        <h3>${favRoute.rname}</h3>
                                        <div class="price">网付价<em>￥</em><strong>${favRoute.price}</strong><em>起</em></div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                       
                    </div>
                </div>
            </div>
        </div>

        <%--分页--%>
        <div class="pageNum">
            <ul>
                <li>
                    <a href="?start=0">首页</a>
                </li>


                <li class="threeword">
                    <c:if test="${page.hasPreviouse}">
                        <a href="?start=${page.start-page.count}">上一页</a>
                    </c:if>
                    <c:if test="${!page.hasPreviouse}">
                        <a href="?start=0">上一页</a>
                    </c:if>

                </li>

                <c:forEach begin="${begin}" end="${end}" var="i" varStatus="vs">
                    <li <c:if test="${(vs.index-1)*page.count}==${page.start}">class="curPage" </c:if>>
                        <a href="?start=${(vs.index-1)*page.count}">${i}</a>
                    </li>
                </c:forEach>


                <li class="threeword">
                    <c:if test="${page.hasNext}">
                        <a href="?start=${page.start + page.count}">下一页</a>
                    </c:if>
                    <c:if test="${!page.hasNext}">
                        <a href="?start=${page.last}">下一页</a>
                    </c:if>
                </li>

                <li class="threeword">
                    <a href="?start=${page.last}">末页</a>
                </li>
            </ul>
        </div>
    </section>
</section>
<!-- 排行榜 end-->

<!--引入尾部-->
<div id="footer">
    <%@include file="footer.jsp"%>
</div>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
</body>
</html>