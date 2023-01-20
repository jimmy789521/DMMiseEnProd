package org.polytech.toeic.controller;


import org.polytech.toeic.service.SetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class SetController {

    private final SetService setService;

    public SetController(SetService setService)
    {
        this.setService = setService;
    }


}
