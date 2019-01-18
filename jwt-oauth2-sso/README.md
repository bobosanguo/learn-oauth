# spring security oauth2 demo
## 1、工程结构 ##
    authorization-server: 授权服务器
    resource-server: 资源服务器
    client1: 客户端与资源服务器的混合体
    client2: 客户端与资源服务器的混合体

## 2、介绍 ##
1、sso登录, 基于cookie-session。client1/client2登录后，访问client2/client1不需要重新登录。 <br/>
2、client1/client2登录后，会从authorization-server获取Authentication(包含tokenId)，接着会从resource-server获取用户信息。 <br/>
3、client1/client2访问resource-server是通过在http header添加:Authorization:bearer <tokenId>。直接访问会401(未授权)。 <br/>
4、集成JWT(JSON Web Token)


## 3、host配置 ##

    127.0.0.1 www.server.com  # authorization-server
    127.0.0.1 www.client1.com # client1
    127.0.0.1 www.client2.com # client2
    127.0.0.1 www.resource.com # resource-server

通过域名访问工程