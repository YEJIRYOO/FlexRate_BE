package com.sbb.flexrate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")//swagger 임시 main
@Api(tags = "Main Controller")
public class MainController {

    @GetMapping("/hello")
    @ApiOperation(value = "간단한 테스트API",notes = "swagger 테스트")
    public String hello(){
        return "작동!!";
    }
}
