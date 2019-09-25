<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>notice.jsp</title>

</head>

<body>

<c:if test="${sessionScope.libNotice != null}">

    <h3>HttpSession对象中也存了用户信息！用户信息如下：</h3>

    用户编号：${sessionScope.libNotice.id}

    <br>

    用户名：${sessionScope.libNotice.content}

    <br>

    年龄：${sessionScope.libNotice.date_time}

</c:if>

<c:if test="${requestScope.libNotice != null}">

    <h3>HttpServletRequest对象中存的用户信息如下：</h3>

    用户编号：${requestScope.libNotice.id}

    <br>

    用户名：${requestScope.libNotice.content}

    <br>

    年龄：${requestScope.libNotice.date_time}

</c:if>

</body>

</html>