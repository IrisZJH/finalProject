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
<form action="/post/addPost" method="post">
    <table width="38%" border="0" align="center" valign="bottom">
        <tr>
            <td width="30%" align="right">
                部门名称：
            </td>
            <td width="70%" align="left">
                <select name="dname" id="dname">
                    <c:if test="${not empty sessionScope.deptList}">
                        <c:forEach items="${sessionScope.deptList}" var="dept">
                            <option value="${dept.dname}">${dept.dname}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>

        <tr>
            <td width="30%" align="right">
                职位名称：
            </td>
            <td width="70%" align="left">
                <input type="text" name="pname">
            </td >
        </tr>

        <tr align="center" >
            <td colspan="2" style="padding-right:80px" >
                <input type="submit" name="Submit" value="添加">
                <a href="${request.pageContext.contextPath}/adminpage.jsp"><input type="button" value="返回"></a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
