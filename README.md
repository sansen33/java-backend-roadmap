# Java Backend Roadmap

面向 **5 年+前端工程师、每天约 1 小时** 的 24 周 Java 后端转型项目。

目标不是“看完 Java 课程”，而是在 24 周内完成一套可以持续演进的后端项目，并形成可用于面试的知识体系。

## 技术基线

- Java 21 LTS
- Spring Boot 4.1.0
- Maven
- JUnit 5
- 后续逐步加入 MySQL、MyBatis、Redis、Spring Security、MQ、Docker、Spring Cloud

## 文档

- [24 周详细学习计划](docs/24-week-plan.md)
- [每日学习内容目录](docs/daily-content.md)
- [阶段验收标准](docs/checkpoints.md)
- [面试题清单](docs/interview-checklist.md)

## 项目演进路线

```text
Week 01-06  Java / Collections / Stream / Maven / Test
      ↓
Week 07-08  MySQL / Index / Transaction
      ↓
Week 09-13  Spring / Spring Boot / MyBatis / Security
      ↓
Week 14-18  Redis / JVM / Concurrency / MQ
      ↓
Week 19-21  Docker / Linux / Spring Cloud
      ↓
Week 22-24  Project Hardening / Interview / Job Search
```

## 当前代码

第一版提供一个内存版 User API，用来建立前端工程师最容易理解的调用链：

```text
Browser / Postman
        ↓
UserController
        ↓
UserService
        ↓
ConcurrentHashMap
```

后续会把 `ConcurrentHashMap` 替换为 MySQL + MyBatis，再逐渐加入缓存、鉴权和微服务。

## 启动

需要：

- JDK 21+
- Maven 3.9+

```bash
mvn spring-boot:run
```

健康检查：

```bash
curl http://localhost:8080/actuator/health
```

创建用户：

```bash
curl -X POST http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Alice","age":28}'
```

查询用户：

```bash
curl http://localhost:8080/api/users
```

运行测试：

```bash
mvn test
```

## 每天 1 小时怎么用

- 20 分钟：读当天知识点
- 30 分钟：写代码或做练习
- 10 分钟：写学习笔记 / 回答复盘问题

原则：**学习内容必须转化成代码提交。**
