package org.polytech.toeic.controller.accessible;


import org.polytech.toeic.entity.Set;
import org.polytech.toeic.service.SetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class SetController {

    private final SetService setService;

    public SetController(SetService setService)
    {
        this.setService = setService;
    }

    @PostMapping("/set")
    public Set AddSet(@RequestBody Set set)
    {
        setService.AddSet(set);
        return set;

    }
    @GetMapping("/sets")
    public List<Set> getAllSet()
    {
        return setService.findAll();
    }

}
