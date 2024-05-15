package com.example.project.controller;

import com.example.project.service.AreaService;
import com.example.project.vo.AreaVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author niuzheju
 * @Date 14:23 2024/4/25
 */
@RestController
public class AreaController {

    @Setter(onMethod_ = @Autowired)
    private AreaService areaService;

    @GetMapping("/getAreaById")
    public AreaVO getAreaById(@RequestParam Long id) {
        return areaService.getAreaById(id);
    }
}
