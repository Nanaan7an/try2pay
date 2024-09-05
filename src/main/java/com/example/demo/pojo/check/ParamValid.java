package com.example.demo.pojo.check;

import com.example.demo.enums.ResultCode;
import com.example.demo.exception.BussException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author Nanaan
 * @Date 2024/9/5 16:39
 * @Description 参数校验
 */
@Aspect
@Component
public class ParamValid {
    private static Validator validator;

    static {
        validator = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
    }

    @Pointcut(value = "@annotation(org.springframework.validation.annotation.Validated)")
    private void validateParam() {
    }

    @Before("validateParam()&& @annotation(validated)")
    public void check(JoinPoint joinPoint, Validated validated) throws BussException {
        //获取参数，注解中获取分组校验
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(
                arg -> {
                    Set<ConstraintViolation<Object>> validatorSet = validator.validate(args, validated.value());
                    List<String> msgList = validatorSet.stream().map(objectConstraintViolation -> objectConstraintViolation.getPropertyPath() + objectConstraintViolation.getMessage()).collect(Collectors.toList());
                    //如果参数校验未通过，抛出BussException
                    if (!CollectionUtils.isEmpty(msgList)) {
                        throw new BussException(ResultCode.VAILD_FAIL, msgList.get(0));
                    }
                }
        );
    }
}
