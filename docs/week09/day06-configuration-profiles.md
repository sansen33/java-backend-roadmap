# Week 9 / Day 6 — 配置与环境

> 建议用时：60 分钟  
> 今日目标：用配置绑定替代硬编码，并隔离环境差异。

## 1. 今天学什么

1. `application.yml`
2. Profile
3. `@ConfigurationProperties`
4. 敏感配置

## 2. 核心示例

支付超时、服务地址等通过绑定配置注入；密钥来自环境变量或受管密钥服务，不能提交仓库。

## 3. 今天的 60 分钟安排

绑定支付超时配置，添加非法值校验，切换 local/test。

# 4. Day 6 作业

为 `PaymentProperties` 添加超时和 endpoint，测试配置覆盖。

## 今日验收标准

- 为什么不硬编码配置？
- profile 解决什么问题？
- 日志为何不能输出密钥？

下一节：**Week 9 / Day 7 — Spring 核心复盘。**
