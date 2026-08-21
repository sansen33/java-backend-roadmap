# Week 9 / Day 1 — Bean 与 IOC

> 建议用时：60 分钟  
> 今日目标：理解对象创建为何交由 Spring 容器管理。

## 1. 今天学什么

1. Bean
2. IOC 容器
3. 组件扫描
4. 生命周期概览

## 2. 核心示例

```java
@Component
public class SystemClock {
    public Instant now() { return Instant.now(); }
}
```

IOC 将协作者创建和组装从业务代码移交给容器。

## 3. 今天的 60 分钟安排

创建 Component，启动上下文获取 Bean，观察单例行为。

# 4. Day 1 作业

注册 `SystemClock` 并在 Service 中使用。

## 今日验收标准

- 什么是 Bean？
- IOC 转移了什么控制权？
- 为什么不在 Service 中直接 new 外部协作者？

下一节：**Week 9 / Day 2 — 构造器注入。**

---

<!-- daily-navigation -->
[下一天](../week09/day02-constructor-injection.md)
