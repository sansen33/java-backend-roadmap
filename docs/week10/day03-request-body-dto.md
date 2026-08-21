# Week 10 / Day 3 — 请求绑定与 DTO

> 建议用时：60 分钟  
> 今日目标：接收 JSON 请求并隔离 API 输入模型。

## 1. 今天学什么

1. `@RequestBody`
2. DTO
3. JSON 绑定
4. 客户端错误

## 2. 核心示例

```java
public record CreateUserRequest(String name, String email) {}

@PostMapping("/users")
ResponseEntity<UserView> create(@RequestBody CreateUserRequest request) {}
```

请求 DTO 不应复用数据库实体，避免客户端控制内部字段。

## 3. 今天的 60 分钟安排

发送合法、缺字段和无效 JSON 请求，记录响应。

# 4. Day 3 作业

实现创建用户请求 DTO，姓名为空和邮箱格式错误返回 4xx。

## 今日验收标准

- DTO 解决什么边界问题？
- 无效 JSON 如何处理？
- 为什么不能暴露实体？

下一节：**Week 10 / Day 4 — CRUD 与状态码。**

---

<!-- daily-navigation -->
[下一天](../week10/day04-crud-status-codes.md)
