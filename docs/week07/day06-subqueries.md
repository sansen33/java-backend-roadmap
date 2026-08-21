# Week 7 / Day 6 — 子查询与 SQL 复盘

> 建议用时：60 分钟  
> 今日目标：用 EXISTS、IN 和子查询回答反向业务问题。

## 1. 今天学什么

1. EXISTS
2. IN
3. 相关子查询
4. 查询结果验证

## 2. 核心示例

```sql
SELECT u.id, u.email
FROM user u
WHERE NOT EXISTS (
    SELECT 1 FROM orders o WHERE o.user_id = u.id
);
```

EXISTS 关注是否存在匹配行，不需要返回具体列。

## 3. 今天的 60 分钟安排

查询从未下单用户、无明细订单和销量最高商品。

# 4. Day 6 作业

写十条业务 SQL，逐条保存样例输入、结果行数和解释。

## 今日验收标准

- EXISTS 何时优于 IN？
- 如何验证空结果不是 SQL 错误？
- 是否避免 SELECT *？

下一节：**Week 7 / Day 7 — 五表模型复盘。**

---

<!-- daily-navigation -->
[下一天](../week07/day07-review-sql.md)
