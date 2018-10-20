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
    <div align="right">
        <ul>
            <li><a href="${request.pageContext.contextPath}/index.jsp">退出当前用户</a></li>
        </ul>
    </div>
    <div id="nav">
        <ul>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">部门管理</a>
                <ul>
                    <li><a href="${request.pageContext.contextPath}/addDept.jsp">增加部门</a></li>
                    <li><a href="/dept/getAlldept">查看部门</a></li>
                    <li><a href="/dept/getAlldept">删除部门</a></li>
                    <li><a href="/dept/getAlldept">更改部门</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">职位管理</a>
                <ul>
                    <li><a href="/post/lookDept">增加职位</a></li>
                    <li><a href="/post/getAllPost">查看职位</a></li>
                    <li><a href="/post/getAllPost">删除职位</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">员工管理</a>
                <ul>
                    <li><a href="/employee/getEmployee">查看员工</a></li>
                    <li><a href="/employee/getEmployee">开除员工</a></li>
                    <li><a href="/employee/getEmployee">员工调动</a></li>
                    <li><a href="updateInfoEmp.action">员工信息修改</a></li>
                </ul>
            </li>
            <li onmouseover="display(this)" onmouseout="hide(this)">
                <a href="javascript:;">招聘管理</a>
                <ul>
                    <li><a href="${request.pageContext.contextPath}/addRecruit.jsp">增加招聘信息</a></li>
                    <li><a href="/resume/showResume">查看已投简历</a></li>
                    <li><a href="/recruit/showJoinInterview">查看已参加面试</a></li>
                    <li><a href="/recruit/getNormalRecruit">查看招聘信息</a></li>
                </ul>
            </li>
            <%--<li onmouseover="display(this)" onmouseout="hide(this)">--%>
                <%--<a href="javascript:;">培训信息</a>--%>
                <%--<ul>--%>
                    <%--<li><a href="getAllEmployeeAndAddTrain.action">增加培训</a></li>--%>
                    <%--<li><a href="getAllTrain.action">查看培训</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li onmouseover="display(this)" onmouseout="hide(this)">--%>
                <%--<a href="javascript:;">奖惩管理</a>--%>
                <%--<ul>--%>
                    <%--<li><a href="getAllEmployeeAndaddRwandph.action">增加奖惩</a></li>--%>
                    <%--<li><a href="getAllRP.action">查看所有奖惩</a></li>--%>
                    <%--<li><a href="getAllRP.action">修改奖惩</a></li>--%>
                    <%--<li><a href="getAllRP.action">删除奖惩</a></li>--%>

                <%--</ul>--%>
            <%--<li onmouseover="display(this)" onmouseout="hide(this)">--%>
                <%--<a href="javascript:;">薪资管理</a>--%>
                <%--<ul>--%>
                    <%--<li><a href="getAllSAndE.action">发放薪资</a></li>--%>
                    <%--<li><a href="getA">查看薪资</a></li>--%>
                    <%--<li><a href="getDissent.action">查看工资异议</a></li>--%>

                <%--</ul>--%>
            <%--</li>--%>
            <%--<li onmouseover="display(this)" onmouseout="hide(this)">--%>
                <%--<a href="javascript:;">考勤管理</a>--%>
                <%--<ul>--%>
                    <%--<li><a href="getAllCheckon.action">查看考勤</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


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
            ${RwS}
        </td>
</table>
<table class=list  width="40%"  border="0" align="left"
       cellpadding="0" cellspacing="0">
    <tr>
        <td height="30" align="center"  width="300">
            部门名称:
        </td>
    </tr>
    <c:forEach items="${sessionScope.deptList}" var="list1">
        <tr>
            <td>${list1.dname}</td>
        </tr>
    </c:forEach>
</table>
<table class=list width="40%"  border="0" align="right"
       cellpadding="0" cellspacing="0">
    <tr >
        <td height="30" align="center"  width="300">
            职位名称:
        </td>
    </tr>
    <c:forEach items="${sessionScope.postList}" var="list2">
        <tr>
            <td height="30" align="center"  width="300">${list2.pname}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
