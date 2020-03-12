package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.service.InrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/inrecord")
public class InrecordController {

    @Autowired
    InrecordService inrecordService;

    // 展示所有入库记录
    @RequestMapping("/showAllInrecord")
    @ResponseBody
    public EasyUIResult showAllInrecord(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return inrecordService.showAllInrecord(page, rows);
    }
}
