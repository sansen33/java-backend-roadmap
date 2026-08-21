# Week 8 / Day 2 — 联合索引

> 建议用时：60 分钟  
> 今日目标：根据查询模式设计联合索引列顺序。

## 1. 今天学什么

1. 最左前缀
2. 等值与范围条件
3. 排序利用索引
4. 索引列顺序

## 2. 核心示例

对于用户订单列表：

```sql
WHERE user_id = ? AND status = ? ORDER BY created_at DESC
```

考虑 `(user_id, status, created_at)`；是否最佳必须以真实查询和 EXPLAIN 验证。

## 3. 今天的 60 分钟安排

测试只按 user_id、user_id+status、只按 status 的查询计划。

# 4. Day 2 作业

写三条订单查询，为每条标记能否利用联合索引。

## 今日验收标准

- 什么是最左前缀？
- 范围条件为何影响后续列？
- 联合索引能否等价三个单列索引？

下一节：**Week 8 / Day 3 — EXPLAIN。**

---

<!-- daily-navigation -->
[下一天](../week08/day03-explain.md)
