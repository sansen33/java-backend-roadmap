# Week 6 / Day 1 — Maven 项目结构

> 建议用时：60 分钟  
> 今日目标：理解 Maven 标准目录和最小构建流程。

## 1. 今天学什么

1. `pom.xml`
2. GAV 坐标
3. `src/main/java`
4. `src/test/java`
5. `mvn test`

## 2. 核心示例

```text
project/
├── pom.xml
└── src/
    ├── main/java/
    └── test/java/
```

生产代码和测试代码分开，构建工具可在命令行复现。

## 3. 今天的 60 分钟安排

创建最小 Maven 项目，添加 Product 和一个 JUnit 测试，执行 `mvn test`。

# 4. Day 1 作业

提交一个能从命令行测试通过的最小 Maven 项目。

## 今日验收标准

- GAV 分别表示什么？
- 测试代码为什么放在 test 源集？
- IDE 外能否执行测试？

下一节：**Week 6 / Day 2 — 依赖与 scope。**

---

<!-- daily-navigation -->
[下一天](../week06/day02-dependencies-scope.md)
