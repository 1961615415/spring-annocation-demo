package com.dcx.demo.config;

import com.dcx.demo.bean.Red;
import com.dcx.demo.scan.ScanBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/***
 * 扫描注解
 */

/**
 * The class or classes to use as the filter.
 * <p>The following table explains how the classes will be interpreted
 * based on the configured value of the {@link #type} attribute.
 * <table border="1">
 * <tr><th>{@code FilterType}</th><th>Class Interpreted As</th></tr>
 * <tr><td>{@link FilterType#ANNOTATION ANNOTATION}</td>
 * <td>the annotation itself</td></tr>
 * <tr><td>{@link FilterType#ASSIGNABLE_TYPE ASSIGNABLE_TYPE}</td>
 * <td>the type that detected components should be assignable to</td></tr>
 * <tr><td>{@link FilterType#CUSTOM CUSTOM}</td>
 * <td>an implementation of {@link TypeFilter}</td></tr>
 * </table>
 * <p>When multiple classes are specified, <em>OR</em> logic is applied
 * &mdash; for example, "include types annotated with {@code @Foo} OR {@code @Bar}".
 * <p>Specifying zero classes is permitted but will have no effect on component
 * scanning.
 * @since 4.2
 * @see #value
 * @see #type
 */
/***
 * excludeFilters：排除过滤的类型：
 * ANNOTATION 注解
 * ASSIGNABLE_TYPE 类型
 * ASPECTJ asprctj表达式
 * REGEX 正则表达式
 * CUSTOM  自定义（重要的）org.springframework.core.type.filter.TypeFilter implementation
 */
@Configuration
@ComponentScan(value="com.dcx.demo.scan",
        useDefaultFilters=true,
       /* excludeFilters =@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes = {ScanBean.class}),*/
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {Red.class})
)
public class ComponentScanConfig {
    @Bean(name="scan")
    public ScanBean getScan(){
        return new ScanBean();
    }
    @Bean(name="read")
    public Red getRead(){
        return new Red();
    }

}
