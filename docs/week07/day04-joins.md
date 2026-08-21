# Week 7 / Day 4 — JOIN

> 建议用时：60 分钟  
> 今日目标：按正确结果粒度连接用户、订单和明细。

## 1. 今天学什么

1. INNER JOIN
2. LEFT JOIN
3. ON 与 WHERE
4. 一对多重复行

## 2. 核心示例

```sql
SELECT o.id, u.email
FROM orders o
JOIN user u ON u.id = o.user_id;
```

订单连接多个明细后会出现多行，这是关系本身，不应盲目用 DISTINCT 隐藏。

## 3. 今天的 60 分钟安排

分别写订单详情和订单汇总查询，观察行数。

# 4. Day 4 作业

查询订单用户信息、订单项商品快照和无订单用户。

## 今日验收标准

- INNER/LEFT JOIN 区别？
- 连接粒度是什么？
- 条件放 ON 与 WHERE 有何影响？

下一节：**Week 7 / Day 5 — 聚合。**

---

<!-- daily-navigation -->
[下一天](../week07/day05-group-by-aggregation.md)
