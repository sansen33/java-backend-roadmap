# Week 4 / Day 3 — `reduce` 与数值聚合

> 建议用时：60 分钟  
> 今日目标：完成订单数量、总额、最大值等聚合。

## 1. 今天学什么

1. `count`
2. `mapToInt`
3. `sum`
4. `reduce`
5. 空流

## 2. 核心示例

```java
int total = orders.stream()
        .filter(Order::isPaid)
        .mapToInt(Order::getTotalPrice)
        .sum();
```

最大值可能不存在，应返回 `OptionalInt` 或明确默认值。金额精度要求高时不要长期使用 `double`。

## 3. 今天的 60 分钟安排

计算支付订单总额、数量和最高金额。

# 4. Day 3 作业

实现 `calculatePaidTotal`、`findMaxPaidOrder`。空列表不抛出意外异常。

## 今日验收标准

- `reduce` 初始值有什么作用？
- 空流最大值如何表达？
- 为什么金额不能随意使用 double？

下一节：**Week 4 / Day 4 — 分组与分区。**
