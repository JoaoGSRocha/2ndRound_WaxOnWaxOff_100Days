package com.joaogsrocha._SpringREST.controller;

import com.google.gson.Gson;
import com.joaogsrocha._SpringREST.model.user.User;
import com.joaogsrocha._SpringREST.services.GenericService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private GenericService<User> userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "findall",
            method = RequestMethod.GET,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Iterable<User>> findAll() {
        try {
            return new ResponseEntity<Iterable<User>>(
                    userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<User>>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "create",
            method = RequestMethod.POST,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
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
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        try {
            userRepository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(
                    HttpStatus.BAD_REQUEST);
        }
    }
}
