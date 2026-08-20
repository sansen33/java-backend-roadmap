# Week 6 / Day 6 — Mockito

> 建议用时：60 分钟  
> 今日目标：隔离外部协作者，测试 Service 的业务行为。

## 1. 今天学什么

1. mock
2. stub
3. verify
4. 异常 stub
5. 不该 mock 的对象

## 2. 核心示例

```java
when(gateway.pay(any())).thenReturn(false);
boolean result = service.pay(order);
verify(gateway, times(1)).pay(any());
```

## 3. 今天的 60 分钟安排

模拟支付成功、支付失败和抛异常三种场景。

# 4. Day 6 作业

验证库存不足时不调用支付网关，支付失败时订单状态不变。

## 今日验收标准

- 为什么不 mock 值对象？
- verify 验证的是行为还是实现细节？
- 测试是否脱离网络和数据库？

下一节：**Week 6 / Day 7 — Service 测试复盘。**
