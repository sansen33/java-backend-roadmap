# Week 02 — OOP、接口与泛型

> 每天 60 分钟：20 分钟阅读 + 30 分钟编码 + 10 分钟复盘。主线项目：可替换支付策略。

## Day 1 — 封装与对象不变量

### 学习
- `private` 字段、构造器校验、只读 getter。
- 用行为方法代替公开 setter：`pay()`、`cancel()`、`refund()`。
- 状态机：`CREATED -> PAID -> REFUNDED`；非法转换必须拒绝。

### 代码
```java
public boolean cancel() {
    if (status != OrderStatus.CREATED) return false;
    status = OrderStatus.CANCELLED;
    return true;
}
```

### 练习与验收
实现 `Order`，覆盖金额非负、数量为正、重复支付、已支付取消。说明每个字段为何可变或不可变。

## Day 2 — 继承与方法覆写

### 学习
- `extends`、`super(...)`、`@Override`、构造器执行顺序。
- `protected` 会扩大耦合；字段保持 `private`。
- 只有存在稳定 is-a 关系才继承。

### 练习
定义 `Product` 基类、`DigitalProduct` 和 `PhysicalProduct`。将下载地址或重量放在子类；不要复制公共字段。

### 验收
用父类引用保存两个子类，能解释哪些方法被覆写、哪些方法属于父类。

## Day 3 — 多态

### 学习
- 编译期类型决定可调用方法，运行时对象决定覆写实现。
- 重载按参数签名选择；覆写按运行时类型分派。

### 练习
```java
List<Notification> channels = List.of(new EmailNotification(), new SiteNotification());
for (Notification channel : channels) channel.send("订单已支付");
```
实现 `Notification.send`，调用方不判断具体渠道。

### 验收
新增 `SmsNotification` 时不修改发送循环。

## Day 4 — 接口与依赖倒置

### 学习
- `interface` 描述能力；实现类提供细节。
- 构造器注入接口，避免业务类依赖 SDK。

### 练习
定义 `PaymentStrategy.pay(PaymentRequest)`，实现支付宝、微信和测试支付。`OrderService` 只依赖接口。

### 验收
用测试实现替换真实支付；新增渠道不改 `OrderService`。

## Day 5 — 抽象类与组合

### 学习
- 抽象类适合共享状态与稳定流程；接口适合能力契约。
- 组合是“拥有”，继承是“属于”。

### 练习
为支付策略提取金额校验，但把渠道请求保留在实现类；比较“继承支付基类”和“组合校验器”两种设计。

### 验收
写出选择接口、抽象类、组合的理由，不以少写几行代码为唯一标准。

## Day 6 — 泛型与对象契约

### 学习
```java
public record Result<T>(T data, String error) {
    public boolean isSuccess() { return error == null; }
}
```
- 类型参数、泛型方法、避免 raw type。
- `equals`、`hashCode`、`toString` 的一致性。

### 练习
实现 `Money` 值对象并放入 `HashSet`；验证相同金额只能出现一次。

### 验收
相等对象 hash 相同；解释 mutable key 放入 Map 后为何危险。

## Day 7 — 闭卷项目

从空文件实现 PaymentStrategy：订单校验、策略注入、成功/失败状态变化、`Result<T>` 返回值。

### 必须覆盖
- [ ] 非法金额不调用支付渠道。
- [ ] 支付失败不改订单状态。
- [ ] 重复支付不重复调用渠道。
- [ ] 新增渠道只新增实现类。

提交：`git commit -m "complete week 2 oop"`。
