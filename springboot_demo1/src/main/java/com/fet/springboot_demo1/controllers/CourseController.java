package com.fet.springboot_demo1.controllers;

import com.fet.springboot_demo1.beans.CourseForm;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Slf4j
@Controller
public class CourseController implements WebMvcConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class.getName());

    @GetMapping("/course")
    public String showForm(CourseForm form1){
        //form1.setCourseId("SBMVC");
        //form1.setCourseName("FET");
        //form1.setDuration(10);
        return "courseForm";
    }

    @PostMapping("/course")
    public String checkCourseInfo(@Valid CourseForm form1, BindingResult bindingResult) {
        //System.out.println(form1);
        //LOGGER.info("course={}",form1);
        log.info("course={}",form1);
        if (bindingResult.hasErrors()) {
            log.info("{}",bindingResult);
            return "courseForm";
        }
        //return "result"; // will change later
        return "redirect:/result";
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/result").setViewName("result");
    }
}
