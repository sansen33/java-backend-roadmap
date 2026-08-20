# Week 9 / Day 3 — 分层组件

> 建议用时：60 分钟  
> 今日目标：明确 Controller、Service、Repository 的职责边界。

## 1. 今天学什么

1. `@Controller`
2. `@Service`
3. `@Repository`
4. 依赖方向

## 2. 职责边界

```text
Controller  HTTP 映射
Service     业务规则与事务边界
Repository  数据存取
```

Controller 不写 SQL；Repository 不返回 HTTP 状态码。

## 3. 今天的 60 分钟安排

拆分一个用户查询流程，分别测试每层输入输出。

# 4. Day 3 作业

实现 `UserController -> UserService -> UserRepository` 查询链路。

## 今日验收标准

- Controller 为什么不直接操作 Map/SQL？
- Service 的核心职责？
- Repository 为什么不暴露 HTTP？

下一节：**Week 9 / Day 4 — Configuration 与 Bean。**
