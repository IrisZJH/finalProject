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
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<form action="/dissent/addDissent" method="post">
    <table align="center" border="2">
        <tr>
            <td>异议缘由</td>
            <td><input type="text" name="dissent"></td>
        </tr>
        <tr>
            <td>异议时间</td>
            <td><input type="text" name="month"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="异议">&nbsp;
                <a href="${pageContext.request.contextPath}/employeepage.jsp"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
