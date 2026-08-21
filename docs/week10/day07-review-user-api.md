# Week 10 / Day 7 — User API 闭卷验收

> 建议用时：60 分钟  
> 今日目标：通过真实 HTTP 请求验收 User CRUD API。

## 1. 闭卷作业

实现并运行创建、查询、列表、更新、删除；验证 404、非法 JSON、重复邮箱。

## 2. curl 验收

```bash
curl -i -X POST http://localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Tom","email":"tom@example.com"}'
```

记录每个场景的状态码和响应体。

## 3. 今日验收标准

- [ ] 路由和状态码一致。
- [ ] Controller/Service/Repository 分层明确。
- [ ] 错误均经过真实 HTTP 验证。
- [ ] 响应不含敏感字段。

提交：

```bash
git add .
git commit -m "complete week 10 rest api"
```

下一节：**Week 11 — MyBatis。**

---

<!-- daily-navigation -->
[下一天](../week11/day01-mybatis-mapper.md)
