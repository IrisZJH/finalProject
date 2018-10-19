<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/12
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="css/index.css" rel="stylesheet" type="text/css" />--%>


</head>

<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
    <table border="0" bgcolor="#e6e1ff">
        <tr>

            <td width="100%" height="20" align="right" valign="top"><a href="${request.pageContext.contextPath}/index.jsp">退出</a></td>
        </tr>

        <tr>
            <td height="52" ><a href="/recruit/showRecruit"> 查看招聘信息</a></td>
        </tr>
        <tr><td height="52" ><a href="/user/lookInterview"> 查看面试通知</a></td></tr>

    </table>


    <table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
        <%--<TABLE height="0%">--%>
            <tr>
                <c:if test="${empty sessionScope.resume}">
                    <td nowrap align="right" width="9%">您还没有简历</td>
                    <td  width="9%"><a href="${request.pageContext.contextPath}/addResume.jsp">新建简历</a></td>
                </c:if>
            </tr>
        </TABLE>

        <table align="center">
            <tr>
                <c:if test="${not empty sessionScope.resume}">
                    <td width="100%">
                        <fieldset style="height:100%;">
                            <legend>简历信息</legend>
                            <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                                <tr>
                                    <td nowrap align="right" width="9%">姓名：</td>
                                    <td width="36%">${sessionScope.resume.name}</td>
                                    <td width="12%"><div align="right">性别：</div></td>
                                    <td width="43%">
                                            ${sessionScope.resume.sex}
                                </tr>
                                <tr>
                                    <td nowrap align="right" width="9%">年龄：</td>
                                    <td>${sessionScope.resume.age}</td>
                                    <td><div align="right">职位：</div></td>
                                    <td>${sessionScope.resume.job}</td>
                                </tr>
                                <tr>
                                    <td nowrap align="right">所学专业：</td>
                                    <td>${sessionScope.resume.specialty}</td>
                                    <td><div align="right">工作经验：</div></td>
                                    <td>${sessionScope.resume.experience}</td>
                                </tr>
                                <tr>
                                    <td nowrap align="right">学历：</td>
                                    <td>${sessionScope.resume.studyeffort}</td>
                                    <td><div align="right">毕业学校：</div></td>
                                    <td>${sessionScope.resume.school}</td>
                                </tr>
                                <tr>
                                    <td nowrap align="right">电话：</td>
                                    <td>${sessionScope.resume.tel}</td>
                                    <td><div align="right">Email：</div></td>
                                    <td>${sessionScope.resume.email}</td>
                                </tr>
                                <tr>
                                    <td width="9%" nowrap align="right">详细经历：</td>
                                    <td colspan="3">
                                        <textarea name="content" cols="100" readonly="readonly" rows="6">${sessionScope.resume.content}</textarea>
                                    </td>
                                </tr>

                                <table align="center">
                                    <TR>
                                        <TD colspan="1" align="center" height="50px">
                                            <a href="updateResume.jsp">修改简历</a>
                                        </TD>
                                    </TR>
                                </table>


                            </table>
                        </fieldset>
                    </td>
                </c:if>
            </tr>
        </table>

        <table align="center">
            <TR>
                <td align="center">
                    <p >${success}</p>
                    <p >${seedResumefail}</p>
                    <p >${s_confirm}</p>
                    <p >${f_confirm}</p>
                    <p >${createResume}</p>
                    <p >${kk}</p>
                </td>
            </TR>
        </table>

    </table>
</div>
</body>
</html>
