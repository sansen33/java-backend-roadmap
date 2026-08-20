# Week 11 / Day 6 — 替换内存 Map

> 建议用时：60 分钟  
> 今日目标：将 User CRUD 迁移到 MySQL。

## 1. 今天学什么
- Repository 适配、事务测试、迁移边界。

## 2. 实践
删除内存存储实现的调用路径，Service 只依赖 Repository 接口。

# 3. Day 6 作业
通过 HTTP 完成一次持久化 CRUD。

## 4. 今日验收标准
- 重启后数据仍存在。
- Controller 不感知 SQL。

下一节：**Week 11 / Day 7 — MyBatis 复盘。**
