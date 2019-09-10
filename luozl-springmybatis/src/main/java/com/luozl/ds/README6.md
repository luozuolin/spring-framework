#Zookeeper典型应用场景及实践
Zookeeper 从设计模式角度来看，是一个基于观察者模式设计的分布式服务管理框架，它负责存储和管理大家都关心的数据，然后接受观察者的注册，一旦这些数据的状态发生变化，Zookeeper 就将负责通知已经在 Zookeeper 上注册的那些观察者做出相应的反应，从而实现集群中类似 Master/Slave 管理模式
统一命名服务（Name Service）
配置管理（Configuration Management）
集群管理（Group Membership）
同步锁（Locks）
##zk集群搭建
https://blackproof.iteye.com/blog/2039040
####常见错误
ZooKeeper 启动报错 Invalid arguments, exiting abnormally java.lang.NumberFormatException: 的解决办法
2018年10月29日 14:18:39 lvjingWn 阅读数 316
 版权声明：本文为博主原创文章，未经博主允许不得转载。 https://blog.csdn.net/lvjingWn/article/details/83505116
window环境启动zookeeper命令为zkServer.cmd而非zkServer.cmd start

启动zkui命令java -jar target/zkui-2.0-SNAPSHOT-jar-with-dependencies.jar

###zk详细讲解
https://www.ibm.com/developerworks/cn/opensource/os-cn-zookeeper/