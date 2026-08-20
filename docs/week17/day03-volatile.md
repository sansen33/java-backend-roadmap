# Week 17 / Day 3 — `volatile`

> 建议用时：60 分钟  
> 今日目标：区分可见性与原子性。

## 1. 今天学什么
- 内存可见性、停止标志、重排序概览。

## 2. 练习
使用 `volatile boolean running` 停止工作线程；对比普通字段。

# 3. Day 3 作业
写出为何 `volatile int count; count++` 仍不安全。

## 今日验收标准
- volatile 不提供复合操作原子性。
- 停止线程不依赖忙等无限循环。

下一节：**Week 17 / Day 4 — CAS 与 Atomic。**
