# Week 3 / Day 1 — `ArrayList` 与 `LinkedList`

> 建议用时：60 分钟  
> 今日目标：理解 `List` 抽象与两种实现的访问特点。

## 1. 今天学什么

1. `List` 接口
2. `ArrayList` 的动态数组结构
3. `LinkedList` 的节点结构
4. `add`、`get`、`remove`

## 2. 核心示例

```java
List<Product> products = new ArrayList<>();
products.add(product);
Product first = products.get(0);
```

业务代码优先声明接口，默认选择 `ArrayList`。只有访问模式明确需要链表两端操作时才考虑 `LinkedList`。

## 3. 今天的 60 分钟安排

### 0–20 分钟

练习添加、读取、替换和删除商品。

### 20–40 分钟

比较按下标读取和顺序遍历。

### 40–60 分钟

完成作业并测试空列表。

# 4. Day 1 作业

实现 `ProductCatalog` 的 `add`、`findById`、`removeById`，找不到时返回 `false` 或 `null`。

## 今日验收标准

- 为什么字段类型写 `List<Product>`？
- `size()` 与数组 `length` 有什么区别？
- 为什么默认优先 `ArrayList`？

下一节：**Week 3 / Day 2 — `HashSet` 与去重。**

---

<!-- daily-navigation -->
[下一天](../week03/day02-hashset-deduplication.md)
