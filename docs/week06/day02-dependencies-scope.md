# Week 6 / Day 2 — 依赖与 scope

> 建议用时：60 分钟  
> 今日目标：理解直接依赖、传递依赖和测试依赖范围。

## 1. 今天学什么

1. dependency
2. 传递依赖
3. `compile`、`test`、`runtime`
4. dependency tree

## 2. 核心示例

JUnit 只用于测试，应使用 `test` scope，避免进入生产运行时。

```bash
mvn dependency:tree
```

## 3. 今天的 60 分钟安排

添加 JUnit Jupiter，查看依赖树，定位依赖来源。

# 4. Day 2 作业

整理项目依赖，移除重复声明，记录每个依赖的用途和 scope。

## 今日验收标准

- 直接依赖和传递依赖区别？
- test scope 为什么重要？
- 如何查依赖冲突？

下一节：**Week 6 / Day 3 — 生命周期。**

---

<!-- daily-navigation -->
[下一天](../week06/day03-maven-lifecycle.md)
