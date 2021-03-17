package lk.ijse.dep.web.institute.api;

import lk.ijse.dep.web.institute.AppInitializer;
import lk.ijse.dep.web.institute.business.custom.StudentBO;
import lk.ijse.dep.web.institute.business.custom.StudentCourseBO;
import lk.ijse.dep.web.institute.dto.StudentDTO;
import lk.ijse.dep.web.institute.exception.HttpResponseException;
import lk.ijse.dep.web.institute.exception.ResponseExceptionUtil;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-07
 **/
@WebServlet(name = "StudentServlet", urlPatterns = "/api/v1/students/*")
public class StudentServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();

        try{
            resp.setContentType("application/json");
            StudentBO studentBO = AppInitializer.getContext().getBean(StudentBO.class);

            resp.getWriter().println(jsonb.toJson(studentBO.getAllStudents()));
        } catch (Throwable t) {
            ResponseExceptionUtil.handle(t, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();


        try{
            StudentDTO dto = jsonb.fromJson(req.getReader(), StudentDTO.class);

            if ( dto.getStudentName().trim().isEmpty() || dto.getContact().trim().isEmpty() || dto.getDob() == null ||
                    dto.getGender() == null || dto.getNo().trim().isEmpty() || dto.getAddressLine1().trim().isEmpty() ||
                    dto.getCity().trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid student details", null);
            }

            StudentBO studentBO = AppInitializer.getContext().getBean(StudentBO.class);

            studentBO.saveStudent(dto);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.setContentType("application/json");
            resp.getWriter().println(jsonb.toJson(dto));
        } catch (SQLIntegrityConstraintViolationException exp) {
            throw new HttpResponseException(400, "Duplicate entry", exp);
        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try{
            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid student id", null);
            }

            String id = req.getPathInfo().replace("/", "");
            Jsonb jsonb = JsonbBuilder.create();
            StudentDTO dto = jsonb.fromJson(req.getReader(), StudentDTO.class);

            if (dto.getStudentName().trim().isEmpty() || dto.getContact().trim().isEmpty() || dto.getDob() == null ||
                    dto.getGender() == null || dto.getNo().trim().isEmpty() || dto.getAddressLine1().trim().isEmpty() ||
                    dto.getCity().trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid details", null);
            }

            StudentBO studentBO =AppInitializer.getContext().getBean(StudentBO.class);

            dto.setId(Integer.parseInt(id));
            studentBO.updateStudent(dto);
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

        } catch (JsonbException exp) {
            throw new HttpResponseException(400, "Failed to read the JSON", exp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{

            if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").trim().isEmpty()) {
                throw new HttpResponseException(400, "Invalid customer id", null);
            }

            String id = req.getPathInfo().replace("/", "");

            StudentBO studentBO = AppInitializer.getContext().getBean(StudentBO.class);

            studentBO.deleteStudent(Integer.parseInt(id));
            resp.setStatus(HttpServletResponse.SC_NO_CONTENT);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
