# Week 1 / Day 4 — `record`、`enum` 与日期时间

> 建议用时：60 分钟  
> 今日目标：能为稳定数据选择 `record`，为有限状态选择 `enum`，并用 `java.time` 表达业务时间。

## 1. 今天学什么

1. `record` 的用途与限制
2. `enum` 表达有限且确定的状态
3. `LocalDate`、`LocalDateTime`、`Duration`
4. 时间格式化与解析
5. 为什么业务代码不用 `Date`

---

## 2. `record`：不可变数据载体

当一个类型只是承载数据、创建后不需要修改时，使用 `record`：

```java
public record ProductSummary(Long id, String name, int price) {
}
```

Java 自动提供：

- 构造器：`new ProductSummary(1L, "Keyboard", 399)`
- 访问器：`summary.id()`，不是 `getId()`
- `equals()`、`hashCode()`、`toString()`

```java
ProductSummary summary = new ProductSummary(1L, "Keyboard", 399);
System.out.println(summary.name()); // Keyboard
```

`record` 的组件是 `final`，不能修改：

```java
// summary.price = 499; // 编译错误
```

它不替代所有 `class`。`Product` 有库存扣减、补货等可变业务状态，仍应使用普通类；接口入参、查询结果、简单值对象常适合 `record`。

可以在紧凑构造器中校验数据：

```java
public record CreateProductCommand(String name, int price) {
    public CreateProductCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must not be negative");
        }
    }
}
```

---

## 3. `enum`：不要用裸字符串表达状态

不推荐：

```java
String status = "PAID"; // 拼错 "PAD" 也能编译
```

推荐：

```java
public enum OrderStatus {
    CREATED,
    PAID,
    CANCELLED
}
```

使用：

```java
OrderStatus status = OrderStatus.CREATED;
if (status == OrderStatus.PAID) {
    System.out.println("订单已支付");
}
```

枚举实例是固定单例，所以可以用 `==` 比较。枚举也可以携带数据和行为：

```java
public enum OrderStatus {
    CREATED("待支付"),
    PAID("已支付"),
    CANCELLED("已取消");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
```

状态变化仍应放在 `Order` 中，而不是只在外部给字段赋新值。

---

## 4. 使用 `java.time` 表达时间

优先使用 Java 8+ 的 `java.time`：

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1995, 8, 20);
LocalDateTime createdAt = LocalDateTime.now();
```

- `LocalDate`：只有日期，如生日、账期。
- `LocalDateTime`：日期加时间，但**没有时区**。
- `Duration`：两个时间点间的时长。

```java
LocalDateTime startedAt = LocalDateTime.now();
LocalDateTime finishedAt = startedAt.plusMinutes(5);
long seconds = Duration.between(startedAt, finishedAt).toSeconds(); // 300
```

格式化与解析：

```java
import java.time.format.DateTimeFormatter;

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
LocalDateTime time = LocalDateTime.parse("2026-08-20 09:30", formatter);
String text = time.format(formatter);
```

格式化模式中的 `MM` 是月份，`mm` 是分钟；这是常见错误。

---

## 5. Java 与 TypeScript 对照

TypeScript 常通过字符串联合类型限制状态：

```ts
type OrderStatus = "CREATED" | "PAID" | "CANCELLED";
```

Java 中 `enum` 是更完整的领域类型：可传递、可比较、可承载行为。`record` 则接近 TypeScript 中只读的结构化数据，但是真正的运行时类型。

---

## 6. 今天的 60 分钟安排

### 0–15 分钟

创建 `ProductSummary` record，打印其访问器、`toString()` 和两个相同 record 的 `equals()` 结果。

### 15–30 分钟

创建 `OrderStatus` enum，给每个状态增加中文描述，并用 `switch` 输出描述。

### 30–45 分钟

用 `LocalDate` 计算 7 天后的日期；用 `LocalDateTime` 格式化当前时间。

### 45–60 分钟

完成作业。

---

# 7. Day 4 作业

创建：

```java
public enum CouponType {
    PERCENT,
    FIXED
}

public record Coupon(CouponType type, int value, LocalDate expireDate) {
}
```

实现：

```java
public static int calculateCouponPrice(int price, Coupon coupon, LocalDate today)
```

规则：

1. `price < 0`、任一参数为 `null`，返回原价。
2. 优惠券过期时返回原价；`expireDate` 当天仍有效。
3. `PERCENT` 的 `value` 取 `1`–`100`，例如 `80` 表示八折。
4. `FIXED` 的 `value` 是减免金额。
5. 结果不能小于 `0`。

测试：价格 `399`；八折券有效期为今天，结果 `319`（整数除法）；满减 `500`，结果 `0`。

---

# 8. 今日验收标准

- 什么时候选 `record`，什么时候选普通 `class`？
- 为什么订单状态应使用 `enum` 而不是字符串？
- 为什么枚举可用 `==` 比较？
- `LocalDate` 和 `LocalDateTime` 的区别？
- `MM` 与 `mm` 分别是什么？

下一节：**Week 1 / Day 5 — `List`、泛型与集合遍历。**

---

<!-- daily-navigation -->
[下一天](../week01/day05-list-generics-iteration.md)
