# Week 10 / Day 2 — Controller 与路由

> 建议用时：60 分钟  
> 今日目标：定义一致的资源路径和 HTTP 方法。

## 1. 今天学什么

1. `@RestController`
2. `@RequestMapping`
3. `@GetMapping`
4. 路径变量
5. 查询参数

## 2. 核心示例

```java
@GetMapping("/users/{id}")
UserView find(@PathVariable Long id) {}
```

资源路径使用名词复数；读取用 GET。找不到资源必须有明确 404 语义。

## 3. 今天的 60 分钟安排

实现按 ID 查询和按名称筛选，分别用 curl 测试。

# 4. Day 2 作业

实现 `GET /users/{id}` 与 `GET /users?name=`，覆盖成功和 404。

## 今日验收标准

- PathVariable 与 RequestParam 区别？
- 为什么路径是名词？
- 找不到为什么不是 200？

下一节：**Week 10 / Day 3 — 请求绑定与 DTO。**

---

<!-- daily-navigation -->
[下一天](../week10/day03-request-body-dto.md)
