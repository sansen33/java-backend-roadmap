# Week 18 / Day 1 — 消息模型

> 建议用时：60 分钟  
> 今日目标：理解 Producer、Broker、Consumer 的职责。

## 1. 今天学什么
- Queue/Topic、消息体、业务 ID、事件版本。

## 2. 练习
定义 `OrderCreated` 事件，包含 orderId、occurredAt、schemaVersion。

# 3. Day 1 作业
设计消息 schema，禁止包含密码或支付凭证。

## 今日验收标准
- 消息有唯一业务标识。
- 消费者可忽略未知扩展字段。

下一节：**Week 18 / Day 2 — Producer。**

---

<!-- daily-navigation -->
[下一天](../week18/day02-producer.md)
