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
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function() {
            var count1=0;
            var count2=0;
            var count3=0;
            $("#uname").blur(function () {
                var uname = $("#uname").val();
                if(uname.length==0){
                    $("#span").html("用户名不能为空");
                    count1++;
                }
            });
            $("#upasswd").blur(function () {
                var upasswd=$("#upasswd").val();
                if(upasswd.length==0){
                    $("#span1").html("密码不能为空");
                    count2++;
                }else {
                    $("#span1").html("");
                    count2=0;
                }
            });
            $("#upasswd1").blur(function () {
                var upasswd=$("#upasswd").val();
                var upasswd1=$("#upasswd1").val();
                if(upasswd!=upasswd1){
                    $("#span2").html("密码不一致");
                    count3++;
                }else {
                    $("#span2").html("");
                    count3=0;
                }
            });

            $("#btn").click(function(){
                $("uname").blur();
                $("#upasswd").blur();
                $("#upasswd1").blur();
                if(count1+count2+count3==0){
                    $("#form1").submit();
                }
            });

        });
    </script>
    <style type="text/css">
        #d{
            position: absolute;
            top: 50%;
            left: 50%;
            margin:-150px 0 0 -100px;
            width:200px;
            height:100px;
        }

    </style>
</head>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">
<div id="d">
    <div style="font: 30px '微软雅黑';margin-left: 30px"> 游客注册</div><br>
    <div style="width:250px; height:170px; text-align: left; background-color: #C3E5FE;">
        <form action="/user/register" method="post">
                        用户名：<br/><input type="text" name="uname" id="uname"/><br/>
                        <span style="color: red"id="span"></span><br/>
                        密  码：<br/><input type="password" name="upassword" id="upasswd" /><br/>
                        <span style="color: red" id="span1"></span><br/>
                        确认密码：<br/>
                        <input type="password" name="upasswd1" id="upasswd1"/><br/>
                        <span style="color: red" id="span2"></span><br/>

                        <input type="submit" name="Submit" value="注册">
                        <input type="reset" name="Submit2" value="重置">
            <div style="color: red">${requestScope.str}</div>
        </form>
    </div>
</div>

</body>
</html>
