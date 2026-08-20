# Week 14 / Day 1 — Redis String

> 建议用时：60 分钟  
> 今日目标：使用 String 缓存简单对象与计数。

## 1. 今天学什么
- SET/GET、INCR、序列化、key 命名。

## 2. 实践
缓存用户摘要，key 如 `user:summary:{id}`。

# 3. Day 1 作业
实现缓存读取和回源加载。

## 4. 今日验收标准
- key 有命名空间。
- 缓存值不包含密码。

下一节：**Week 14 / Day 2 — Hash。**
