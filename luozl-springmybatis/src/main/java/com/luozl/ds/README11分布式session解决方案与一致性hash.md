#分布式session解决方案与一致性hash
保证session一致性的架构设计常见方法：

session同步法：多台web-server相互同步数据

客户端存储法：一个用户只存储自己的数据

反向代理hash一致性：四层hash和七层hash都可以做，保证一个用户的请求落在一台web-server上

后端统一存储：web-server重启和扩容，session也不会丢失