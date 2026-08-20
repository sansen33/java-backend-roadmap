# Week 7 / Day 3 — 条件查询

> 建议用时：60 分钟  
> 今日目标：写出可解释的筛选、排序和分页查询。

## 1. 今天学什么

1. WHERE、IN、LIKE、BETWEEN
2. NULL 判断
3. ORDER BY
4. LIMIT

## 2. 核心示例

```sql
SELECT id, name, price
FROM product
WHERE stock > 0
ORDER BY price ASC, id ASC
LIMIT 20;
```

NULL 使用 `IS NULL`，不能写 `= NULL`。分页需要稳定排序。

## 3. 今天的 60 分钟安排

查询可售商品、用户最近订单和价格区间商品。

# 4. Day 3 作业

写三条查询并用样例数据验证空结果和多页结果。

## 今日验收标准

- 为什么分页要次排序键？
- `LIKE` 的索引风险是什么？
- `IS NULL` 与 `= NULL` 区别？

下一节：**Week 7 / Day 4 — JOIN。**
