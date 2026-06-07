<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Car" %>
<% List<Car> cars = (List<Car>) request.getAttribute("cars"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/layui/2.5.7/css/layui.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/layui/2.5.7/layui.all.js"></script>
<style>
    body {
        margin: 20px;
    }
    h1{
        text-align: center;
    }
    h2 {
        text-align: center;
    }
    .q {
        margin-bottom: 10px;
        width: 100%;
    }
    .Fei{
    	margin-bottom: 10px;
    	width: 15%
    }
    .K{
    	margin-bottom: 5px;
    }
</style>
</head>
<body>

<table border="1">
<h1>汽车管理系统</h1>
        <label>搜索汽车:</label>
    <div class="q">
        <input type="text" name="searchBrand" placeholder="请输入查找汽车品牌" class="layui-input">
        </div>
        <button class="layui-btn layui-btn-danger">搜索</button>
        <button class="layui-btn layui-btn-normal">刷新</button>
    <h2>添加汽车信息</h2>
    <form action="CarServlet" method="post">
        <input type="hidden" name="action" value="add">
        <div class="q">
            <label>汽车品牌:</label>
            <input type="text" name="carBrand" placeholder="请输入汽车品牌" required class="layui-input">
        </div>
        <div class="q">
            <label>汽车类型:</label>
            <input type="text" name="carType" placeholder="请输入汽车类型" required class="layui-input">
        </div>
        <div class="q">
            <label>汽车价格:</label>
            <input type="number" name="price" placeholder="请输入汽车价格" required class="layui-input">
        </div>
        <div class="Fei">
            <label>创建时间:</label>
            <input type="date" name="carColor" required class="layui-input">
        </div>
        <button type="submit" class="layui-btn">添加</button>
    </form>
</table>
    <h2>汽车信息列表</h2>
    <table class="layui-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>汽车品牌</th>
                <th>汽车类型</th>
                <th>汽车价格</th>
                <th>创建时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Car car : cars) {
            %>
            <tr>
                <td><%= car.getId() %></td>
                <td><%= car.getCarBrand() %></td>
                <td><%= car.getCarType() %></td>
                <td><%= car.getPrice() %></td>
                <td><%= car.getCarColor() %></td>
                <td>
                	<div class="K">
                    <a href="CarServlet?action=edit&id=<%= car.getId() %>">更新信息</a>
                    </div>
                    <a href="CarServlet?action=delete&id=<%= car.getId() %>">删除</a>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    </body>
    </html>