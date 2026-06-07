# 创建数据库
CREATE DATABASE `car`;
USE `car`;
# 创建汽车表
CREATE TABLE car (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    car_brand VARCHAR(255) NOT NULL COMMENT '汽车品牌',
    car_type VARCHAR(255) NOT NULL COMMENT '汽车型号',
    price INT NOT NULL COMMENT '价格',
    car_color DATE NOT NULL COMMENT '颜色'
);
# 添加测试数据
INSERT INTO car (car_brand, car_type, price, car_color) VALUES
('大众', 'Sedan', 200000, '2023-01-01'),
('东风', 'Coupe', 220000, '2022-05-15'),
('凯迪拉克', 'SUV', 300000, '2021-09-30'),
('宝马', 'Truck', 270000, '2020-12-12'),
('宝骏', 'Electric', 500000, '2023-10-01');