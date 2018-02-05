# spring-boot-tucao-weibo
这是一个使用Spring Boot实现的微博后端系统。前后台分离，后台可独立开发和调试。  
微博系统的前端使用Vue实现，[移步到前端系统](https://github.com/weieyuan/vue-demo-tucao-weibo).

##  Demo
前后台运行的效果：  
![](./demo/demo.gif)

## 技术栈
Spring Boot  
Spring Data JPA  
Stomp(WebSocket)

## 运行
#### 开发环境
使用H2内存数据库，启动main函数时传入"--spring.profiles.active=dev"参数。

#### 生产环境
使用MySQL数据库，启动main函数时传入"--spring.profiles.active=prod"参数。
