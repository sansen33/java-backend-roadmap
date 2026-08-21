# Week 4 / Day 2 — `filter`、`map`、`collect`

> 建议用时：60 分钟  
> 今日目标：用 Stream 完成集合筛选和类型转换。

## 1. 今天学什么

1. Stream 流水线
2. `filter`
3. `map`
4. `collect(toList())`
5. 惰性执行

## 2. 核心示例

```java
List<String> names = products.stream()
        .filter(Product::isAvailable)
        .map(Product::getName)
        .toList();
```

中间操作不会立即执行，terminal operation 才触发流水线。`filter` 保持元素类型，`map` 可以转换类型。

## 3. 今天的 60 分钟安排

### 0–20 分钟

从商品列表获取可售商品。

### 20–40 分钟

将商品转换为 `ProductView`。

### 40–60 分钟

完成作业并处理空列表。

# 4. Day 2 作业

筛选已支付订单，映射为 `OrderSummary`，收集为新列表。源列表不得改变。

## 今日验收标准

- 为什么没有 terminal operation 时流不执行？
- `filter` 与 `map` 的返回类型区别？
- 空列表结果是什么？

下一节：**Week 4 / Day 3 — 聚合。**

---

<!-- daily-navigation -->
[下一天](../week04/day03-reduce-aggregation.md)
