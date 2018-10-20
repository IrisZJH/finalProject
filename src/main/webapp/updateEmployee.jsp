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
<script type="text/javascript">
    $().ready(function() {
        $("#dname").change(
            function() {
                var dname = $("#dname").val();
                $.ajax( {
                    type : "post",
                    url : "/dept/selectDept",
                    data : "dname="+ dname,
                    cache : false,
                    dataType : "json",
                    success : function(json) {
                        var str = "<option>请选择</option>";
                        $("#pname").html("");
                        for ( var i = 0; i < json.length; i++) {
                            str += "<option value='" + json[i].pid
                                + "'>" + json[i].pname
                                + "</option>";
                        }
                        $("#pname").append(str);
                    },
                    error : function() {
                        alert("请与管理员联系");
                    }

                });
            });
    })
</script>

<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<form action="/employee/changeEmp" method="post">
    <table align="center" border="2">
        <tr>
            <td>部门</td>
            <td>
                <select name="dname" id="dname">
                    <c:if test="${not empty sessionScope.deptList}">
                        <c:forEach items="${sessionScope.deptList}" var="dept" >
                            <option value="${dept.dname}">${dept.dname}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </td>
        </tr>
        <tr>
            <td>职位</td>
            <td>
                <select id="pname" name="pid">
                </select>
            </td>
        </tr>
        <tr>
            <td>员工编号</td>
            <td><input type="text" value="${sessionScope.employee.eid}" name="eid" readonly> </td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" value="${sessionScope.employee.ename}" name="ename" readonly> </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="确认调动"></td>
        </tr>
    </table>
</form>
</body>
</html>
