# Week 11 / Day 4 — 数据库分页

> 建议用时：60 分钟  
> 今日目标：实现有稳定排序的分页查询。

## 1. 今天学什么
- LIMIT/OFFSET、排序、总数查询。

## 2. 实践
实现 `page`、`size`、`total`；按 `created_at, id` 排序。

# 3. Day 4 作业
返回 `Page<UserView>`，拒绝非法页码和大小。

## 4. 今日验收标准
- 分页排序稳定。
- size 有上限。

下一节：**Week 11 / Day 5 — MyBatis-Plus。**

---

<!-- daily-navigation -->
[下一天](../week11/day05-mybatis-plus.md)
