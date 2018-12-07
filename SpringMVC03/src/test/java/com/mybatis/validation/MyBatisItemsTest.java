package com.mybatis.validation;

import com.mybatis.pojo.MybatisItems;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/17 0017.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml","classpath:mybatis/*.xml"})
@WebAppConfiguration
public class MyBatisItemsTest extends AbstractTestNGSpringContextTests{
    private static Validator validator;
    @BeforeClass
    public static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testName(){
        MybatisItems mybatisItems = new MybatisItems();
        mybatisItems.setName("手");
       // mybatisItems.setDetail("好手");
        Set<ConstraintViolation<MybatisItems>> constraintViolations =
                validator.validate(mybatisItems);
        System.out.println(constraintViolations.size());
        System.out.println(constraintViolations.iterator().next().getMessage());
    }
}
