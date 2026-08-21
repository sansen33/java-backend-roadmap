# Week 17 / Day 5 — Lock 与条件队列

> 建议用时：60 分钟  
> 今日目标：用 ReentrantLock 实现可超时互斥。

## 1. 今天学什么
- `tryLock`、`finally`、Condition、锁超时。

## 2. 练习
实现有界任务队列；获取不到锁时返回明确失败。

# 3. Day 5 作业
验证业务异常时锁仍被释放。

## 今日验收标准
- unlock 位于 finally。
- 不无限等待锁。

下一节：**Week 17 / Day 6 — 线程池与 CompletableFuture。**

---

<!-- daily-navigation -->
[下一天](../week17/day06-thread-pool-future.md)
