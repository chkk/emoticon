package com.v2ac.emoticon.controller;


import com.v2ac.emoticon.common.response.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public Response setFileUpload() {

        Response res = Response.ok("hello emoticon!");

        return res;
    }

}
