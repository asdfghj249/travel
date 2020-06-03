<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>黑马旅游-搜索</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>


    <style>
        .curPage{
            color: yellow;
        }
    </style>
</head>
<body>
<!--引入头部-->
<div id="header"> <%@include file="header.jsp"%> </div>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="${pageContext.request.contextPath}/images/search.png" alt="">
            <p>黑马旅行><span>搜索结果></span>共<span>${page.totalPage}</span>页><span>${total}</span>条</p>



        </div>
        <div class="xinxi clearfix">
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg">价格</span>
                </div>
                <ul>
                    <c:forEach items="${allRoutes}" var="route">
                        <li>
                            <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">
                                <div class="img"><img src="${pageContext.request.contextPath}/${route.rimage}" style="width: 299px"></div>
                            </a>
                            <div class="text1">

                                    <p>${route.rname}</p>
                                <hr>
                                <p>${route.routeIntroduce}</p>
                            </div>
                            <div class="price">
                                <p class="price_num">
                                    <span>&yen;</span>
                                    <span>${route.price}</span>
                                    <span>起</span>
                                </p>
                                <p><a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">查看详情</a></p>
                            </div>
                        </li>
                    </c:forEach>

                </ul>

                <div class="pageNum">
                    <ul>
                        <li>
                            <a href="?cid=${cid}&start=0">首页</a>
                        </li>
                        <li class="threeword">
                            <c:if test="${page.hasPreviouse}">
                                <a href="?cid=${cid}&start=${page.start-page.count}">上一页</a>
                            </c:if>
                            <c:if test="${!page.hasPreviouse}">
                                <a href="?cid=${cid}&start=0">上一页</a>
                            </c:if>
                            
                        </li>

                      <%--  <c:forEach begin="0" end="${page.totalPage-1}" varStatus="vs">

                            <li  <c:if test="${vs.index*page.count==page.start}">class="curPage"</c:if>>
                                <a href="?start=${vs.index*page.count}"
                                >${vs.count}</a>
                            </li>
                        </c:forEach>--%>
                        <c:forEach begin="${begin}" end="${end}" varStatus="vs" var="i">

                            <li  <c:if test="${(vs.index-1)*page.count==page.start}">class="curPage"</c:if>>
                                <a href="?cid=${cid}&start=${(vs.index -1)*page.count}"
                                >${i}</a>
                            </li>
                        </c:forEach>


                        <li class="threeword">
                            <c:if test="${page.hasNext}">
                                <a href="?cid=${cid}&start=${page.start+page.count}">下一页</a>
                            </c:if>
                            <c:if test="${!page.hasNext}">
                                <a href="?cid=${cid}&start=${page.last}">下一页</a>
                            </c:if>
                        </li>

                        <li class="threeword">
                            <a href="?cid=${cid}&start=${page.last}">末页</a>
                        </li>
                    </ul>
                </div>

            </div>


            <div class="right">
                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>

                    <c:forEach items="${routes}" var="route" >
                    <li>
                        <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">
                            <div class="left"><img src="${pageContext.request.contextPath}/${route.rimage}"  style="width: 120px ;height: 71px"></div>
                        </a>
                        <div class="right">
                            <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">
                                <p>${fn:substring(route.rname,0,8)}...</p>
                            </a>
                            <p>网付价<span>&yen;<span>${route.price}</span>起</span>
                            </p>
                        </div>
                    </li>
                </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--引入头部-->
<div id="footer">
    <%@include file="footer.jsp"%>
</div>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/include.js"></script>
</body>

</html>