# Week 2 / Day 7 — 支付策略闭卷复盘

> 建议用时：60 分钟  
> 今日目标：不用参考前六天文档，完成可替换支付策略并验证对象契约。

## 1. 闭卷任务

从空文件实现：

```text
Order
PaymentRequest
PaymentStrategy
OrderService
AlipayPayment
MockPayment
```

订单状态至少包括 `CREATED`、`PAID`、`FAILED`。

## 2. 业务规则

1. 金额小于等于零时拒绝支付。
2. 支付渠道返回失败时订单仍不是 `PAID`。
3. 已支付订单不能再次调用渠道。
4. `OrderService` 只依赖 `PaymentStrategy`。
5. 新增支付渠道不修改旧服务。

## 3. 60 分钟安排

### 0–15 分钟

画类图和状态图。

### 15–45 分钟

实现接口、实体、服务和两种策略。

### 45–60 分钟

运行成功、失败、重复支付三组场景并复盘。

## 4. 今日验收标准

- [ ] 能解释接口与实现类的依赖方向。
- [ ] 能解释多态调用。
- [ ] 失败路径没有半完成状态。
- [ ] `equals/hashCode` 对值对象一致。

提交：

```bash
git add .
git commit -m "complete week 2 oop"
```

下一节：**Week 3 / Day 1 — `ArrayList` 与 `LinkedList`。**

---

<!-- daily-navigation -->
[下一天](../week03/day01-arraylist-linkedlist.md)
