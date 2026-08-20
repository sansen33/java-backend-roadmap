# Week 10 — Spring Boot、MVC 与 REST

> 主线项目：User CRUD API。每天用 curl 或 HTTP 客户端验证真实请求，而非只看编译结果。

## Day 1 — Boot 启动与自动配置

### 学习
- `@SpringBootApplication`、starter、自动配置条件。
- 启动日志、端口和健康检查。

### 练习
启动最小 Web 应用，实现 `GET /hello`；记录启动失败的配置原因。

### 验收
服务可启动、可停止，端口来自配置而非代码硬编码。

## Day 2 — Controller 与路由

### 学习
- `@RestController`、`@RequestMapping`、GET/POST。
- 路径变量和查询参数的语义。

### 练习
实现 `GET /users/{id}`、`GET /users?name=`，覆盖找到和找不到。

### 验收
资源路径用名词；不存在返回 404 而非 200 空字符串。

## Day 3 — 请求 DTO 与绑定

### 学习
- `@PathVariable`、`@RequestParam`、`@RequestBody`。
- 请求 DTO 不直接复用实体；JSON 字段绑定。

### 练习
实现 `POST /users`，测试合法 JSON、缺字段、错误 JSON。

### 验收
客户端错误返回 4xx；响应不泄露内部字段。

## Day 4 — CRUD 与状态码

### 学习
- POST 201、PUT/PATCH、DELETE 204、404、409。
- 更新不存在资源与重复邮箱的语义。

### 练习
完成 User 内存 CRUD，使用 Repository 接口隔离存储。

### 验收
使用 curl 验证每个状态码；DELETE 成功不伪造响应体。

## Day 5 — 分层与 VO

### 学习
- Controller 做 HTTP 映射，Service 做业务规则，Repository 做存储。
- Response VO 只返回公开字段。

### 练习
将密码、内部状态排除；Service 返回 VO 或转换对象。

### 验收
Controller 不直接操作 Map；响应契约稳定。

## Day 6 — 错误基线与验证

### 学习
- 统一错误结构、错误码、关联 ID、日志边界。
- 手工验证先建立基线，第 12 周再系统化 Bean Validation。

### 练习
校验姓名非空、邮箱格式、重复邮箱；返回可定位错误。

### 验收
不返回堆栈；服务端日志有足够上下文但不包含敏感信息。

## Day 7 — 闭卷 HTTP 验收

用 curl 完成创建、查询、列表、更新、删除，并验证 404、非法 JSON、重复邮箱。

### 必须覆盖
- [ ] 路由、状态码和 JSON 语义一致。
- [ ] Controller/Service/Repository 分层明确。
- [ ] 所有错误通过实际 HTTP 请求确认。
- [ ] 响应不含密码等敏感字段。

提交：`git commit -m "complete week 10 rest api"`。
