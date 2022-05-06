package com.codejam.demo.repository;

import com.codejam.demo.config.FeignConfig;
import com.codejam.demo.dto.ServiceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "serviceRepository", configuration = FeignConfig.class, url = "${demoService}", decode404 = true)
public interface DemoServiceRepositiry {

    @GetMapping("demo/find/demoService/{id}")
    ServiceDto findInstituteById(@RequestHeader("authorization") String authorization,
                                 @PathVariable("id") Integer id);
}
