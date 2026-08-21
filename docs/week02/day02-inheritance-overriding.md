# Week 2 / Day 2 — 继承与方法覆写

> 建议用时：60 分钟  
> 今日目标：理解 `extends`、`super` 和覆写，并知道何时不应该使用继承。

## 1. 今天学什么

1. `extends` 与父类构造器
2. `super`
3. `@Override`
4. `protected` 的风险
5. is-a 关系

---

## 2. 一个合理的继承例子

```java
public abstract class Product {
    private final Long id;
    private final String name;

    protected Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int calculateShippingFee();
}
```

```java
public class DigitalProduct extends Product {
    public DigitalProduct(Long id, String name) {
        super(id, name);
    }

    @Override
    public int calculateShippingFee() {
        return 0;
    }
}
```

子类必须满足父类对外承诺。若只是为了复用几行代码，组合通常更安全。

## 3. 构造器执行顺序

创建子类时先初始化父类，再初始化子类。父类构造器通过 `super(...)` 显式调用。

不要在父类构造器中调用可被覆写的方法，因为此时子类字段可能尚未初始化。

---

## 4. 今天的 60 分钟安排

### 0–15 分钟

绘制 `Product`、`DigitalProduct`、`PhysicalProduct` 的关系。

### 15–40 分钟

实现两个子类和不同配送费规则。

### 40–60 分钟

测试父类引用调用覆写方法。

# 5. Day 2 作业

实现 `PhysicalProduct` 和 `DigitalProduct`。物理商品按重量计算配送费，数字商品配送费为零。

## 要求

1. 公共字段放父类且保持 `private`。
2. 子类必须使用 `@Override`。
3. 不在子类重复复制父类字段。
4. 解释此处为什么是 is-a 关系。

## 今日验收标准

- `super(...)` 做了什么？
- `protected` 为什么会扩大耦合？
- 继承和组合分别适合什么场景？

下一节：**Week 2 / Day 3 — 多态。**

---

<!-- daily-navigation -->
[下一天](../week02/day03-polymorphism.md)
