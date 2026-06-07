<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Car" %>
<% Car car = (Car) request.getAttribute("car"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    h1{
        text-align: center;
    }
    .A{
    	margin-bottom: 40px;
    }
    .p{
    	margin-bottom: 10px;
    }
    .E{
    	text-align: center;
    }
</style>
</head>
<body>
<h1>修改汽车信息</h1>
<div class="E">
<div class="A">
<form action="CarServlet" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= car.getId() %>">
    </div>
    <div class="p">
    <label>汽车品牌:</label>
    <input type="text" name="carBrand" value="<%= car.getCarBrand() %>" required><br>
    </div>
    <div class="p">
    <label>汽车类型:</label>
    <input type="text" name="carType" value="<%= car.getCarType() %>" required><br>
    </div>
    <div class="p">
    <label>汽车价格:</label>
    <input type="number" name="price" value="<%= car.getPrice() %>" required><br>
    </div>
    <div class="p">
    <label>创建时间:</label>
    <input type="date" name="carColor" value="<%= car.getCarColor() %>" required><br>
    </div>
    <input type="submit" value="更新汽车">
</form>
<a href="CarServlet?action=list">返回汽车管理系统</a>
</div>
</body>
</html>
