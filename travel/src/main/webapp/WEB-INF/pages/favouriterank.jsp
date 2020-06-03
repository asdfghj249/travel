<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>收藏排行榜</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ranking-list.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
<!--引入头部-->
<div id="header">
    <%@include file="header.jsp"%>
</div>
<div class="contant">
    <div>
        <p> 共<span>${page.totalPage}</span>页><span>${total}</span>条</p>
    </div>

    <div class="list clearfix">
        <ul>
            <c:forEach items="${routes}" var="route" varStatus="vs">
                <li>
                    <span class="num one">${vs.count+(page.currentPage-1)*page.count}</span>
                    <a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}"><img src="${pageContext.request.contextPath}/${route.rimage}" style="width: 284px;height: 165px"  ></a>
                    <h4><a href="${pageContext.request.contextPath}/route/routeDetail?rid=${route.rid}">${fn:substring(route.rname,0,15)}(</a></h4>
                    <p>
                        <b class="price">&yen;<span>${route.price}</span>起</b>
                        <span class="shouchang">已收藏${route.count}次</span>
                    </p>
                </li>
            </c:forEach>


        </ul>
    </div>
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

            <c:forEach begin="${begin}" end="${end}" varStatus="vs" var="i">
                <li  <c:if test="${(vs.index-1)*page.count==page.start}">class="curPage"</c:if>>
                    <a href="?start=${(vs.index -1)*page.count}"
                    >${i}</a>
                </li>
            </c:forEach>


            <li class="threeword">
                <c:if test="${page.hasNext}">
                    <a href="?start=${page.start+page.count}">下一页</a>
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


</div>

<!--导入底部-->
<div id="footer">
    <%@include file="footer.jsp"%>
</div>
<!--导入布局js，共享header和footer-->
<script type="text/javascript" src=${pageContext.request.contextPath}/js/include.js></script>
</body>
</html>