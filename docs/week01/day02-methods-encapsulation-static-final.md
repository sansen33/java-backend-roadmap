# Week 1 / Day 2 — 方法、封装、`static`、`final` 与参数传递

> 建议用时：60 分钟  
> 今日目标：把 Day 1 定义出来的数据变成有行为的对象，并能区分实例成员、类成员和方法参数。

## 1. 今天学什么

1. 方法的定义、调用与返回值
2. 构造器与默认构造器
3. 封装：`private` 字段与受控公开方法
4. `this` 的含义
5. `static`：属于类，而不是某个对象
6. `final`：不能重新赋值的变量、参数和字段
7. Java 参数传递：始终按值传递
8. Java 与 TypeScript 对照

---

## 2. 从“数据”到“行为”

Day 1 的 `Product` 只有字段时，调用方很容易把业务规则散落在各处：

```java
Product product = new Product(1L, "Keyboard", 399.0, 10);
double discountPrice = product.getPrice() * 0.8;
boolean available = product.getStock() > 0;
```

更好的做法是让 `Product` 自己维护和自己的状态有关的规则：

```java
public class Product {
    private final Long id;
    private final String name;
    private double price;
    private int stock;

    public Product(Long id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public double calculateDiscountPrice(double discount) {
        return price * discount;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public boolean restock(int quantity) {
        if (quantity <= 0) {
            return false;
        }

        stock += quantity;
        return true;
    }

    public boolean decreaseStock(int quantity) {
        if (quantity <= 0 || quantity > stock) {
            return false;
        }

        stock -= quantity;
        return true;
    }
}
```

调用方只表达意图：

```java
boolean purchased = product.decreaseStock(2);
```

库存校验和扣减放在一起。这样以后无论从哪里下单，都不会漏掉库存不足的判断。

---

## 3. 方法：输入、处理、输出

方法的基本结构：

```java
访问修饰符 返回类型 方法名(参数列表) {
    // 方法体
    return 返回值;
}
```

例如：

```java
public int add(int left, int right) {
    return left + right;
}

public boolean isAvailable() {
    return stock > 0;
}

public void printSummary() {
    System.out.println(name + ": " + price);
}
```

- `int`、`boolean` 是返回类型；调用方必须接收或使用返回值。
- `void` 表示不返回结果。
- `left`、`right` 是参数，只在该方法调用期间存在。
- 同一个类中调用实例方法时，可直接写 `isAvailable()`；从外部调用则通过对象写 `product.isAvailable()`。

### 不要把业务逻辑留在 `main`

不推荐：

```java
public static void main(String[] args) {
    int stock = 10;
    int quantity = 2;
    if (quantity > 0 && quantity <= stock) {
        stock -= quantity;
    }
}
```

推荐：

```java
public static void main(String[] args) {
    Product product = new Product(1L, "Keyboard", 399.0, 10);
    boolean purchased = product.decreaseStock(2);
}
```

`main` 负责组装和调用；`Product` 负责商品规则。

---

## 4. 构造器与 `this`

构造器在 `new` 对象时执行；它没有返回类型，名字必须与类名相同：

```java
public class User {
    private final Long id;
    private String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

这里的两个 `name` 不是同一个东西：

```java
this.name = name;
```

- 左边的 `this.name`：当前对象的字段。
- 右边的 `name`：构造器参数。
- `this`：当前正在操作的对象。

如果类**没有声明任何构造器**，Java 会提供一个无参默认构造器。只要你自己声明了任意构造器，默认无参构造器就不再自动存在：

```java
User user = new User(); // 编译错误：上面的 User 只有两个参数的构造器
```

需要无参构造器时，应显式声明，并确保对象仍能保持合法状态。当前阶段优先使用参数完整的构造器。

---

## 5. 封装：不让外部随意破坏状态

字段通常使用 `private`：

```java
private int stock;
```

这意味着类外部不能直接修改它：

```java
// product.stock = -1; // 编译错误
```

而是提供带规则的方法：

```java
public boolean restock(int quantity) {
    if (quantity <= 0) {
        return false;
    }

    stock += quantity;
    return true;
}

public int getStock() {
    return stock;
}
```

不要为了“字段有 getter/setter”而机械生成所有 setter。`setStock(-1)` 没有说明业务意图，也绕开了校验；`restock(quantity)` 和 `decreaseStock(quantity)` 更清楚。

TypeScript 中常见的写法：

```ts
class Product {
  constructor(
    private readonly id: number,
    private readonly name: string,
    private price: number,
    private stock: number
  ) {}

  decreaseStock(quantity: number): boolean {
    if (quantity <= 0 || quantity > this.stock) return false;
    this.stock -= quantity;
    return true;
  }
}
```

Java 的思路相同，但访问控制和类型检查由 Java 编译器及其生态体系严格执行。

---

## 6. `static`：属于类的成员

实例字段属于每个对象：

```java
private int stock;
```

每个 `Product` 各有自己的 `stock`。而 `static` 字段属于类，所有对象共享一份：

```java
public class Product {
    private static int createdCount = 0;

    public Product(Long id, String name, double price, int stock) {
        createdCount++;
    }

    public static int getCreatedCount() {
        return createdCount;
    }
}
```

使用时通过类名：

```java
Product first = new Product(1L, "Keyboard", 399.0, 10);
Product second = new Product(2L, "Mouse", 199.0, 20);

