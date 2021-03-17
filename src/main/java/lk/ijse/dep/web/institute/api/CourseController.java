package lk.ijse.dep.web.institute.api;

import lk.ijse.dep.web.institute.business.custom.CourseBO;
import lk.ijse.dep.web.institute.dto.CourseDTO;
import lk.ijse.dep.web.institute.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * @author: Yohan Ishara <yohanishara01@gmail.com>
 * @since : 2021-03-17
 **/
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    private CourseBO courseBO;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CourseDTO> getAllCourses() throws Exception {
        return courseBO.getAllCourses();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCourse(@RequestBody CourseDTO course) throws Exception {
      courseBO.saveCourse(course);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code:C\\d{3}}")
    public void deleteCourse(@PathVariable String code, @RequestBody CourseDTO course) throws Exception {
        course.setCode(code);
        courseBO.deleteCourse(code);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{code:C\\d{3}}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCourse(@RequestBody CourseDTO course) throws Exception {
        courseBO.updateCourse(course);
    }

}
