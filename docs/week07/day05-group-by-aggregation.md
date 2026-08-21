# Week 7 / Day 5 — 聚合与分组

> 建议用时：60 分钟  
> 今日目标：按用户和商品生成业务统计。

## 1. 今天学什么

1. COUNT、SUM、AVG
2. GROUP BY
3. HAVING
4. NULL 与计数

## 2. 核心示例

```sql
SELECT user_id, COUNT(*) order_count, SUM(total_amount) total
FROM orders
WHERE status = 'PAID'
GROUP BY user_id
HAVING SUM(total_amount) > 1000;
```

WHERE 先过滤行，HAVING 过滤分组结果。

## 3. 今天的 60 分钟安排

统计用户订单数、用户销售额和商品销量。

# 4. Day 5 作业

找出已支付订单金额超过阈值的用户，并解释每个聚合字段。

## 今日验收标准

- COUNT(*) 与 COUNT(column) 区别？
- WHERE 与 HAVING 区别？
- 聚合前后结果粒度如何变化？

下一节：**Week 7 / Day 6 — 子查询。**

---

<!-- daily-navigation -->
[下一天](../week07/day06-subqueries.md)
