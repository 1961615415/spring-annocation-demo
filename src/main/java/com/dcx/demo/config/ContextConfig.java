package com.dcx.demo.config;

import com.dcx.demo.bean.Blue;
import com.dcx.demo.bean.Red;
import com.dcx.demo.bean.Yeall;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class ContextConfig {
    @Bean
    public Red getRed(){
        return new Red();
    }
/**
 * Specifies the name of the scope to use for the annotated component/bean.
 * <p>Defaults to an empty string ({@code ""}) which implies
 * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
 * @since 4.2
 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
 * @see #value
 */
    /***
     * String SCOPE_SINGLETON = "singleton"; 单例模式 默认是 从容器中类似于map.get的方式来取数据
    * 	String SCOPE_PROTOTYPE = "prototype";多例模式
     *
     * @return
     */

    /*String SCOPE_REQUEST = "request"; 一次请求
    String SCOPE_SESSION = "session"; 一个session
    */

    /***
     * 如果一个bean被声明为单例的时候，
     * 在处理多次请求的时候在spring 容器里只实例化出一个bean，
     * 后续的请求都公用这个对象，这个对象会保存在一个map里面。
     * 当有请求来的时候会先从缓存(map)里查看有没有，
     * 有的话直接使用这个对象，没有的话才实例化一个新的对象，
     * 所以这是个单例的。
     * 但是对于原型(prototype)bean来说当每次请求来的时候直接实例化新的bean，
     * 没有缓存以及从缓存查的过程
     *优势：提高性能！！！从几个方面：1.少创建实例2.减少垃圾回收3.缓存快速获取
     * 劣势：线程安全
     *
     * @return
     */
    @Scope("prototype")
    @Bean
        public Blue getBlue(){
            return new Blue();
    }

    /***
     * 懒加载：默认是ioc容器初始化时就初始化bean,
     * 使用懒加载是使用该bean时，再初始化
     * @return
     */
    @Lazy
    @Bean(name = "yeall")
    public Yeall getYeall(){
        return new Yeall();
    }
}
