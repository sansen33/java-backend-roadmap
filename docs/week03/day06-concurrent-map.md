# Week 3 / Day 6 — 并发集合

> 建议用时：60 分钟  
> 今日目标：知道 `ConcurrentHashMap` 能解决什么，不能解决什么。

## 1. 今天学什么

1. 普通 HashMap 的并发风险
2. `ConcurrentHashMap`
3. `compute` 的原子更新
4. 容器线程安全与业务原子性

## 2. 核心示例

```java
ConcurrentHashMap<Long, Integer> stock = new ConcurrentHashMap<>();
stock.compute(productId, (id, old) -> old == null ? 0 : old - quantity);
```

单次 Map 操作安全，不代表“查库存再扣减”整体安全；业务条件必须在同一原子操作或事务中完成。

## 3. 今天的 60 分钟安排

运行多线程计数示例，对比普通 Map 与并发 Map，并记录结果。

# 4. Day 6 作业

实现并发库存计数器，拒绝扣减后库存为负；说明为何还需要锁或数据库条件更新。

## 今日验收标准

- ConcurrentHashMap 保护了什么？
- 竞态条件如何产生？
- 为什么线程安全容器不等于业务线程安全？

下一节：**Week 3 / Day 7 — 内存购物车复盘。**
