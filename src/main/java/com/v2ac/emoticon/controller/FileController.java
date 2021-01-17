package com.v2ac.emoticon.controller;


import com.v2ac.emoticon.common.Code;
import com.v2ac.emoticon.common.Response;
import com.v2ac.emoticon.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Response setFileUpload(@RequestParam(value = "file") MultipartFile file) {
        Response res = null;

        if (!file.isEmpty()) {
            Map<String, Object> map = fileService.upload(file);
            if (map != null) {
                res = Response.ok(map);
            } else {
                res = Response.error(Code.FILE_UPLOAD_ERR);
            }

        } else {
            res = Response.error(Code.FILE_UPLOAD_NULL);
        }

        return res;
    }

}
