# Week 10 / Day 1 — Boot 启动与自动配置

> 建议用时：60 分钟  
> 今日目标：启动 Spring Boot Web 应用并理解 starter 的作用。

## 1. 今天学什么

1. `@SpringBootApplication`
2. starter
3. 自动配置
4. 端口与启动日志

## 2. 核心示例

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

自动配置根据 classpath 和配置条件装配 Bean，不是无条件魔法。

## 3. 今天的 60 分钟安排

启动应用，实现 `GET /hello`，用浏览器或 curl 访问。

# 4. Day 1 作业

配置端口并验证启动、健康请求和优雅停止。

## 今日验收标准

- starter 提供什么？
- 自动配置何时生效？
- 端口为何不硬编码？

下一节：**Week 10 / Day 2 — Controller 与路由。**

---

<!-- daily-navigation -->
[下一天](../week10/day02-controller-routing.md)
