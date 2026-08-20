# Week 2 / Day 3 — 多态与动态分派

> 建议用时：60 分钟  
> 今日目标：让调用方依赖父类型，并理解运行时如何选择子类实现。

## 1. 今天学什么

1. 父类型引用
2. 动态分派
3. 重载与覆写
4. 多态集合

## 2. 多态调用

```java
List<Notification> channels = List.of(
        new EmailNotification(),
        new SiteNotification()
);

for (Notification channel : channels) {
    channel.send("订单已支付");
}
```

变量类型是 `Notification`，实际对象分别是邮件和站内信。调用 `send` 时，JVM 使用实际对象的覆写版本。

## 3. 重载不是多态覆写

```java
void send(String text) {}
void send(String text, int retry) {}
```

这是重载，编译期根据参数选择。子类用相同签名重新实现父类方法，才是覆写。

## 4. 今天的 60 分钟安排

### 0–20 分钟

定义 `Notification` 接口或抽象类，以及两个实现。

### 20–40 分钟

用 `List<Notification>` 统一发送，新增短信实现。

### 40–60 分钟

比较 `send(String)` 和 `send(String,int)` 的调用结果。

# 5. Day 3 作业

实现邮件、站内信、短信三种通知渠道。编写 `NotificationService.broadcast()`，不得判断具体实现类型。

## 要求

- 新增渠道只新增类。
- 发送失败要返回或抛出明确结果。
- 不使用 `instanceof` 选择渠道。

## 今日验收标准

- 什么决定可调用的方法集合？
- 什么决定最终执行的覆写实现？
- 重载与覆写有何区别？

下一节：**Week 2 / Day 4 — 接口与依赖倒置。**
