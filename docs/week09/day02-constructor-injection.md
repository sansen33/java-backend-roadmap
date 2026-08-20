# Week 9 / Day 2 — 构造器注入

> 建议用时：60 分钟  
> 今日目标：使 Service 依赖显式、必需且易于测试。

## 1. 今天学什么

1. 构造器注入
2. 接口依赖
3. 单一构造器
4. 测试替换

## 2. 核心示例

```java
@Service
public class OrderService {
    private final OrderRepository repository;
    private final PaymentGateway gateway;

    public OrderService(OrderRepository repository, PaymentGateway gateway) {
        this.repository = repository;
        this.gateway = gateway;
    }
}
```

## 3. 今天的 60 分钟安排

将字段注入改为构造器注入；在纯单测中传入 fake 实现。

# 4. Day 2 作业

实现 OrderService 的接口依赖和测试替身。

## 今日验收标准

- 字段注入的风险？
- 为什么构造器参数是依赖清单？
- 不启动 Spring 能否测试 Service？

下一节：**Week 9 / Day 3 — 分层组件。**
