package org.polytech.toeic.controller.accessible;

import org.polytech.toeic.entity.ToeicUser;
import org.polytech.toeic.service.ToeicUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/public")
public class PublicToeicUserController {

    private final ToeicUserService toeicUserService;

    public PublicToeicUserController(ToeicUserService toeicUserService)
    {
        this.toeicUserService = toeicUserService;
    }

    @PutMapping("user")
    public void updateUser(@RequestBody ToeicUser user)
    {
        user.setPassword(toeicUserService.passwordEncoder.encode(user.getPassword()));
        toeicUserService.updateToeicUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable int id)
    {
        Optional<ToeicUser> user = toeicUserService.getUserById(id);
        toeicUserService.deleteUser(user.get());
    }

    @PostMapping("/user")
    public void addUser(@RequestBody ToeicUser user)
    {
        user.setPassword(toeicUserService.passwordEncoder.encode(user.getPassword()));
        toeicUserService.addUser(user);
    }

}
