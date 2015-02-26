package com.task.common.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Musin on 26.02.2015.
 */
public class FileUpload {
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    MultipartFile file;
}
