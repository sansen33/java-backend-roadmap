# Week 4 / Day 4 — 分组与分区

> 建议用时：60 分钟  
> 今日目标：按用户、状态和条件生成统计 Map。

## 1. 今天学什么

1. `groupingBy`
2. `partitioningBy`
3. 下游收集器
4. `summingInt`

## 2. 核心示例

```java
Map<OrderStatus, List<Order>> byStatus = orders.stream()
        .collect(Collectors.groupingBy(Order::getStatus));
```

`groupingBy` 产生多组；`partitioningBy` 只产生 true/false 两组。

## 3. 今天的 60 分钟安排

按状态分组订单，按可售状态分区商品，再统计每组总额。

# 4. Day 4 作业

实现 `totalByUser(List<Order>)`，只统计已支付订单；没有订单的用户不虚构统计值。

## 今日验收标准

- group 与 partition 有什么差异？
- 下游 `summingInt` 的输入是什么？
- 空组如何处理？

下一节：**Week 4 / Day 5 — Optional。**

---

<!-- daily-navigation -->
[下一天](../week04/day05-optional.md)
