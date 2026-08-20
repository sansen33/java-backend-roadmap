# Week 5 / Day 5 — 自定义注解

> 建议用时：60 分钟  
> 今日目标：理解注解是元数据，运行逻辑由读取者实现。

## 1. 今天学什么

1. `@Target`
2. `@Retention`
3. `RUNTIME`
4. 注解字段

## 2. 核心示例

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Required {
}
```

没有代码读取它时，注解不会自动执行校验。

## 3. 今天的 60 分钟安排

定义 `@Required`；标注输入 record；反射读取注解。

# 4. Day 5 作业

实现运行时字段必填标记，并列出缺失字段名。

## 今日验收标准

- `SOURCE`、`CLASS`、`RUNTIME` 区别？
- 注解自身是否执行逻辑？
- Target 为什么重要？

下一节：**Week 5 / Day 6 — 反射。**
