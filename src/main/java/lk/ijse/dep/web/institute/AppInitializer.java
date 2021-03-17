package lk.ijse.dep.web.institute;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

/**
 * @author: Yohan Ishara <yohanishara01@gmail.com>
 * @since : 2021-03-17
 **/
public class AppInitializer {
    private static AnnotationConfigApplicationContext ctx = buildApplicationContext();

    private static AnnotationConfigApplicationContext buildApplicationContext() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        return ctx;
    }
    public static AnnotationConfigApplicationContext getContext(){
        return ctx;
    }
}
