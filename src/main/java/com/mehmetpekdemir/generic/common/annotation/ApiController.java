package com.mehmetpekdemir.generic.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public @interface ApiController {

}