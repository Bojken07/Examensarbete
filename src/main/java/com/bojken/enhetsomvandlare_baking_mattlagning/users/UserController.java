package com.bojken.enhetsomvandlare_baking_mattlagning.users;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @DeleteMapping("/delete_user/{id}")
    private void deleteUserById(@PathVariable("id") long id) {
        this.userService = userService;
    }
}
