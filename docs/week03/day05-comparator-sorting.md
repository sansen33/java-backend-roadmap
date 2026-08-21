# Week 3 / Day 5 — 排序与比较器

> 建议用时：60 分钟  
> 今日目标：编写清晰的单字段和多字段排序规则。

## 1. 今天学什么

1. `Comparable`
2. `Comparator`
3. `Comparator.comparing`
4. 链式排序
5. 源列表是否被修改

## 2. 核心示例

```java
List<Product> sorted = new ArrayList<>(products);
sorted.sort(Comparator.comparing(Product::getPrice)
        .thenComparing(Product::getName));
```

先复制再排序，避免意外改变调用方列表。

## 3. 今天的 60 分钟安排

实现价格升序、库存降序、名称升序三种规则。

# 4. Day 5 作业

实现 `sortProducts(List<Product>)`，返回新列表，null 列表返回空列表。

## 今日验收标准

- `Comparable` 和 `Comparator` 的职责差异？
- 为什么排序前复制列表？
- 同价商品如何保证确定顺序？

下一节：**Week 3 / Day 6 — 并发集合。**

---

<!-- daily-navigation -->
[下一天](../week03/day06-concurrent-map.md)
