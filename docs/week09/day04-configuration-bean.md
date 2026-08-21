# Week 9 / Day 4 — `@Configuration` 与 `@Bean`

> 建议用时：60 分钟  
> 今日目标：为第三方对象和显式配置注册 Bean。

## 1. 今天学什么

1. `@Configuration`
2. `@Bean`
3. 第三方 SDK 适配
4. Bean 命名

## 2. 核心示例

```java
@Configuration
public class TimeConfiguration {
    @Bean
    Clock clock() { return Clock.systemUTC(); }
}
```

不能扫描或需要参数控制的对象适合 `@Bean`。

## 3. 今天的 60 分钟安排

注册 Clock 或支付 SDK adapter；让 Service 依赖自己的接口。

# 4. Day 4 作业

用 `@Bean` 提供可替换时钟，并在测试注入固定时钟。

## 今日验收标准

- Component 和 Bean 的区别？
- 为什么隔离第三方类型？
- 多实现如何消歧？

下一节：**Week 9 / Day 5 — AOP。**

---

<!-- daily-navigation -->
[下一天](../week09/day05-aop-proxies.md)
