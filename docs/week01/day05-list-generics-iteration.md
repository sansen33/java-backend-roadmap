# Week 1 / Day 5 — `List`、泛型与集合遍历

> 建议用时：60 分钟  
> 今日目标：能用 `List<Product>` 管理可变数量的商品，并理解泛型如何在编译期约束元素类型。

## 1. 今天学什么

1. 数组与 `List` 的边界
2. `ArrayList` 的创建和基本操作
3. 泛型 `List<Product>`
4. 下标遍历、增强 `for`、`forEach`
5. 安全删除元素
6. `null` 与空集合

---

## 2. 为什么需要 `List`

数组长度固定：

```java
Product[] products = new Product[3];
```

商品数量会随业务变化时，使用 `List`：

```java
import java.util.ArrayList;
import java.util.List;

List<Product> products = new ArrayList<>();
products.add(new Product(1L, "Keyboard", 399.0, 10));
products.add(new Product(2L, "Mouse", 199.0, 0));
```

接口写 `List`，实现选 `ArrayList`：

```java
List<Product> products = new ArrayList<>();
```

这让调用方依赖抽象，而不是绑定到一个具体实现。

常用 API：

```java
products.size();
products.get(0);
products.set(0, replacement);
products.remove(0);
products.isEmpty();
products.contains(product);
```

`get`、`set` 和按下标 `remove` 都会检查下标；越界会抛出 `IndexOutOfBoundsException`。

---

## 3. 泛型：集合装什么，在声明处写清楚

```java
List<Product> products = new ArrayList<>();
```

`Product` 是元素类型。编译器会拒绝其他类型：

```java
// products.add("Keyboard"); // 编译错误
```

不要使用原始类型：

```java
// List products = new ArrayList(); // 丢失类型检查，不推荐
```

`<>` 是菱形语法；右侧类型可由左侧推断出来。

---

## 4. 遍历与查找

只读遍历：

```java
for (Product product : products) {
    System.out.println(product.getName());
}
```

需要下标时：

```java
for (int index = 0; index < products.size(); index++) {
    Product product = products.get(index);
    System.out.println(index + ": " + product.getName());
}
```

查找第一个有库存的商品：

```java
public static Product findFirstAvailable(List<Product> products) {
    if (products == null) {
        return null;
    }

    for (Product product : products) {
        if (product != null && product.isAvailable()) {
            return product;
        }
    }
    return null;
}
```

本周可以用 `null` 表示“没找到”，但调用方必须检查；第 4 周会学习用 `Optional` 明确表达这个结果。

---

## 5. 删除时不要误用增强 `for`

错误写法可能触发 `ConcurrentModificationException`：

```java
for (Product product : products) {
    if (!product.isAvailable()) {
        products.remove(product);
    }
}
```

本阶段用反向下标循环安全删除：

```java
for (int index = products.size() - 1; index >= 0; index--) {
    if (!products.get(index).isAvailable()) {
        products.remove(index);
    }
}
```

从尾部删除不会影响尚未处理元素的下标。

---

## 6. 空集合不是 `null`

推荐返回空集合：

```java
return new ArrayList<>();
```

不推荐：

```java
return null;
```

空集合可以安全遍历，`null` 会让调用方产生空指针异常。方法输入是否允许 `null` 要明确：本周练习中，遇到 `null` 直接返回空结果或 `0`，不要悄悄创建错误数据。

---

## 7. 今天的 60 分钟安排

### 0–15 分钟

用 `ArrayList` 创建 3 个 `Product`，练习 `add`、`get`、`size`。

### 15–30 分钟

用增强 `for` 打印商品名；再用下标 `for` 打印商品序号和名称。

### 30–45 分钟

实现 `findFirstAvailable`，分别测试空列表、全无库存和有库存三种情况。

### 45–60 分钟

完成作业。

---

# 8. Day 5 作业

实现：

```java
public static List<Product> removeUnavailableProducts(List<Product> products)
public static int calculateTotalStock(List<Product> products)
```

规则：

1. `removeUnavailableProducts` 直接修改传入列表，删除所有库存为 `0` 的商品；`products == null` 时不做任何操作。
2. 删除后保留原有商品顺序。
3. `calculateTotalStock` 忽略 `null` 元素；列表为 `null` 时返回 `0`。
4. 不使用 Stream、`removeIf` 或 `Iterator`；必须练习反向下标循环。

测试数据：`Keyboard(10)`、`Mouse(0)`、`Monitor(2)`。删除后商品数为 `2`，总库存为 `12`。

---

# 9. 今日验收标准

- 数组和 `List` 的长度/大小有什么差异？
- 为什么声明应写 `List<Product>` 而不是原始 `List`？
- 何时使用增强 `for`，何时使用下标 `for`？
- 为什么正向遍历删除元素会漏处理或越界？
- 为什么返回空列表通常优于返回 `null`？

下一节：**Week 1 / Day 6 — 组合练习：完成 Java 基础商品目录。**

---

<!-- daily-navigation -->
[下一天](../week01/day06-product-catalog-practice.md)
