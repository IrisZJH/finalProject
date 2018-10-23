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
    <style>
        *{margin:0;padding:0;}
        a{text-decoration:none;color:#666;}
        body{font-family:Verdana,SimSun;font-size:17px;color:#666;text-align:center;background:#EEE; background-image: url("images/beijin.jpg");background-size:100%;}
        li{list-style:none;}
        #box{width:982px;margin:35px auto 55PX auto;text-align:center;background:dodgerblue;}
        #nav{width:720px;height:30px;margin:-15px auto;line-height:30px;}
        #nav a{display:block;width:90px;height:30px;text-align:center;color:#FFF;}
        #nav li{float:left;}
        #nav li ul{width:130px;display:none;position:absolute;margin-left:-20px;}
        #nav li ul li{clear:both;}
        #nav li ul a{width:130px;border-top:1px solid #FFF;text-align:center;background:dodgerblue;-webkit-transition:all 0.5s ease;-moz-transition:all 0.5s ease;transition:all 0.5s ease;}
        #nav li ul li a:hover{background:#FFF;color:dodgerblue;}
        a{display:block;width:104px;height:34px;text-align:center;color:#FFF;}
    </style>
    <script >
        /*-----显示子菜单-----*/
        function display(li) {
            var subNav = li.getElementsByTagName("ul")[0];
            subNav.style.display = "block";
        }

        /*-----隐藏子菜单-----*/
        function hide(li) {
            var subNav = li.getElementsByTagName("ul")[0];
            subNav.style.display = "none";
        }
    </script>
    <style type="text/css">

        .list{
            font-size: 15px;
            color: brown;
        }

    </style>
</head>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<div id="box">
    <div id="nav">
        <ul>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">个人信息</a>
                <ul>
                    <li><a href="showOwnInfo.jsp"><span>查看个人信息</span></a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">培训管理</a>
                <ul>
                    <li><a href="getTrainFromEmp.action">查看培训</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">薪资管理</a>
                <ul>
                    <li><a href="getEmployeeSalary.action">查看我的薪资</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">考勤管理</a>
                <ul>
                    <li><a href="showEmpC.action">查看我的考勤记录</a></li>
                </ul>
            </li>
            <li><a href="#">公司</a></li>
            <li><a href="#">公司信息</a></li>
            <li><a href="login.jsp">退出当前用户</a></li>
        </ul>
    </div>

</div>
<table  align="center">
    <tr align="center" >
        <td bgcolor="yellow" align="center">
            ${error}
            ${Finform}
            ${Tinform}
            ${same}
        </td>
</table>
<table class=list  width="40%"  border="0" align="left"
       cellpadding="0" cellspacing="0">
    <tr>
        <td height="30" align="center"  width="300">
            <a href="addCheckon.action">上班签到</a>
        </td>
    </tr>

</table>
<table class=list width="40%"  border="0" align="right"
       cellpadding="0" cellspacing="0">
    <tr >
        <td height="30" align="center"  width="300">
            <a href="updateCheckon.action" >下班签到</a>
        </td>
    </tr>

</table>
</body>
</html>
