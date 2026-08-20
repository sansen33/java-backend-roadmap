# Week 2 / Day 1 — 封装与对象不变量

> 建议用时：60 分钟  
> 今日目标：用构造器和业务方法保护对象状态，避免外部直接制造非法订单。

## 1. 今天学什么

1. `private` 字段与封装
2. 构造器校验
3. getter 与业务方法
4. 对象不变量
5. 非法状态转换

---

## 2. 为什么不能公开 setter

```java
public class Order {
    private OrderStatus status = OrderStatus.CREATED;

    public boolean pay() {
        if (status != OrderStatus.CREATED) return false;
        status = OrderStatus.PAID;
        return true;
    }
}
```

`setStatus(PAID)` 会绕过金额、库存和重复支付校验。公开方法应该表达业务意图，而不是暴露字段修改能力。

## 3. 构造器保证初始合法

```java
public Order(Long id, int quantity, int totalPrice) {
    if (id == null || quantity <= 0 || totalPrice < 0) {
        throw new IllegalArgumentException("invalid order");
    }
    this.id = id;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
}
```

创建成功后，订单至少满足：ID 存在、数量为正、金额非负。

## 4. 状态转换

```text
CREATED -> PAID -> REFUNDED
CREATED -> CANCELLED
```

每条转换都必须检查当前状态。失败时不能修改任何字段。

---

## 5. 今天的 60 分钟安排

### 0–20 分钟

定义 `OrderStatus` 和 `Order`，完成字段、构造器、getter。

### 20–40 分钟

实现 `pay()`、`cancel()`、`refund()`，测试所有合法和非法转换。

### 40–60 分钟

完成作业并解释为什么不提供 `setStatus()`。

# 6. Day 1 作业

实现订单状态模型：

```java
boolean pay()
boolean cancel()
boolean refund()
```

要求：重复支付、已取消支付、未支付退款均返回 `false`，状态保持不变。

## 今日验收标准

- 为什么字段要 `private`？
- 什么是不变量？
- 为什么失败操作不能先改状态再返回 `false`？
- 能否画出完整状态转换图？

下一节：**Week 2 / Day 2 — 继承与方法覆写。**
