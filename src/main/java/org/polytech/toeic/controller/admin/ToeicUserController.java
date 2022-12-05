package org.polytech.toeic.controller.admin;


import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.service.ToeicUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public class ToeicUserController
{
    private final ToeicUserService toeicUserService;

    public ToeicUserController(ToeicUserService toeicUserService)
    {
        this.toeicUserService = toeicUserService;
    }

    @GetMapping("/users")
    public List<ToeicUser> getUsers() {
        return toeicUserService.getUsers();
    }

    @GetMapping("/user")
    public Optional<ToeicUser> getUserById(@RequestParam int id) {
        return toeicUserService.getUserById(id);
    }

    @PostMapping("user")
    public void addUser(@RequestBody ToeicUser user)
    {
        user.setPassword(toeicUserService.passwordEncoder.encode(user.getPassword()));
        toeicUserService.addUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable int id)
    {
        Optional<ToeicUser> user = toeicUserService.getUserById(id);
        toeicUserService.deleteUser(user.get());
    }


}



