package com.shahriar.demo2.annotations;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target({ElementType. TYPE})
@Retention(RetentionPolicy. RUNTIME)
@Documented
@RestController
@CrossOrigin({"GET","POST","PUT","DELETE"})
@ResponseBody

public @interface ApiController {

}
