# Week 10 / Day 5 — Service、Repository 与 VO

> 建议用时：60 分钟  
> 今日目标：将 HTTP、业务规则和存储实现分层。

## 1. 今天学什么

1. Controller 边界
2. Service 规则
3. Repository 接口
4. Response VO
5. 敏感字段保护

## 2. 分层规则

```text
Controller  请求/响应映射
Service     邮箱唯一性等规则
Repository  用户存储
UserView    公开返回字段
```

Controller 不直接访问 Map，密码和内部标记绝不进入 `UserView`。

## 3. 今天的 60 分钟安排

将 Map 迁移到 Repository；将实体转换为 UserView。

# 4. Day 5 作业

实现内存 UserRepository，并确保 API 响应没有密码字段。

## 今日验收标准

- Controller 为什么不直接操作 Map？
- VO 与实体区别？
- 何处检查邮箱唯一性？

下一节：**Week 10 / Day 6 — 验证与错误响应。**
