<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String user_id = request.getParameter("user_id");%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <title>用户信息修改</title>
</head>
<body>
<div class="container" style="align:center;width: 800px">
    <div>
        <div class="page-header text-center text-primary">
            <h1><b>用户信息修改</b></h1>
        </div>
    </div>
    <form role="form" action="/user/modify" class="form-horizontal" method="post" accept-charset="UTF-8"
          onsubmit="document.charset='UTF*'">
        <table class="table table-bordered table-responsive col-md-12">
            <tr class="danger">
                <th style="width: 100px">用户ID</th>
                <th>用户名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>备注</th>
                <th width="150px">是否可用</th>
            </tr>
            </thead>

            <tr class="success">
                <td><input type="text" class="form-control" name="user_id" value="<%=user_id%>" id="11"
                           placeholder="用户名" readonly="true"></td>
                <td><input type="text" class="form-control" name="user_name" value="" id="15" placeholder="用户名">
                <td><input type="text" class="form-control" name="age" value="" id="12" placeholder="年龄"></td>
                <td><input id="man" type="radio" checked="checked" name="sex" value="男"/>男<input id="woman" type="radio" name="sex" value="女"/>女
                </td>
                <td><input type="text" class="form-control" name="remarks" value="" id="13" placeholder="备注"></td>
                <td><input type="radio" name="is_useable" value="true" id="true" placeholder="是否可用">
                    <label for="true">ture</label>
                    <input type="radio" name="is_useable" value="false" id="false" placeholder="是否可用">
                    <label for="false">false</label>
                </td>
            </tr>
        </table>
        <button style="margin-left: 600px;margin-right: 20px" type="submit" class="btn btn-info">提交修改</button>
        <a href="/user/list">返回</a>
    </form>
</div>
</body>
</html>
