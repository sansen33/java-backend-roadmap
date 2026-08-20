# Week 2 / Day 6 — 泛型与对象契约

> 建议用时：60 分钟  
> 今日目标：用泛型保证返回值类型，并正确实现 `equals`、`hashCode`、`toString`。

## 1. 今天学什么

1. 类型参数 `<T>`
2. 泛型方法
3. `equals` 与 `hashCode`
4. 值对象
5. Map/Set 的对象契约

## 2. 泛型结果

```java
public record Result<T>(T data, String error) {
    public boolean isSuccess() {
        return error == null;
    }
}
```

`Result<Product>` 和 `Result<Order>` 在编译期保持不同类型，不需要强制转换。

## 3. 相等契约

如果两个 `Money` 金额相同，它们应当 `equals`，并拥有相同 hash code。参与 hash 的字段应保持稳定；不要用可变对象作为 Map key。

```java
public record Money(int cents, String currency) {}
```

record 会按组件生成这些方法，适合简单值对象。

## 4. 今天的 60 分钟安排

实现 `Result<T>`、`Money`，放入 `HashSet` 验证去重，再打印对象。

# 5. Day 6 作业

实现泛型 `Page<T>`：包含 `items`、`page`、`size`、`total`，并拒绝非法页码和页大小。

## 今日验收标准

- 为什么不能使用 raw type？
- 相等对象为何必须拥有相同 hash code？
- 可变 key 会造成什么问题？

下一节：**Week 2 / Day 7 — 支付策略闭卷复盘。**
