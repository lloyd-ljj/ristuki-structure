# Ritsuki Structure

Ritsuki 后端脚手架项目，基于 Spring Boot 3.x 构建。

## 项目结构

```
ritsuki-structure/
├── ritsuki-dependency/          # 依赖管理模块
├── ritsuki-framework/           # 框架组件模块
│   └── ritsuki-spring-boot-starter-common/  # 通用组件
└── ritsuki-server/              # 示例服务模块
```

## 模块说明

### ritsuki-dependency
统一管理项目依赖版本，作为 BOM (Bill of Materials) 使用。

### ritsuki-spring-boot-starter-common
通用组件模块，包含：
- **异常处理**: `BusinessException`, `GlobalExceptionHandler`, `ErrorCode`
- **统一返回**: `CommonResult`, `PagingResult`
- **通用工具**: `PageParam`, `DeleteReq`, `KeyValue`
- **配置类**: `CommonAutoConfiguration`, `CommonProperties`
- **其他**: Jackson 配置、健康检查、全局 Controller 增强等

### ritsuki-server
示例服务模块，展示如何使用框架组件。

## 快速开始

1. 配置数据库和 Nacos（如需要）
2. 运行 `RitsukiServerApplication`
3. 访问测试接口: `http://localhost:8080/api/test/hello`

## 特性

- ✅ 统一异常处理
- ✅ 统一返回结果封装
- ✅ 分页支持
- ✅ 参数校验
- ✅ 健康检查
- ✅ 日志配置
- ✅ Jackson 序列化配置

## 技术栈

- Spring Boot 3.2.4
- Spring Cloud 2023.0.1
- MyBatis Plus 3.5.7
- Redisson 3.21.1
- Hutool 5.8.24

## 许可证

MIT

