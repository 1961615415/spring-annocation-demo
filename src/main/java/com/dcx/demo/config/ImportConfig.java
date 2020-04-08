package com.dcx.demo.config;

import com.dcx.demo.bean.Blue;
import com.dcx.demo.bean.Yeall;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/***
 * 使用import导入需要的bean,使用第三方的bean时，可以这样使用
 */
@Configuration
@Import({Blue.class, Yeall.class})
public class ImportConfig {
}
