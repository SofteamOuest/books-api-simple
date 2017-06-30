package com.softeam.pocs.helloworld.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elkouhen on 27/06/17.
 */
@RestController
@RequestMapping(path = "/helloworld")
public class HelloworldResource {

    @GetMapping
    public String helloworld() {
        return "helloworld";
    }

}
