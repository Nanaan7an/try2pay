# RPC 
### 远程过程调用
一般，定义接口的类和调用接口的类会运行在同一个服务器上。

RPC可以在服务端定义、实现、注册接口，在客户端调用接口。

### client 
客户端，用于调用接口。


### server
服务端，用于提供接口。

服务端提供两种功能。

一是定义服务接口`service`，包括接口的实现。

二是注册接口`center`，一般使用`Map`存储接口名及接口；一般提供接口名给客户端，当服务端收到接口名后，会自动匹配到接口并执行方法。



