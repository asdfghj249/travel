<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 头部 start -->
<header id="header">
    <div class="top_banner">
        <img src="${pageContext.request.contextPath}/images/top_banner.jpg" alt="">
    </div>
    <div class="shortcut">
        <!-- 未登录状态  -->
        <c:if test="${user==null}">
            <div class="login_out">
                <a href="${pageContext.request.contextPath}/fore/loginUI">登录</a>
                <a href="${pageContext.request.contextPath}/fore/registerUI">注册</a>
            </div>
        </c:if>
        <!-- 登录状态  -->
        <c:if test="${user != null}">
            <div class="login">
                <span>欢迎回来，${user.username}</span>
                <a href="${pageContext.request.contextPath}/fav/myfavourite" class="collection">我的收藏</a>
                <a href="${pageContext.request.contextPath}/fore/logout">退出</a>
            </div>
        </c:if>
    </div>
    <div class="header_wrap">
        <div class="topbar">
            <div class="logo">
                <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="">
            </div>


            <div class="search">
                <form action="${pageContext.request.contextPath}/fore/searchRoute" method="post">
                    <input name="rname" type="search" placeholder="请输入路线名称" class="search_input" >
                    <button type="submit" class="search-button">搜索</button>
                </form>
            </div>


            <div class="hottel">
                <div class="hot_pic">
                    <img src="${pageContext.request.contextPath}/images/hot_tel.jpg" alt="">
                </div>
                <div class="hot_tel">
                    <p class="hot_time">客服热线(9:00-6:00)</p>
                    <p class="hot_num">400-618-9090</p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- 头部 end -->
<!-- 首页导航 -->
<div class="navitem">
    <ul class="nav">
        <li class="nav-active"><a href="${pageContext.request.contextPath}/fore/forIndex">首页</a></li>
        <c:forEach items="${categories}" var="category">
            <li><a href="${pageContext.request.contextPath}/route/findRoutes?cid=${category.cid}">${category.cname}</a></li>
        </c:forEach>
        <li><a href="${pageContext.request.contextPath}/fav/favouriteRank">收藏排行榜</a></li>
    </ul>
</div>
