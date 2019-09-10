##Windows下搭建Redis Cluster集群
redis集群搭建步骤：
https://blog.csdn.net/hao495430759/article/details/80540407
可能遇到问题的解决方案(All commands and features belonging to redis-trib.rb have been moved to redis-cli)
https://blog.csdn.net/aaaadong/article/details/82626056
集群启动：
分别启动每一个redis节点
接着将redis节点加入集群：
ruby redis-trib.rb create --replicas 1 127.0.0.1:6380 127.0.0.1:6381 127.0.0.1:6382 127.0.0.1:6383 127.0.0.1:6384 127.0.0.1:6385
