package lk.ijse.dep.web.institute;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * @author: Yohan Ishara <yohanishara01@gmail.com>
 * @since : 2021-03-17
 **/
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@Import(JPAConfig.class)
public class AppConfig {
}
