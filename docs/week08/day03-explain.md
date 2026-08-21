# Week 8 / Day 3 — EXPLAIN

> 建议用时：60 分钟  
> 今日目标：用执行计划而不是猜测评估查询。

## 1. 今天学什么

1. `type`
2. `possible_keys` 与 `key`
3. `rows`
4. `Extra`
5. 计划与数据量

## 2. 核心示例

```sql
EXPLAIN SELECT id, name FROM product WHERE status = 'ON_SALE';
```

关注使用哪个索引、估算扫描行数和是否需要额外排序；不要仅凭一项指标判断好坏。

## 3. 今天的 60 分钟安排

对有无索引、覆盖索引和排序查询分别 EXPLAIN。

# 4. Day 3 作业

保存三份执行计划并写下基于证据的优化建议。

## 今日验收标准

- `key` 表示什么？
- `rows` 是否精确实际行数？
- 全表扫描一定错误吗？

下一节：**Week 8 / Day 4 — 事务与 ACID。**

---

<!-- daily-navigation -->
[下一天](../week08/day04-transactions-acid.md)
