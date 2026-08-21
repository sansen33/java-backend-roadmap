# Week 1 / Day 3 — 流程控制、数组、`String`

> 建议用时：60 分钟  
> 今日目标：能用分支和循环处理一组数据，并避免把 Java 的 `String` 当作 JavaScript 字符串使用。

## 1. 今天学什么

1. `if / else if / else`
2. `switch` 表达式
3. `for`、增强 `for`、`while`
4. 数组的创建与遍历
5. `String` 的不可变性、比较与常用方法
6. 早返回（early return）

---

## 2. 分支：先处理非法输入

`if` 的条件必须是 `boolean`：

```java
public boolean decreaseStock(int quantity) {
    if (quantity <= 0) {
        return false;
    }
    if (quantity > stock) {
        return false;
    }

    stock -= quantity;
    return true;
}
```

这比多层嵌套更容易读。失败路径立刻返回，正常路径留在最后。

```java
public String getStockStatus() {
    if (stock <= 0) {
        return "OUT_OF_STOCK";
    }
    if (stock < 10) {
        return "LOW_STOCK";
    }
    return "IN_STOCK";
}
```

`switch` 适合离散值映射；现代 Java 可直接返回结果：

```java
public String getRoleName(String role) {
    return switch (role) {
        case "ADMIN" -> "管理员";
        case "USER" -> "普通用户";
        default -> "未知角色";
    };
}
```

不要用 `switch` 处理范围判断，库存、价格、年龄这类问题使用 `if` 更自然。

---

## 3. 数组：固定长度的一组同类型值

```java
int[] prices = {399, 199, 1999};
String[] names = new String[3];
names[0] = "Keyboard";
```

- 下标从 `0` 开始。
- 长度为 `array.length`，不是 `length()`。
- 创建后长度不能改变。

遍历下标，适合需要位置或同时读写元素：

```java
int total = 0;
for (int index = 0; index < prices.length; index++) {
    total += prices[index];
}
```

增强 `for`，适合只读取每个元素：

```java
for (int price : prices) {
    System.out.println(price);
}
```

边界要写成 `< prices.length`。`<= prices.length` 会在最后一次访问不存在的下标，抛出 `ArrayIndexOutOfBoundsException`。

---

## 4. 循环：明确终止条件

`for` 适合次数或范围确定的场景：

```java
for (int index = 0; index < 3; index++) {
    System.out.println(index);
}
```

`while` 适合“直到某条件不再成立”：

```java
int stock = 3;
while (stock > 0) {
    stock--;
}
```

不要为了遍历而把下标藏在 `while` 中；多数场景下 `for` 更直接。不要在循环体中随意修改控制变量，否则容易出现死循环或漏处理。

---

## 5. `String`：使用 `equals` 比较内容

`String` 是对象；`==` 比较的是是否同一个引用，不是文本内容：

```java
String first = new String("ADMIN");
String second = new String("ADMIN");

System.out.println(first == second);      // false
System.out.println(first.equals(second)); // true
```

常用安全写法：常量放在左边，避免变量为 `null` 时抛出空指针异常。

```java
if ("ADMIN".equals(role)) {
    // ...
}
```

`String` 不可变。每次拼接都会产生新的字符串：

```java
String message = "Hello";
message = message + " Java";
```

常用 API：

```java
String name = "  Tom  ";
name.trim();                    // "Tom"
name.toUpperCase();             // "  TOM  "
name.contains("om");           // true
name.isBlank();                 // false
"a,b,c".split(",");            // String[]
```

这些方法通常返回新值，不会修改原变量；要保存结果，必须重新赋值。

---

## 6. Java 与 TypeScript 对照

```ts
const prices = [399, 199, 1999];
const total = prices.reduce((sum, price) => sum + price, 0);
if (role === "ADMIN") console.log("管理员");
```

```java
int[] prices = {399, 199, 1999};
int total = 0;
for (int price : prices) {
    total += price;
}
if ("ADMIN".equals(role)) {
    System.out.println("管理员");
}
```

本周先用循环建立基本功；第 4 周再系统学习 Stream。

---

## 7. 今天的 60 分钟安排

### 0–15 分钟

手写 `getStockStatus()`，分别传入 `0`、`5`、`10` 库存验证三个分支。

### 15–30 分钟

定义 `int[] prices`，用普通 `for` 计算总价，再用增强 `for` 重写。

### 30–45 分钟

验证 `==` 与 `equals()` 的区别；再用 `trim()`、`isBlank()` 处理用户名输入。

### 45–60 分钟

完成下面作业。

---

# 8. Day 3 作业

实现静态方法：

```java
public static int calculateAvailableTotal(int[] prices, int[] stocks)
```

规则：

1. 两个数组长度不同，返回 `0`。
2. 只累计 `stock > 0` 的商品价格。
3. 任一数组为 `null`，返回 `0`。
4. 不能使用 Stream。

测试数据：

```text
prices = [399, 199, 1999, 99]
stocks = [10, 0, 2, 0]
```

期望结果：`2398`。

再实现：

```java
public static boolean isValidProductName(String name)
```

规则：`name` 不为 `null`，去除首尾空白后不为空，且长度不超过 `50`。

---

# 9. 今日验收标准

- 为什么数组循环条件是 `index < array.length`？
- 普通 `for` 和增强 `for` 分别适合什么情况？
- 为什么字符串内容比较不能依赖 `==`？
- 为什么写 `"ADMIN".equals(role)` 更安全？
- 能否独立处理 `null`、长度不一致和库存为零的输入？

下一节：**Week 1 / Day 4 — `record`、`enum` 与日期时间。**

---

<!-- daily-navigation -->
[下一天](../week01/day04-record-enum-date-time.md)
