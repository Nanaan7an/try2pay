# IoC控制反转

### 实现方式
##### 准备工作：引入相关依赖
`
<dependency>
<groupId>org.springframework</groupId>
<artifactId>spring-context</artifactId>
</dependency>
`
##### 基于XML

1.创建对象Pojo4Xml

2.创建配置文件`.xml`，将POJO对象配置在`.xml`中，按需配置默认属性值等。

3.此时可以构造容器，并根据`id`创建对象。

*tips*

`.xml`应当写在`resource`下；当`.xml`处于`resource`的根目录下，构造容器时可以直接写文件名；若`.xml`处于`resource`的子目录下时，则需要使用`classpath:路径/文件名.xml`获取文件，其中`classpath:`表明该文件已处于`resource`，故路径仅需相对路径。
