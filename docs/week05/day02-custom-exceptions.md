# Week 5 / Day 2 — 捕获、传播与自定义异常

> 建议用时：60 分钟  
> 今日目标：在正确边界处理异常，不制造半完成状态。

## 1. 今天学什么

1. `try/catch/finally`
2. `throw` 与 `throws`
3. 自定义业务异常
4. 异常转换

## 2. 核心示例

```java
try {
    repository.save(order);
} catch (SQLException error) {
    throw new OrderPersistenceException("save order " + order.id(), error);
}
```

保留 cause，禁止只打印后继续执行。

## 3. 今天的 60 分钟安排

实现库存不足异常；测试失败时库存和订单状态都不改变。

# 4. Day 2 作业

实现 `InsufficientStockException` 和 Service 边界转换。

## 今日验收标准

- `throw` 与 `throws` 区别？
- 为什么要保留 cause？
- catch 后继续执行可能造成什么问题？

下一节：**Week 5 / Day 3 — try-with-resources。**
