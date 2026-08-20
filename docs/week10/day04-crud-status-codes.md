# Week 10 / Day 4 — CRUD 与状态码

> 建议用时：60 分钟  
> 今日目标：实现符合 HTTP 语义的 User CRUD。

## 1. 今天学什么

1. POST 201
2. PUT/PATCH
3. DELETE 204
4. 404 与 409
5. 幂等语义

## 2. 核心示例

```java
return ResponseEntity.status(HttpStatus.CREATED).body(view);
```

成功删除通常返回 204，无需伪造响应体；重复邮箱可返回 409。

## 3. 今天的 60 分钟安排

完成内存 CRUD，用 curl 验证每种状态码。

# 4. Day 4 作业

实现创建、读取、列表、更新、删除，以及不存在资源和重复邮箱。

## 今日验收标准

- POST 创建为什么是 201？
- DELETE 为什么是 204？
- PUT/PATCH 分别表达什么？

下一节：**Week 10 / Day 5 — 分层与 VO。**
