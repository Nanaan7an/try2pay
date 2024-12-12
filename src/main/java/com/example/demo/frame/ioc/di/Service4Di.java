package com.example.demo.frame.ioc.di;

import com.example.demo.frame.ioc.baseannocation.Pojo4Annotation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author Nanaan
 * @Date 2024/12/12 20:18
 * @Description Pojo4Annotation是Service4Di的被依赖类。
 * DI依赖注入表示容器在创建Service4Di时，被依赖的类也被自动注入。
 */
@Data
@Component
public class Service4Di {
    /*
    在不使用DI的情况下，若在Service4Di中使用Pojo4Annotation，需要在构造函数中new出对象；
    但是某个外部方法调到用Service4Di中涉及到Pojo4Annotation的方法时，
    @Autowired类似于通过类byType获取依赖类。
     */
    @Autowired
    Pojo4Annotation pojo4Annotation;

    /*
    @Qualifier通过名字byName映射依赖类。
    值得注意的是，@Qualifier必须和@Autowired一起使用，否则无法注入成功。
     */
    @Autowired
    @Qualifier("pojo4DiByName")
    Pojo4DiByName pojo4DiByName;

    public void methodInDiBean() {
        System.out.println("Pojo4Annotation" + pojo4Annotation);
        System.out.println("Pojo4DiByName" + pojo4DiByName);
    }
}
