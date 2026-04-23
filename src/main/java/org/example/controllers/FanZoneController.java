package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FanZoneController {
    @GetMapping("/fan-zone")
    public String getFanZonePage(){
        return "fan-zone";
    }
}
