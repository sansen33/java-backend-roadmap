# Week 8 / Day 7 — 下单一致性复盘

> 建议用时：60 分钟  
> 今日目标：交付下单链路的索引、事务和并发设计。

## 1. 闭卷作业

写出订单查询索引、下单事务、条件扣库存 SQL 与死锁处理策略。

## 2. 今日验收标准

- [ ] 索引服务明确 SQL。
- [ ] 核心写操作在同一事务。
- [ ] 库存不会为负。
- [ ] 失败不创建已支付订单。

提交：`git commit -m "complete week 8 transaction"`。

下一节：**Week 9 / Day 1 — Bean 与 IOC。**

---

<!-- daily-navigation -->
[下一天](../week09/day01-bean-ioc.md)
