# IoC控制反转

创建对象的权限一般掌握在开发者手中，在需要的`new`对象。

控制反转是指将创建对象的权限反转至Spring容器中，由Spring容器管理对象、决定对象的生命周期等。

### 实现方式
##### 准备工作：引入相关依赖
```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
</dependency>
```
##### 基于XML

1.创建对象`Pojo4Xml`

2.创建配置文件`.xml`，将POJO对象配置在`.xml`中，按需配置默认属性值等。

3.获取Spring容器的`ApplicationContext`对象后，根据`id`创建Bean实例对象。

4.通过*强制类型转换*或者`getBean()`*指定Bean类型*得到实际类型的Bean，此时就可以随意使用这个对象中的属性或者方法啦！

*tips*

- `.xml`应当写在`resource`下；当`.xml`处于`resource`的根目录下，构造容器时可以直接写文件名；若`.xml`处于`resource`的子目录下时，则需要使用`classpath:路径/文件名.xml`获取文件，其中`classpath:`表明该文件已处于`resource`，故路径仅需相对路径。


##### 基于注解-配置类
1.创建对象`Pojo4Configuration`

2.创建配置类`Bean4Configuration`，并使用`@Configuration`；创建一个方法，并使用`@Bean`，设置默认值、返回`Pojo4Configuration`。

3.获取Spring容器的`ApplicationContext`对象后，根据方法名或者注解的属性值`value`或`name`创建Bean实例对象。

4.使用Bean的属性和方法同上。

*tips*

- 配置类等同于XML，即使用一个class代替XML。
- 使用`@Configuration`标识配置类，使用`@Bean`标识Bean。
- 不能使用`@Bean`的方法中的对象名创建去Bean。

##### 基于注解-扫包+注解

1.创建对象`Pojo4Annotation`，添加注解`@Component`

2.获取Spring容器的`ApplicationContext`对象后，根据类型创建Bean实例对象。

3.使用Bean的属性和方法同上。

*tips*

- 扫包+注解需同时使用。
- 使用`@Value`或者赋值，设定初始值。

##### 小结
基于XML和基于配置类都是在将类单独配置在某处，并启动时加载；基于扫包注解，是直接使用类创建Bean。

# DI依赖注入 
A类依赖B类，当IoC创建A时，依赖的类会自动创建对象，即注入。
