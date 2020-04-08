package com.dcx.demo;

import com.dcx.demo.bean.Blue;
import com.dcx.demo.bean.Red;
import com.dcx.demo.bean.Yeall;
import com.dcx.demo.config.ComponentScanConfig;
import com.dcx.demo.config.ContextConfig;
import com.dcx.demo.config.ImportConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestBean {
    /***
     * 测试使用@Bean的方式来添加类
     */
    @Test
    public void testBean(){
        ApplicationContext context=new  AnnotationConfigApplicationContext(ContextConfig.class);
        Red red=context.getBean(Red.class);
        System.out.println(red);
        String [] beans=context.getBeanDefinitionNames();
        for (String name:beans) {
            System.out.println(name);
        }
    }
    /***
     * 测试bean的作用域：默认是单实列
     */
    @Test
    public void  testBeanScope(){
    ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfig.class);
    Red red=context.getBean(Red.class);
            Red red2=context.getBean(Red.class);
            System.out.println(red.equals(red2));//true
            Blue blue=context.getBean(Blue.class);
            Blue blue2=context.getBean(Blue.class);
            System.out.println(blue.equals(blue2));//false
        }

    /***
     * 测试懒加载
     */
    @Test
        public void testLzay(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ContextConfig.class);
        Yeall yeall=context.getBean(Yeall.class);//调用时，才会初始化
        }
    /***
     * 测试使用import的方式导入需要的bean
     */
    @Test
    public void testImport(){
    ApplicationContext context=new AnnotationConfigApplicationContext(ImportConfig.class);
        Blue b=context.getBean(Blue.class);
        String[] beans=context.getBeanDefinitionNames();
        for (String name:beans) {
            System.out.println(name);
        }
    }
    /***
     * 测试扫描注解
     */
    @Test
    public void testScan(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        String [] beans=context.getBeanDefinitionNames();
        for (String name:beans) {
            System.out.println(name);
        }
    }
}
