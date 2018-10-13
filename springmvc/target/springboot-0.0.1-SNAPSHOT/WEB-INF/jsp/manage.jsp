<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <title>用户管理</title>
</head>
<body>
<div class="container" style="align:center;width: 800px">
    <div>
        <div class="page-header text-center text-primary">
            <h1><b>用户管理</b></h1>
        </div>
    </div>
    <a href="/add_user.jsp" style="margin-bottom: 10px;" class="btn btn-info">新增用户</a>

    <div class="form-group">
        <table class="table table-bordered table-responsive col-md-12">
            <thead>
            <tr class="danger">
                <th>用户ID</th>
                <th>用户名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>是否可用</th>
                <th>修改</th>
                <th>删除</th>
                <th>详情</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.users}" var="u">
                <tr class="success">
                    <td>${u.user_id}</td>
                    <td>${u.user_name}</td>
                    <td>${u.sex}</td>
                    <td>${u.age}</td>
                    <td>${u.is_useable}</td>
                    <td><a href="/modify.jsp?user_id=${u.user_id}" class="text-info"><span
                            class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href="/user/del?user_id=${u.user_id}" class="text-danger" data-toggle="modal"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
                    <td><a href="/user/show?user_id=${u.user_id}" class="text-info"><span
                            class="glyphicon glyphicon-link"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
