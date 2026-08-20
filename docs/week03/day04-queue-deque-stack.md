# Week 3 / Day 4 — Queue、Deque 与栈

> 建议用时：60 分钟  
> 今日目标：按 FIFO/LIFO 需求选择队列或栈。

## 1. 今天学什么

1. `Queue` 的 FIFO
2. `Deque` 两端操作
3. `offer`、`poll`、`peek`
4. 栈与括号匹配

## 2. 核心示例

```java
Deque<Long> pending = new ArrayDeque<>();
pending.offer(orderId);
Long next = pending.poll();
```

空队列的 `poll` 返回 null；不要用异常作为正常空队列分支。

## 3. 今天的 60 分钟安排

模拟订单排队，再用 `ArrayDeque<Character>` 实现括号匹配。

# 4. Day 4 作业

实现订单处理队列：入队、处理下一单、查看下一单。空队列安全返回。

## 今日验收标准

- 订单处理为什么使用 FIFO？
- 撤销操作为什么适合栈？
- `poll` 与 `remove` 的区别？

下一节：**Week 3 / Day 5 — 排序与比较器。**
