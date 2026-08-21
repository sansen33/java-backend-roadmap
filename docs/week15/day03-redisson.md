# Week 15 / Day 3 — Redisson

> 建议用时：60 分钟  
> 今日目标：理解 Redisson 锁封装与 watchdog 边界。

## 1. 今天学什么
- RLock、tryLock、watchdog、finally 解锁。

## 2. 实践
为库存操作使用 `tryLock`，超时后明确失败。

# 3. Day 3 作业
编写获取失败、业务异常、正常释放三组测试。

## 4. 今日验收标准
- unlock 放 finally。
- 只释放当前线程持有锁。

下一节：**Week 15 / Day 4 — 幂等。**

---

<!-- daily-navigation -->
[下一天](../week15/day04-idempotency.md)
