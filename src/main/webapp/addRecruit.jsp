<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/18
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>

</head>
<%--<body class="ContentBody">--%>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<%--<table class="test" width="100%" height="30%" border="0" >--%>
    <%--<!--DWLayoutTable-->--%>
    <%--<tr>--%>
        <%--<td width="759" height="55" align="center" valign="bottom">--%>
            <%--<span class="STYLE9">添加招聘信息</span>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td height="40">--%>
            <%--&nbsp;--%>
        <%--</td>--%>
    <%--</tr>--%>
<%--</table>--%>
<form action="/recruit/addRecruit" method="post">
    <table width="80%" border="0" align="center" valign="bottom">
        <tr>添加招聘信息</tr>
        <tr>
            <td width="30%" align="right">
                公司名称：
            </td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td width="50%" align="right">
                公司地址：
            </td>
            <td>
                <input type="text" name="address">
            </td>
        </tr>
        <tr>
            <td width="50%" align="right">职位：</td>
            <td width="70%" align="left">
                <select name="pid" id="pname">
                    <c:if test="${not empty sessionScope.postList}">
                        <c:forEach items="${sessionScope.postList}" var="list2">
                            <option value="${list2.pid}">${list2.pname}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td width="50%" align="right">工作描述</td>
            <td><input type="text" name="description"></td>
        </tr>
        </tr>
        <tr align="center" >
            <td colspan="2" style="padding-right:80px" >
                <input type="submit" name="Submit" value="添加">
                <a href="${request.pageContext.contextPath}/adminpage"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
</body>
</html>
