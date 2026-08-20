# Week 17 / Day 4 — CAS 与 Atomic

> 建议用时：60 分钟  
> 今日目标：用原子类型实现无锁计数。

## 1. 今天学什么
- CAS、`AtomicInteger`、失败重试、ABA 概览。

## 2. 练习
用 `incrementAndGet` 替换共享 `count++`。

# 3. Day 4 作业
实现原子成功订单计数器并并发验证。

## 今日验收标准
- 不手写忙等 CAS。
- 知道 Atomic 只保护单一原子状态。

下一节：**Week 17 / Day 5 — Lock。**
