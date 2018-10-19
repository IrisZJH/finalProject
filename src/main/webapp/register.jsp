<%--
  Created by IntelliJ IDEA.
  User: Mbenben
  Date: 2017/4/13
  Time: 3:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                }else{
                    $.post("confirm.action","uname="+uname,function (date){
                        if(date=="ok"){
                            count1=0;
                        }else {
                            count1++;
                        }
                        $("#span").html(date);
                    })
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
        body {
            background-color: #CCD8E5
        }
        span.STYLE9{
            font-weight:bold;
            color:#FCF9C0;
            font-size: 300%
        }
        span.a{
            font-weight:bold;
            color: black;
            font-size: 100%
        }

    </style>
</head>
<body style="background-image:url(${request.pageContext.contextPath}/img/p2.jpg); background-size:100%,100%">

<form action="/user/register" method="post">
    <table width="38%" border="0" align="center" valign="bottom">
        <tr>
            <td width="30%" align="right">
                用户名：
            </td>
            <td width="70%" align="left">
                <input type="text" name="uname" id="uname"/>
                <span class="a" id="span"></span>
            </td>
        </tr>
        <tr>
            <td align="right">
                密  码：
            </td>
            <td>
                <input type="password" name="upassword" id="upasswd" />
                <span class="a" id="span1"></span>
            </td>
        </tr>
        <tr>
            <td align="right">
                密  码：
            </td>
            <td>
                <input type="password" name="upasswd1" id="upasswd1"/>
                <span class="a" id="span2"></span>
            </td>
        </tr>
        <tr align="center" >
            <td colspan="2" style="padding-right:80px" >
                <input type="submit" name="Submit" value="注册">
                <input type="reset" name="Submit2" value="重置">
            </td>
        </tr>
    </table>
    ${sessionScope.error1}
</form>

</body>
</html>
