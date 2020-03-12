package com.cah.cahdmsp.controller;

import com.cah.cahdmsp.result.EasyUIResult;
import com.cah.cahdmsp.service.OutrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/outrecord")
public class OutrecordController {
    
    @Autowired
    OutrecordService outrecordService;

    // 展示所有出库记录
    @RequestMapping("/showAllOutrecord")
    @ResponseBody
    public EasyUIResult showAllOutrecord(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return outrecordService.showAllOutrecord(page, rows);
    }
}
