package com.task.common.controller;

import com.task.common.model.Customer;
import com.task.common.model.FileUpload;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Musin on 26.02.2015.
 */
public class FileUploadController extends SimpleFormController {
    public FileUploadController() {
        setCommandClass(FileUpload.class);
        setCommandName("fileUploadForm");
    }

//    @Override
//    protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
//        FileUpload file = (FileUpload)command;
//        MultipartFile multipartFile = file.getFile();
//        String fileName = "";
//        Customers cust = null;
//        if (multipartFile != null) {
//            fileName = multipartFile.getOriginalFilename();
//            // Как-то тут разбираем файл
//            cust = new Customers();
//            cust.setCustomers(XmlFileParser.parseFile(fileName);
//        }
//        return new ModelAndView("FileUploadSuccess", "fileName", fileName);
//    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        FileUpload file = (FileUpload)command;
        MultipartFile multipartFile = file.getFile();
        String fileName = "";
        Customers cust = null;
        if (multipartFile != null) {
            fileName = multipartFile.getOriginalFilename();
            File f = new File("temp.xml");
            multipartFile.transferTo(f);
            cust = new Customers();
            cust.setCustomers(XmlFileParser.parseFile(f));
            request.getSession().setAttribute("customers", cust);
        }
        return new ModelAndView("FileUploadSuccess", "fileName", cust.getCustomers().get(0).getOrders().get(0).getPositions().size());
    }
}
