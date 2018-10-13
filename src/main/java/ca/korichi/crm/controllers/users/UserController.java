package ca.korichi.crm.controllers.users;

import ca.korichi.crm.services.users.User;
import ca.korichi.crm.services.users.UserId;
import ca.korichi.crm.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(
        value = "/users",
        consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{user-id}")
    ResponseEntity<User> findById(@PathVariable("user-id") String userId) {

        return ResponseEntity.ok(userService.findById(new UserId(userId)));
    }

    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity
                .created(URI.create("/users/" + createdUser.getUserId()))
                .body(createdUser);
    }


}
