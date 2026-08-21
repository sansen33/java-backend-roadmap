# Week 4 / Day 5 — `Optional`

> 建议用时：60 分钟  
> 今日目标：明确表达“可能找不到”的查询结果。

## 1. 今天学什么

1. `ofNullable`
2. `map`
3. `filter`
4. `orElseGet`
5. `orElseThrow`

## 2. 核心示例

```java
public Optional<Product> findById(Long id) {
    return products.stream().filter(p -> id.equals(p.getId())).findFirst();
}
```

避免直接调用 `get()`。`orElse` 会立即计算默认值，需要延迟计算时用 `orElseGet`。

## 3. 今天的 60 分钟安排

将按 ID 查找、读取名称、无结果异常串成链路。

# 4. Day 5 作业

实现 `findProductName(Long id)`，未找到时抛出带 ID 的业务异常。

## 今日验收标准

- Optional 适合哪里？
- 为什么不把 Optional 当实体字段？
- `orElse` 与 `orElseGet` 区别？

下一节：**Week 4 / Day 6 — Stream 可读性与边界。**

---

<!-- daily-navigation -->
[下一天](../week04/day06-stream-readability.md)
