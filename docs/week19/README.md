# Week 19 — Linux 与 Docker

> 每天 60 分钟。目标：能诊断服务、容器化 Java 应用并编排依赖。

## Day 1 — Linux 文件与进程
学习 pwd、cd、cat、less、ps；练习定位 Java PID；验收：不盲目 kill 进程。

## Day 2 — 端口与日志
学习 lsof、netstat、tail、grep；练习定位端口占用和错误日志；验收：日志按时间/请求定位。

## Day 3 — Docker 基础
学习 image、container、volume、network；练习运行 MySQL；验收：数据使用 volume。

## Day 4 — Dockerfile
学习多阶段构建、JRE 镜像、非 root 用户；练习构建 Spring Boot 镜像；验收：不把密钥 bake 入镜像。

## Day 5 — Compose
学习 service、environment、healthcheck；练习 Java+MySQL+Redis；验收：依赖有健康检查。

## Day 6 — Nginx
学习反向代理、超时、请求头；练习代理 API；验收：真实客户端 IP 策略明确。

## Day 7 — 闭卷复盘
容器化 Java+MySQL+Redis 并通过 HTTP 验证。
- [ ] 可一条 compose 命令启动。
- [ ] 数据可持久化。
- [ ] 配置外置。
- [ ] 日志可查看。
