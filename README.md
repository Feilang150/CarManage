# CarManage - 汽车管理系统

一个基于 Java Web 的汽车信息管理系统，提供汽车的增删改查功能。

## 技术栈

| 类别 | 技术 |
|------|------|
| 后端 | Java Servlet (Jakarta EE) |
| 前端 | JSP + Layui 2.5.7 |
| 数据库 | MySQL 8.0+ |
| JDBC驱动 | mysql-connector-java 8.0.15 |

## 项目结构

```
CarManage/
├── src/main/
│   ├── java/
│   │   ├── controller/
│   │   │   └── CarServlet.java      # 核心控制器
│   │   ├── dao/
│   │   │   ├── CarDao.java          # 数据访问层
│   │   │   └── DatabaseConnection.java  # 数据库连接
│   │   └── model/
│   │       └── Car.java             # 汽车实体类
│   └── webapp/
│       ├── views/
│       │   ├── listCar.jsp          # 汽车列表页面（主界面）
│       │   ├── addCar.jsp           # 添加汽车页面
│       │   └── editCar.jsp          # 编辑汽车页面
│       ├── resources/
│       │   └── layui/               # Layui 前端框架
│       └── WEB-INF/
│           ├── lib/                 # 依赖库
│           └── web.xml              # Servlet 配置
└── car.sql                          # 数据库初始化脚本
```

## 功能模块

- **汽车列表**：展示所有汽车信息，支持搜索过滤
- **添加汽车**：新增汽车记录（品牌、型号、价格）
- **编辑汽车**：修改现有汽车信息
- **删除汽车**：删除汽车记录

## 环境要求

- JDK 8+
- Tomcat 10+（支持 Jakarta EE 9+）
- MySQL 8.0+

## 使用说明

### 1. 克隆项目

```bash
git clone https://github.com/your-username/CarManage.git
cd CarManage
```

### 2. 数据库配置

1. 登录 MySQL 并执行初始化脚本：

```sql
source /path/to/car.sql
```

或手动执行：

```sql
CREATE DATABASE car;
USE car;
-- 然后执行 car.sql 中的建表和测试数据语句
```

2. 修改数据库连接配置（`src/main/java/dao/DatabaseConnection.java`）：

```java
private static final String URL = "jdbc:mysql://localhost/car";
private static final String USER = "root";
private static final String PASSWORD = "";  // 修改为你的密码
```

### 3. 部署项目

1. 将项目导入 IDE（如 IntelliJ IDEA）
2. 配置 Tomcat 10+ 服务器
3. 启动项目并访问：`http://localhost:8080/carManage/CarServlet?action-index`

## 数据库表结构

| 字段 | 类型 | 说明 |
|------|------|------|
| id | INT | 主键，自增 |
| car_brand | VARCHAR(255) | 汽车品牌 |
| car_type | VARCHAR(255) | 汽车型号 |
| price | INT | 价格 |
| car_color | DATE | 日期 |

## API 路由

| 请求方式 | action参数 | 功能 |
|----------|-----------|------|
| GET | list | 显示汽车列表 |
| GET | edit | 跳转编辑页面 |
| GET | delete | 删除汽车 |
| POST | add | 添加汽车 |
| POST | update | 更新汽车信息 |

## 许可证

[Mozilla Public License 2.0](LICENSE)
