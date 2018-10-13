<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <title>用户详情</title>
</head>
<body>
<div class="container" style="align:center;width: 800px">
    <div>
        <div class="page-header text-center text-primary">
            <h1><b>用户信息详情</b></h1>
        </div>
    </div>
    <div class="form-group">
        <table class="table table-bordered table-responsive col-md-12">
            <thead>
            <tr class="danger">
                <th>用户ID</th>
                <th>用户名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>备注</th>
                <th>是否可用</th>
                <th>创建时间</th>
                <th>最后更改时间</th>
            </tr>
            </thead>
            <tr class="success">
                <td>${u.user_id}</td>
                <td>${u.user_name}</td>
                <td>${u.age}</td>
                <td>${u.sex}</td>
                <td>${u.remarks}</td>
                <td>${u.is_useable}</td>
                <td>${u.create_time}</td>
                <td width="100px">${u.last_edit_time}</td>
            </tr>
        </table>
        <a style="margin-right: 60px" href="/user/list">返回</a>
    </div>
</div>
</body>
</html>
