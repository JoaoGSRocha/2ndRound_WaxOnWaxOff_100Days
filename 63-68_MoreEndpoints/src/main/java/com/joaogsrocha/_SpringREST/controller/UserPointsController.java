package com.joaogsrocha._SpringREST.controller;

import com.joaogsrocha._SpringREST.model.userpoints.UserPoints;
import com.joaogsrocha._SpringREST.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/userpoints")
public class UserPointsController {
    @Autowired
    private GenericService<UserPoints> userPointsRepository;

    @RequestMapping(value = "findall",
            method = RequestMethod.GET,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Iterable<UserPoints>> findAll() {
        try {
            return new ResponseEntity<Iterable<UserPoints>>(
                    userPointsRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Iterable<UserPoints>>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "create/{userid}",
            method = RequestMethod.POST,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<UserPoints> create(@RequestBody UserPoints userPoints,
                                             @PathVariable("userid") Long userid) {
        try {
            UserPoints nuserPoints = userPointsRepository.create(userPoints);
            userPoints.setPoints(0);
            userPoints.setUserid(userid);
            return new ResponseEntity<UserPoints>(nuserPoints,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<UserPoints>(
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "update",
            method = RequestMethod.PUT,
            produces =  {MimeTypeUtils.APPLICATION_JSON_VALUE},
            consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE},
            headers = "Accept=application/json")
    public ResponseEntity<Void> update(@RequestBody UserPoints userPoints) {
        try {
            userPointsRepository.update(userPoints);
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
            userPointsRepository.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(
                    HttpStatus.BAD_REQUEST);
        }
    }
}