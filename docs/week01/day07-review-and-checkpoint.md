# Week 1 / Day 7 — 复盘、验收与纠错

> 建议用时：60 分钟  
> 今日目标：不用参考教程完成 Week 1 最小验收，识别仍不稳的概念，再决定是否进入 Week 2。

## 1. 本周知识地图

```text
值与类型
├── 基本类型：int、boolean、double
├── 包装类型：Integer、Long；可为 null
└── 引用：对象变量保存对象引用

对象建模
├── class：可变业务实体
├── 构造器：创建时建立合法状态
├── 方法：行为与规则
├── private：保护内部状态
├── static：属于类
├── final：引用不能重新赋值
├── record：不可变数据载体
└── enum：有限状态集合

数据处理
├── if / switch：分支
├── for / while：循环
├── 数组：固定长度
├── List<T>：可变长度且元素类型受约束
└── String：对象；用 equals 比内容

时间
└── java.time：LocalDate、LocalDateTime、Duration
```

---

## 2. 先做闭卷验收

新建 `exercises/week01/Week01Review.java`，不要复制前几天的实现。限时 35 分钟完成以下程序。

### 领域类型

```java
enum OrderStatus {
    CREATED,
    PAID,
    CANCELLED
}

record OrderSummary(Long orderId, String productName, int quantity, int totalPrice, OrderStatus status) {
}
```

实现 `Product`：

```text
字段：id、name、price、stock
方法：isAvailable()、decreaseStock(int quantity)、getName()、getPrice()、getStock()
```

实现 `Order`：

```text
字段：id、product、quantity、status
方法：canPay()、pay()、summary()
```

### 业务规则

1. `Order` 创建后状态为 `CREATED`。
2. `quantity <= 0`、商品无库存或库存不足时，`canPay()` 返回 `false`。
3. `pay()` 仅在状态是 `CREATED` 且 `canPay()` 为 `true` 时扣库存、改为 `PAID` 并返回 `true`。
4. 重复支付、取消后支付、库存不足支付都返回 `false`，且不改变库存。
5. `summary()` 返回 `OrderSummary`；总价是单价乘以数量。
6. `main` 用 `List<Order>` 保存至少三笔订单，分别覆盖成功支付、库存不足、重复支付。

### 预期场景

```text
商品：Keyboard，单价：399，库存：3
订单 A：数量 2，首次支付 true，剩余库存 1
订单 A：再次支付 false，剩余库存 1
订单 B：数量 2，支付 false，剩余库存 1
```

验收不是“写完就算”；必须运行 `main`，并逐项核对库存和状态。

---

## 3. 高频错误清单

### `==` 与 `equals()`

```java
Long first = 1000L;
Long second = 1000L;

// first == second：比较引用，不可靠
first.equals(second); // 比较数值
```

例外：比较 `enum` 用 `==`；比较基本类型也用 `==`。

### `null` 与空集合

- 输入为 `null`：方法需要明确返回、抛错或拒绝，不能假装它不会发生。
- 没有结果：集合优先返回空 `List`，而不是 `null`。
- 对可能为 `null` 的字符串：`"常量".equals(variable)`。

### 状态改变顺序

错误：先扣库存，再判断订单是否已支付。重复调用可能重复扣减。

正确：先判断状态与参数，再调用 `decreaseStock()`，成功后最后改变订单状态。

### `static` 滥用

`main`、纯工具方法和共享常量可以是 `static`。商品库存、订单支付状态属于对象，不能设计为静态字段。

---

## 4. 用输出定位问题

不需要立刻学习调试器；先学会打印“状态变化前后”：

```java
System.out.println("before: stock=" + product.getStock() + ", status=" + order.getStatus());
boolean paid = order.pay();
System.out.println("paid=" + paid);
System.out.println("after: stock=" + product.getStock() + ", status=" + order.getStatus());
```

打印应回答具体问题。不要只打印 `"here"`；至少包含变量名和关键状态。

当输出不符合预期时，按这个顺序检查：

1. 条件是否正确处理了 `quantity <= 0`、库存不足和重复支付？
2. `Product.decreaseStock()` 的失败路径是否真的不修改 `stock`？
3. `Order.pay()` 是否在扣库存前检查 `status`？
4. `Order` 是否保存了同一个 `Product` 对象引用？

---

## 5. 是否进入 Week 2

以下每项都能独立完成，才进入 Week 2：

- [ ] 能定义带构造器、私有字段和业务方法的 `Product`。
- [ ] 能解释基本类型、包装类型、对象引用及 `null`。
- [ ] 能根据场景选择 `class`、`record`、`enum`。
- [ ] 能用 `if`、循环和 `List<Product>` 处理多条数据。
- [ ] 能用 `equals()` 正确比较 `String` 和 `Long`。
- [ ] 能解释 `static`、`final` 和 Java 按值传递。
- [ ] 能完成上面的订单支付程序，并验证不会重复扣库存。

有任一项不稳：回到对应 Day 文档，**从空白文件重新写一次**，不要只重读。

---

## 6. 本周提交建议

完成闭卷验收后：

```bash
git add exercises/week01/Week01Review.java
git commit -m "complete week 1 review"
git push
```

提交前确认程序可运行，输出包含成功支付、失败支付和库存不变三种结果。

下一周：**Week 2 — OOP、接口、继承、多态、泛型与 `equals` / `hashCode`。**

---

<!-- daily-navigation -->
[下一天](../week02/day01-encapsulation-invariants.md)
