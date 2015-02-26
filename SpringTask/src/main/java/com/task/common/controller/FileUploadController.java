package com.task.common.controller;

import com.task.common.model.FileUpload;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Created by Musin on 26.02.2015.
 */
public class FileUploadController extends SimpleFormController {
    public FileUploadController() {
        setCommandClass(FileUpload.class);
        setCommandName("fileUploadForm");
    }

    @Override
    protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
        FileUpload file = (FileUpload)command;
        MultipartFile multipartFile = file.getFile();
        String fileName = "";
        if (multipartFile != null) {
            fileName = multipartFile.getOriginalFilename();
        }
        return new ModelAndView("FileUploadSuccess", "fileName", fileName);
    }

//    @Override
//    protected ModelAndView onSubmit(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object command, BindException errors) throws Exception {
//        FileUpload file = (FileUpload)command;
//        MultipartFile multipartFile = file.getFile();
//        String fileName = "";
//        if (multipartFile != null) {
//            fileName = multipartFile.getOriginalFilename();
//        }
//        return new ModelAndView("FileUploadSuccess", "fileName", fileName);
//    }
}
