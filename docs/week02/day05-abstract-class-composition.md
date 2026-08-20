# Week 2 / Day 5 — 抽象类与组合

> 建议用时：60 分钟  
> 今日目标：区分接口、抽象类和组合，避免为了复用代码滥用继承。

## 1. 今天学什么

1. `abstract class`
2. 模板方法
3. 组合关系
4. 共享校验逻辑
5. 设计取舍

## 2. 抽象类

抽象类可以保存共享状态和实现稳定流程：

```java
public abstract class BasePayment {
    protected final boolean valid(PaymentRequest request) {
        return request != null && request.amount() > 0;
    }

    public final boolean execute(PaymentRequest request) {
        if (!valid(request)) return false;
        return doPay(request);
    }

    protected abstract boolean doPay(PaymentRequest request);
}
```

`final` 模板方法避免子类绕过校验。

## 3. 组合优于继承

如果支付服务只是“拥有一个校验器”，直接注入 `PaymentValidator`：

```java
public OrderService(PaymentValidator validator, PaymentStrategy strategy) {}
```

它不要求两个类型存在父子关系，替换更简单。

## 4. 今天的 60 分钟安排

比较抽象基类和组合校验器两种实现，记录优缺点。

# 5. Day 5 作业

实现 `PaymentValidator`，将金额校验从 `OrderService` 提取出来；保持支付策略仍为接口。

## 今日验收标准

- 接口表达什么？
- 抽象类何时值得引入？
- 组合如何降低继承层级？

下一节：**Week 2 / Day 6 — 泛型与对象契约。**
