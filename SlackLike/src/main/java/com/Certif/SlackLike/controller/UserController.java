package com.Certif.SlackLike.controller;

import com.Certif.SlackLike.model.User;
import com.Certif.SlackLike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        if (userService.getAllUsers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(userService.getAllUsers());
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Integer id){
//        Optional<User> user = userService.getUserById(id);
//        if (user.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        else {
//           return ResponseEntity.ok(user);
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
        for(User u : userService.getAllUsers()){
            if(u.getId().equals(id))
                return ResponseEntity.ok(u);
        }
        return ResponseEntity.status(404).body("User with 'ID " + id + " not found");
    }

//    @PostMapping
//    public User addUser(@RequestBody User newUser){
//
//        return  userService.createUser(newUser);
//
//    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        userService.createUser(newUser);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
        if(userService.getUserById(id).isEmpty()){
            return ResponseEntity.status(404).body("User with ID " + id + " not found");
        }else{
            userService.deleteUser(id);
            return ResponseEntity.ok("ok");
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        if (user.getId() == null){
            return ResponseEntity.badRequest().body("Request Error : Missing User identifier");
        }
        if (!user.getId().equals(id)){
            return ResponseEntity.badRequest().body("Identifier values are different");
        }
        return ResponseEntity.ok(userService.updateUser( user));

    }

}
