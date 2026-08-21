# Week 2 / Day 4 — 接口与依赖倒置

> 建议用时：60 分钟  
> 今日目标：定义支付能力接口，让订单服务不依赖具体支付 SDK。

## 1. 今天学什么

1. `interface`
2. 实现类
3. 构造器注入
4. 依赖倒置
5. 可替换测试实现

## 2. 支付策略

```java
public interface PaymentStrategy {
    boolean pay(PaymentRequest request);
}
```

```java
public class OrderService {
    private final PaymentStrategy paymentStrategy;

    public OrderService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
```

服务依赖抽象，不知道支付宝或微信的 SDK 细节。

## 3. 为什么不用类型分支

```java
if (type.equals("ALIPAY")) { ... }
else if (type.equals("WECHAT")) { ... }
```

每新增渠道都要修改旧代码。策略对象把变化隔离在实现类中。

## 4. 今天的 60 分钟安排

### 0–20 分钟

定义 `PaymentRequest` 和 `PaymentStrategy`。

### 20–40 分钟

实现支付宝、微信和测试支付。

### 40–60 分钟

注入测试支付并验证订单状态。

# 5. Day 4 作业

实现 `OrderService.pay(Order order)`：金额非法不调用渠道，支付失败不改变订单状态，成功才标记已支付。

## 今日验收标准

- 为什么接口能降低耦合？
- 如何在测试中替换真实支付？
- 新增渠道是否需要修改 `OrderService`？

下一节：**Week 2 / Day 5 — 抽象类与组合。**

---

<!-- daily-navigation -->
[下一天](../week02/day05-abstract-class-composition.md)
