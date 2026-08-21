# Week 3 / Day 2 — `HashSet` 与去重

> 建议用时：60 分钟  
> 今日目标：理解 Set 的唯一性以及 `equals/hashCode` 对去重的影响。

## 1. 今天学什么

1. `HashSet` 的唯一元素
2. 值对象相等性
3. 请求幂等 ID
4. `contains` 与 `add` 返回值

## 2. 核心示例

```java
Set<Long> processed = new HashSet<>();
if (!processed.add(requestId)) {
    return false; // 重复请求
}
```

对象放入 Set 后，参与 hash 的字段不应再改变。

## 3. 今天的 60 分钟安排

实现 `ProductTag`，测试相同名称的两个对象；再实现订单请求去重。

# 4. Day 2 作业

实现 `processOnce(Long requestId)`，`null` 请求拒绝，重复 ID 不重复执行购物车累加。

## 今日验收标准

- `equals` 和 `hashCode` 为什么必须同时实现？
- Set 去重与接口幂等有什么不同？
- 可变对象作为 Set 元素有什么风险？

下一节：**Week 3 / Day 3 — `HashMap`。**

---

<!-- daily-navigation -->
[下一天](../week03/day03-hashmap-cart.md)
