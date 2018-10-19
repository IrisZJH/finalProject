<%--
  Created by IntelliJ IDEA.
  User: 18221
  Date: 2018/10/12
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="css/index.css" rel="stylesheet" type="text/css" />--%>
    <style type="text/css">
        #d{
            position: absolute;
            top: 50%;
            left: 50%;
            margin:-150px 0 0 -100px;
            width:200px;
            height:100px;
        }
        html,body {height:100%; margin:0px; font-size:12px;}
    </style>

</head>

<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<div id="d">
    <div style="width:202px; height:30px; background-image:url(${request.pageContext.contextPath}/img/log.jpg)"></div>
    <div style="width:202px; height:135px; text-align: left; background-color: #C3E5FE;">
        <form id="form1" method="post" action="/user/login" style="padding-left: 10px;">
            <br />
            用户：<input type="text" name="uname" style="height: 15px;width: 120px;"  /><br /><br/>
            密码：<input type="password" name="upassword" style="height: 15px;width: 120px;" /><br /><br/>
            类别： <select name="state">
            <option value="0">游客</option>
            <option value="1">员工</option>
            <option value="2">管理员</option>
        </select><br/><br/><br/>
            <div style="color: red">${requestScope.error}</div>
            <div style="color: red">${requestScope.str}</div>
            <br/>
            <center>
                <input type="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset"  value="重置" /><br/>
            </center>
        </form>
        <div style="font-size: 15px;text-align: center;">
            <a href="register.jsp" style="color: #F10301;">【游客注册】</a>
        </div>
        <div style="height: 15px;"></div>
    </div>
</div>

</body>
</html>
