<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    h1{
        text-align: center;
    }
    .F{
    	text-align: center;
    }
    .M{
    	margin-bottom: 40px;
    }
    .Z{
    	margin-bottom: 10px;
    }
</style>
<body>
<h1>添加汽车信息</h1>
<div class="F">
<div class="M">
<form action="CarServlet" method="post">
        <input type="hidden" name="action" value="add">
        </div>
        <div class="Z">
            <label>汽车品牌:</label>
            <input type="text" name="carBrand" placeholder="请输入汽车品牌" required class="layui-input">
        </div>
        <div class="Z">
            <label>汽车类型:</label>
            <input type="text" name="carType" placeholder="请输入汽车类型" required class="layui-input">
        </div>
        <div class="Z">
            <label>汽车价格:</label>
            <input type="number" name="price" placeholder="请输入汽车价格" required class="layui-input">
        </div>
        <div class="Z">
            <label>创建时间:</label>
            <input type="date" name="carColor" required class="layui-input">
        </div>
        <button type="submit" class="layui-btn">添加</button>
    </form>
<a href="CarServlet?action=list">返回汽车管理系统</a>
</div>
</body>
</html>