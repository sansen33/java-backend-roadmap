# Week 17 — Concurrency

> 每天 60 分钟。目标：用正确同步原语保护共享状态，避免靠猜测修复竞态。

## Day 1 — Thread 与共享状态
学习 Thread、Runnable、共享可变状态；练习两个线程递增计数器；验收：能复现丢失更新。

## Day 2 — `synchronized`
学习监视器、互斥、可见性；练习同步库存扣减；验收：锁覆盖同一共享对象。

## Day 3 — `volatile`
学习可见性非原子性；练习停止标志；验收：不使用 volatile 做 `count++`。

## Day 4 — CAS 与 Atomic
学习 CAS、AtomicInteger；练习原子计数；验收：理解 ABA 风险概览。

## Day 5 — Lock 与条件队列
学习 ReentrantLock、tryLock、finally unlock；练习有界队列；验收：锁超时有失败语义。

## Day 6 — 线程池与 CompletableFuture
学习 ExecutorService、队列、拒绝策略、Future；练习异步聚合两个只读查询；验收：不在公共池执行阻塞任务。

## Day 7 — 闭卷复盘
实现并发库存计数和异步订单摘要。
- [ ] 不丢失更新。
- [ ] 不死锁。
- [ ] 线程池可关闭。
- [ ] 异常可观察。
