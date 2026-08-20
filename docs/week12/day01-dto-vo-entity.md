# Week 12 / Day 1 — DTO、VO 与 Entity

> 建议用时：60 分钟  
> 今日目标：隔离请求、持久化和响应模型。

## 1. 今天学什么
- DTO、Entity、VO 的职责边界。

## 2. 实践
为 User 定义 `CreateUserRequest`、`UserEntity`、`UserView`，手工转换。

# 3. Day 1 作业
禁止 Entity 直接作为 HTTP 响应。

## 4. 今日验收标准
- DTO 不暴露数据库字段。
- VO 不返回密码。

下一节：**Week 12 / Day 2 — Validation。**
