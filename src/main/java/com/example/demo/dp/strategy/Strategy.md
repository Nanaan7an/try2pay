# 策略模式
本质是算法族，区分变与不变，并将变的部分封装起来

## 算法族
算法族是一类接口（抽象策略），这类接口的实现类是一组可相互替换的（具体策略）。

## 上下文
含策略类的引用

## demo场景
主类是一个角色类`Character`，该类的对象一般有两个行为`behavior`，分别是移动行为`MoveBehavior`和武器行为`WeaponBehavior`。</br>

一般行为接口会有多个实现类，即算法族，每个实现类封装不同的行为实现；如`MoveBehavior`的实现类，其功能分别是不移动`MoveNotImpl`，移动一步`MoveStepImpl`，走`MoveWalkImpl`，跑`MoveRunImpl`。</br>

角色子类`Bleach`和`Naruto`重写了构造方法，拥有各自的默认行为，如`Bleach`默认不移动且使用刀剑作战；重写了父类的方法，输出了该类的职业类型。</br>

测试类`Fight`创建了两个对象实例，分别是`ichigo`和`narutchan`，他们有各自默认的移动行为和武器行为；在运行过程中，实例对象通过`setter`方法可以修改默认行为为其他行为。