# Week 5 / Day 6 — 反射

> 建议用时：60 分钟  
> 今日目标：用反射实现简单基础设施，同时知道其边界。

## 1. 今天学什么

1. `Class<?>`
2. 字段读取
3. 私有字段访问
4. 反射异常与代价

## 2. 核心示例

```java
for (Field field : type.getDeclaredFields()) {
    if (field.isAnnotationPresent(Required.class)) {
        field.setAccessible(true);
        Object value = field.get(target);
    }
}
```

反射适合框架基础设施；核心业务优先普通方法调用。

## 3. 今天的 60 分钟安排

完成 `@Required` 校验器，覆盖 null、空字符串和私有字段。

# 4. Day 6 作业

返回不可变错误列表，错误包含类型名和字段名。

## 今日验收标准

- 为什么反射不能替代领域模型？
- `setAccessible` 有何风险？
- 如何处理反射异常？

下一节：**Week 5 / Day 7 — CSV 导入复盘。**

---

<!-- daily-navigation -->
[下一天](../week05/day07-review-csv-import.md)
