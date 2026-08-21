# Week 15 / Day 1 — SET NX 与分布式锁

> 建议用时：60 分钟  
> 今日目标：理解“只在不存在时设置”的互斥语义。

## 1. 今天学什么
- SET NX EX、锁 value、过期时间。

## 2. 实践
用唯一 requestId 作为 lock value，设置有限 TTL。

# 3. Day 1 作业
实现获取锁失败即返回的接口。

## 4. 今日验收标准
- 加锁与过期原子。
- 不使用固定 value 解锁。

下一节：**Week 15 / Day 2 — 安全释放锁。**

---

<!-- daily-navigation -->
[下一天](../week15/day02-safe-unlock.md)
