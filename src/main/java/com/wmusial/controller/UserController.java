package com.wmusial.controller;

import com.wmusial.model.User;
import com.wmusial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    //zamiast wstawiania konstruktora, w którym tworzy się nowy obiekt UserRepository podobnie jak było z UserDao
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {

        List<User> users = userRepository.findAll();

        model.addAttribute("usersList", users);

        return "users";
    }
    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public String getUserCreate() {
        return "formularz";
    }
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String createUser(@RequestParam(name = "imie") String firstName, @RequestParam(name = "nazwisko") String lastName, @RequestParam String email) {

        User user = new User(firstName, lastName, email);
        userRepository.save(user);
        return "redirect:/users";
    }

//    @RequestParam(name = "id") Long id

    @RequestMapping(value = "/users/update", method = RequestMethod.GET)
    public String getUserUpdate(@RequestParam(name = "id") Long id, Model model) { //wlasciwie nie musisz mapować name = id z jsp z nazwa Long id, bo są takie same.
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "formularz-edycji";

    }
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(name = "id") Long id, @RequestParam(name = "imie") String firstName, @RequestParam(name = "nazwisko") String lastName, @RequestParam String email) {

        User user = new User(id, firstName, lastName, email);
        userRepository.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam Long id) {

        userRepository.delete(id);
        return "redirect:/users";
    }

}