System.out.println(Product.getCreatedCount()); // 2
```

`main` 必须是 `static`，因为 JVM 需要在还没有创建任何对象时找到程序入口：

```java
public static void main(String[] args) {
}
```

静态方法不能直接访问某个对象的实例字段：

```java
public static boolean isAvailable() {
    // return stock > 0; // 编译错误：不知道是哪一个 Product 的 stock
    return false;
}
```

只有确实与某个具体对象无关的逻辑，才适合 `static`。

---

## 7. `final`：引用不能重新指向别处

局部变量：

```java
final int maxStock = 100;
// maxStock = 200; // 编译错误
```

字段：

```java
private final Long id;
```

`id` 必须在构造器中赋值一次，之后不能再指向别的 `Long` 对象。对于不会变的业务标识，这是合理的默认选择。

注意：`final` 修饰对象引用，不等于对象完全不可变：

```java
final Product product = new Product(1L, "Keyboard", 399.0, 10);
product.decreaseStock(1); // OK：修改的是 Product 的内部状态
// product = new Product(2L, "Mouse", 199.0, 20); // 编译错误：引用不能重新赋值
```

常量一般组合使用 `static final`，并用全大写命名：

```java
public static final int ADULT_AGE = 18;
```

---

## 8. Java 参数传递：始终按值传递

Java 只有按值传递。区别在于：传入基本类型时，复制的是数值；传入对象时，复制的是对象引用的值。

### 基本类型

```java
public static void increase(int number) {
    number++;
}

int count = 1;
increase(count);
System.out.println(count); // 1
```

`increase` 得到的是 `count` 当前数值的一份副本。

### 对象引用

```java
public static void restock(Product product) {
    product.restock(1);
}

Product product = new Product(1L, "Keyboard", 399.0, 10);
restock(product);
System.out.println(product.getStock()); // 11
```

`rename` 获得的是引用的副本；两个引用都指向同一个 `User`，所以能修改该对象的状态。

但方法不能让调用方的变量改指向新对象：

```java
public static void replace(Product product) {
    product = new Product(2L, "Mouse", 199.0, 20);
}

Product product = new Product(1L, "Keyboard", 399.0, 10);
replace(product);
System.out.println(product.getStock()); // 10
```

牢记一句话：**Java 传的是值；对象场景里，值恰好是引用。**

---

## 9. 今天的 60 分钟安排

### 0–15 分钟

手写并运行 `Product` 的：

- 构造器
- `isAvailable()`
- `calculateDiscountPrice(double discount)`
- `decreaseStock(int quantity)`

### 15–30 分钟

给 `Product` 增加：

- `restock(int quantity)`
- `getStock()`
- 静态字段 `createdCount`
- 静态方法 `getCreatedCount()`

每个方法都分别试一次成功与失败输入。

### 30–45 分钟

写两个静态方法，验证参数传递：

- `increase(int number)`
- `replace(Product product)`

在调用前后打印变量，先预测再运行。

### 45–60 分钟

完成下面的 Day 2 作业。

---

# 10. Day 2 作业

创建 `Order` 类，字段如下：

```text
id
product
quantity
paid
```

其中 `product` 使用 `Product` 类型，`quantity` 使用 `int`，`paid` 使用 `boolean`。构造器必须接收 `id`、`product` 和 `quantity`；新订单默认未支付。

实现：

```java
boolean canPlace()
double calculateTotalPrice()
boolean pay()
```

规则：

1. `quantity <= 0` 或商品库存不足时，`canPlace()` 返回 `false`。
2. `calculateTotalPrice()` 返回商品单价乘以数量。
3. `pay()` 只有在未支付且可以下单时才扣减库存、将订单设为已支付并返回 `true`。
4. 支付失败或重复支付时，库存和支付状态都不能改变。
5. 扣库存只能调用 `product.decreaseStock(quantity)`，不能从 `Order` 直接修改 `Product` 的 `stock` 字段。

测试数据：

```text
商品：Keyboard
单价：399
库存：10
订单数量：2
```

期望输出：

```text
可以下单：true
订单总价：798.0
首次支付：true
剩余库存：8
重复支付：false
剩余库存：8
```

---

# 11. 今日验收标准

完成 Day 2 后，应该能够回答：

- 构造器和普通方法分别在什么时候执行？
- `this.name = name` 两侧的 `name` 分别是什么？
- 为什么不能让外部直接修改 `stock`？
- `static` 字段为什么被所有对象共享？
- 为什么 `main` 必须是 `static`？
- `final Product product` 后，为什么仍然可以调用 `product.decreaseStock(1)`？
- Java 把对象传入方法时，为什么可以改对象字段，却不能替换调用方的变量？
- 能否不看教程实现 `Order.pay()`，并保证重复支付不重复扣库存？

如果最后一项做不到，先画出 `Order`、`Product`、`stock` 和 `paid` 的状态变化，再重新实现一次。

---

# 12. 今日提交建议

完成自己的练习代码后提交：

```bash
git add .
git commit -m "complete week 1 day 2"
git push
```

原则：**方法应当表达业务意图，并把状态校验与状态修改放在同一个对象中。**

下一节：**Week 1 / Day 3 — 流程控制、数组、`String` 与常用调试方式。**
