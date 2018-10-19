<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/18
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>

</head>
<%--<body class="ContentBody">--%>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<form action="/resume/addResume" method="post" >
    <div class="MainDiv">
        <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
            <tr>
                <th class="tablestyle_title" >新建简历</th>
            </tr>
            <tr>
                <td>

                    <table border="0" cellpadding="0" cellspacing="0" style="width:80%" align="center">
                        <TR>
                            <TD width="100%">
                                <fieldset style="height:100%;">
                                    <legend>个人信息</legend>
                                    <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
                                        <tr>
                                            <td nowrap align="right" width="9%">姓名：</td>
                                            <td width="36%"><input name="name" type="text" >
                                                <span style="color: red">*</span></td>
                                            <td width="12%"><div align="right">性别：</div></td>
                                            <td width="43%">
                                                <input name="sex" type="text" >

                                        </tr>
                                        <tr>
                                            <td nowrap align="right" width="9%">年龄：</td>
                                            <td><input name="age" type="text" ></td>
                                            <td><div align="right">籍贯：</div></td>
                                            <td><input name="job" type="text" >
                                                <span style="color: red">*</span></td>
                                        </tr>
                                        <tr>
                                            <td><div align="right">工作经验：</div></td>
                                            <td><input name="experience" type="text" class="input">
                                                <span style="color: red">*</span></td>
                                            <td nowrap align="right">所学专业：</td>
                                            <td><input name="specialty" type="text" class="input">
                                                <span style="color: red">*</span></td>
                                        </tr>
                                        <tr>
                                            <td><div align="right">毕业学校：</div></td>
                                            <td><input name="school" type="text" class="input">
                                                <span style="color: red">*</span></td>
                                            <td nowrap align="right">学历：</td>
                                            <td>
                                                <select name="studyeffort">
                                                    <option>高中</option>
                                                    <option>大专</option>
                                                    <option>本科</option>
                                                    <option>本科以上</option>
                                                </select>
                                                <span style="color: red">*</span></td>
                                        </tr>
                                        <tr>
                                            <td nowrap align="right">电话：</td>
                                            <td><input name="tel" type="text" class="input">
                                                <span class="red">*</span></td>
                                            <td><div align="right">Email：</div></td>
                                            <td><input name="email" type="text" class="input">
                                                <span class="red">*</span></td>
                                        </tr>
                                        <tr>
                                            <td width="9%" nowrap align="right">详细经历：</td>
                                            <td colspan="3">
					<textarea name="content" cols="100" rows="6" class="input" id="content">
					</textarea></td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </TD>

                        </TR>
                    </TABLE>
                </td>
            </tr>
            <TR>
                <TD colspan="2" align="center" height="50px">
                    <input name="提交" type="submit" class="button" value="保存"/>　
                    <a href="userpage"><input type="button" value="返回"></a>
                </TD>
            </TR>
        </TABLE>
    </div>
</form>

</body>
</html>
