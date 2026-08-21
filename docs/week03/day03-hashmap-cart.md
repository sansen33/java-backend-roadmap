# Week 3 / Day 3 — `HashMap`

> 建议用时：60 分钟  
> 今日目标：用 Map 建立商品索引和购物车聚合。

## 1. 今天学什么

1. key/value
2. `put`、`get`、`containsKey`
3. `getOrDefault`
4. `merge` 与 `computeIfAbsent`

## 2. 核心示例

```java
Map<Long, Integer> quantities = new HashMap<>();
quantities.merge(productId, quantity, Integer::sum);
```

`get` 返回 `null` 可能表示 key 不存在，也可能是 value 为 null；需要区分时使用 `containsKey`。

## 3. 今天的 60 分钟安排

先实现 ID 到商品的索引，再实现同商品数量合并。

# 4. Day 3 作业

实现 `Cart`：`add(productId, quantity)`、`remove(productId)`、`totalQuantity()`。非法数量和不存在商品必须明确失败。

## 今日验收标准

- 为什么 Map 查询通常比遍历列表直接？
- `merge` 解决了什么问题？
- key 使用什么类型更稳定？

下一节：**Week 3 / Day 4 — Queue、Deque 与栈。**

---

<!-- daily-navigation -->
[下一天](../week03/day04-queue-deque-stack.md)
