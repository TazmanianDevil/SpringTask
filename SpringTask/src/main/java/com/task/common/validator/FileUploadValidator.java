package com.task.common.validator;

import com.task.common.model.FileUpload;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Musin on 26.02.2015.
 */
public class FileUploadValidator implements Validator {
    @Override
    public boolean supports(Class aClass) {
        return FileUpload.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FileUpload file = (FileUpload)o;
        if (file.getFile().getSize() == 0) {
            errors.rejectValue("file", "required.fileUpload");
        }
    }
}
