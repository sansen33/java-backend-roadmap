# Week 1 / Day 6 — 组合练习：商品目录

> 建议用时：60 分钟  
> 今日目标：把本周的类、方法、分支、`enum`、`record` 和 `List` 组合成一个可运行的小程序。

## 1. 今天学什么

1. 将实体、枚举、记录和集合组合成一个程序
2. 区分实体、查询结果和服务的职责
3. 为公开方法定义输入与失败边界
4. 通过 `main` 验证状态变化

---

## 2. 练习目标

完成一个内存商品目录。程序不需要数据库、Spring 或 HTTP；重点是让 Java 基础概念协作：

```text
Product           可变业务实体：库存、价格、上架状态
ProductCategory   有限分类：使用 enum
ProductView       只读查询结果：使用 record
CatalogService    商品列表和业务操作
main              组装数据、调用服务、打印结果
```

建议放在一个文件中练习：`exercises/week01/ProductCatalogPractice.java`。同一文件只能有一个 `public` 顶级类；其他练习类型可声明为嵌套类型，或去掉 `public`。

---

## 2. 先定职责，再写代码

`Product` 只负责自己的规则：

```java
class Product {
    private final Long id;
    private final String name;
    private final ProductCategory category;
    private int price;
    private int stock;

    // 构造器、getters、isAvailable、decreaseStock
}
```

`CatalogService` 管理一组商品和跨商品操作：

```java
class CatalogService {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        // 校验后加入
    }

    public Product findById(Long id) {
        // 遍历并返回第一个匹配商品
    }

    public List<ProductView> listAvailable() {
        // 创建新的查询结果列表
    }
}
```

`main` 不应直接遍历并修改私有字段；它只负责展示流程：

```java
CatalogService catalog = new CatalogService();
catalog.add(...);
Product product = catalog.findById(1L);
System.out.println(product.decreaseStock(2));
```

---

## 3. 查询结果使用 `record`

不要把内部的可变 `Product` 直接当作输出模型。可以投影成只读结果：

```java
record ProductView(Long id, String name, ProductCategory category, int price, int stock) {
}
```

在 `listAvailable()` 中构造：

```java
views.add(new ProductView(
        product.getId(),
        product.getName(),
        product.getCategory(),
        product.getPrice(),
        product.getStock()
));
```

这个动作叫数据转换：内部实体可变，查询输出只携带展示所需的数据。后续做接口时会继续用到这种边界。

---

## 4. 输入与边界规则

每个公开方法都要决定怎样处理非法输入：

```java
public void add(Product product) {
    if (product == null) {
        return;
    }
    products.add(product);
}

public Product findById(Long id) {
    if (id == null) {
        return null;
    }

    for (Product product : products) {
        if (id.equals(product.getId())) {
            return product;
        }
    }
    return null;
}
```

注意 `id.equals(product.getId())`：前面已经排除了 `id == null`，因此这是安全的内容比较。`Long` 是对象，不要依赖 `==`。

---

## 5. 今天的 60 分钟安排

### 0–15 分钟

创建 `ProductCategory` 枚举和 `ProductView` record；写 `Product` 的构造器和 getter。

### 15–30 分钟

实现 `Product.isAvailable()`、`decreaseStock()`，并用成功、库存不足、数量为零三组输入测试。

### 30–45 分钟

实现 `CatalogService.add()`、`findById()` 和 `listAvailable()`。

### 45–60 分钟

完成下面完整作业并运行 `main`。

---

# 6. Day 6 作业

实现商品目录，类型与方法如下：

```java
enum ProductCategory {
    ELECTRONICS,
    OFFICE,
    OTHER
}

record ProductView(Long id, String name, ProductCategory category, int price, int stock) {
}
```

```java
class Product {
    // id、name、category、price、stock
    boolean isAvailable()
    boolean decreaseStock(int quantity)
    // 所有字段需要的 getter
}
```

```java
class CatalogService {
    void add(Product product)
    Product findById(Long id)
    List<ProductView> listAvailable()
    int calculateAvailableStock()
}
```

规则：

1. `add(null)` 不产生变化。
2. `findById(null)` 或找不到时返回 `null`。
3. `listAvailable()` 返回新列表，只包含库存大于 `0` 的商品，顺序保持加入顺序。
4. `calculateAvailableStock()` 只累计有库存商品的库存数。
5. 任意失败的 `decreaseStock` 都不能改变库存。

使用以下数据：

```text
1 Keyboard ELECTRONICS 399 10
2 Mouse    ELECTRONICS 199 0
3 Notebook OFFICE      20  5
```

期望：可售商品为 `Keyboard`、`Notebook`；可售库存总数为 `15`；扣减 Keyboard 2 件后库存为 `8`；再次扣减 20 件失败且库存仍为 `8`。

---

# 7. 今日验收标准

- `Product` 与 `CatalogService` 的职责为什么不同？
- 为什么 `ProductView` 适合用 `record`？
- 为什么 `listAvailable()` 要返回新列表？
- 为什么查询 `Long id` 应调用 `equals()`？
- 能否从空文件独立完成并运行这个程序？

下一节：**Week 1 / Day 7 — 复盘、验收与纠错。**

---

<!-- daily-navigation -->
[下一天](../week01/day07-review-and-checkpoint.md)
