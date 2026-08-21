# Week 6 / Day 3 — 生命周期与失败定位

> 建议用时：60 分钟  
> 今日目标：理解 validate、compile、test、package 的关系。

## 1. 今天学什么

1. Maven 生命周期
2. Surefire
3. 编译失败与断言失败
4. 测试报告

## 2. 核心示例

```bash
mvn test
mvn package
```

package 通常会先执行测试；测试失败应阻止错误产物交付。

## 3. 今天的 60 分钟安排

故意让一个测试失败，阅读 `target/surefire-reports`，再修复。

# 4. Day 3 作业

记录一次编译错误和一次断言错误的定位路径。

## 今日验收标准

- test 与 package 的区别？
- Surefire 报告在哪里？
- 为什么不能忽略失败测试？

下一节：**Week 6 / Day 4 — JUnit 断言。**

---

<!-- daily-navigation -->
[下一天](../week06/day04-junit-assertions.md)
