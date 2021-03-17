package lk.ijse.dep.web.institute.api.exceptin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: Yohan Ishara <yohanishara01@gmail.com>
 * @since : 2021-03-17
 **/
@RestControllerAdvice
public class AppWideExceptionHandler {
    Logger logger = LoggerFactory.getLogger(AppWideExceptionHandler.class);
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public String globalExceptionHandler(Throwable t){
        logger.error(null,t);
        return "something went wrong, please contact dep6 guys";
    }
}
