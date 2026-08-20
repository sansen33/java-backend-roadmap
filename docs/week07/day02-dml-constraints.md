# Week 7 / Day 2 — DML 与约束

> 建议用时：60 分钟  
> 今日目标：安全插入、更新和删除业务数据。

## 1. 今天学什么

1. INSERT、UPDATE、DELETE
2. UNIQUE 与外键
3. 影响行数
4. 条件库存更新

## 2. 核心示例

```sql
UPDATE product
SET stock = stock - 2
WHERE id = 1 AND stock >= 2;
```

随后检查 affected rows，不能先查再盲目扣减。

## 3. 今天的 60 分钟安排

插入样例订单；尝试重复邮箱、负库存和无商品外键。

# 4. Day 2 作业

编写安全扣库存 SQL，并验证失败时影响行数为 0。

## 今日验收标准

- 为什么 UPDATE 必须带 WHERE？
- UNIQUE 解决什么问题？
- 影响行数如何表示业务失败？

下一节：**Week 7 / Day 3 — 条件查询。**
