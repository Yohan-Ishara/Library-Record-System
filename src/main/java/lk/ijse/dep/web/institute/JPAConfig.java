package lk.ijse.dep.web.institute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: Yohan Ishara <yohanishara01@gmail.com>
 * @since : 2021-03-17
 **/
@EnableTransactionManagement
@Configuration
@PropertySource("classpath:/application.properties")
public class JPAConfig {

    @Autowired
    private Environment env;


}
