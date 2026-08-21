# Week 15 / Day 2 — 安全释放锁

> 建议用时：60 分钟  
> 今日目标：只释放自己持有的锁。

## 1. 今天学什么
- compare-and-delete、Lua 脚本、锁过期。

## 2. 实践
比较唯一 value 后删除锁，整个操作由 Lua 原子执行。

# 3. Day 2 作业
模拟锁过期并被另一请求取得。

## 4. 今日验收标准
- 不删除别人的锁。
- 锁 TTL 有业务依据。

下一节：**Week 15 / Day 3 — Redisson。**

---

<!-- daily-navigation -->
[下一天](../week15/day03-redisson.md)
