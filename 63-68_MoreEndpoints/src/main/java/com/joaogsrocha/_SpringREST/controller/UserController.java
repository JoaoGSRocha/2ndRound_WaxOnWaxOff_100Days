package com.joaogsrocha._SpringREST.controller;

import com.google.gson.Gson;
import com.joaogsrocha._SpringREST.model.CustomPrincipal;
import com.joaogsrocha._SpringREST.model.user.User;
import com.joaogsrocha._SpringREST.services.implementation.UserServiceImpl;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userRepository;

    @Autowired
    private RestTemplate restTemplate;
    private User user;

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('role_admin')")
    public String context() {
        CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return principal.getUsername() + " " + principal.getEmail() + " " + principal.getId();
    }

   @GetMapping("/findall")
    public ResponseEntity<Iterable<User>> findAll() {

        try {
            CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            if(!principal.getUsername().equals("admin"))
                return new ResponseEntity<Iterable<User>>(
                        HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<Iterable<User>>(
                    userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<User>>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('role_user')")
    public ResponseEntity<User> find(@PathVariable("id") Long id) {
        try {
            CustomPrincipal principal = (CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
                    .getPrincipal();
            if(!principal.getId().equals(String.valueOf(id)))
                return new ResponseEntity<User>(
                        HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<User>(
                    userRepository.find(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('role_admin')")
    public ResponseEntity<User> create(@RequestBody User user) {
        try {
            User nuser = userRepository.create(user);

            restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject personJsonObject = new JSONObject();
            personJsonObject.put("userid", 1);

            HttpEntity<String> request =
                    new HttpEntity<String>(personJsonObject.toString(), headers);


            String personResultAsJsonStr =
                    restTemplate.postForObject("http://localhost:9002/api/userpoints/create/"+user.getId(), request, String.class );
            System.out.print(new Gson().toJson(nuser).toString());
            return new ResponseEntity<User>(nuser,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<User>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "update",
            method = RequestMethod.PUT,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Void> update(@RequestBody User user) {
        try {
            userRepository.update(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "delete/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            userRepository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(
                    HttpStatus.BAD_REQUEST);
        }
    }
}
