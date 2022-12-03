package org.polytech.toeic.controller;


import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.service.ToeicUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ToeicUserController
{
    private final ToeicUserService toeicUserService;

    public ToeicUserController(ToeicUserService toeicUserService)
    {
        this.toeicUserService = toeicUserService;
    }

    @GetMapping("/admin/users")
    public List<ToeicUser> getUsers() {
        return toeicUserService.getUsers();
    }

    @GetMapping("/user")
    public Optional<ToeicUser> getUserById(@RequestParam int id) {
        return toeicUserService.getUserById(id);
    }

    @PutMapping("/newuser")
    public ToeicUser addUser(@RequestBody ToeicUser user)
    {
        return toeicUserService.addUser(user);

    }


}



