package com.github.sprise233.bumentong;

import com.github.sprise233.bumentong.dto.ResultDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class BumentongApplication {

    public static void main(String[] args) {
        SpringApplication.run(BumentongApplication.class, args);
    }



}
