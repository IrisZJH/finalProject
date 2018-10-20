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

<table class="test" width="100%" height="30%" border="0" >
    <tr>
        <td width="759" height="55" align="center" valign="bottom">
            <span class="STYLE9">添加部门</span>
        </td>
    </tr>
    <tr>
        <td height="40">
            &nbsp;
        </td>
    </tr>
</table>
<form action="/dept/addDept" method="post">
    <table width="38%" border="0" align="center" valign="bottom">
        <tr>
            <td width="30%" align="right">
                部门名称：
            </td>
            <td width="70%" align="left">
                <input type="text" name="dname" />
            </td>
        </tr>
        </tr>
        <tr align="center" >
            <td colspan="2" style="padding-right:80px" >
                <input type="submit" name="Submit" value="添加">
                <a href="${request.pageContext.contextPath}/adminpage.jsp"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
    ${sessionScope.error1}
</form>

</body>
</html>
