package com.backend.vote.voting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/poll")
public class VotingPollController {

    private final VotingPollService service;

    @Autowired
    public VotingPollController(VotingPollService service) {
        this.service = service;
    }
    @GetMapping(value = "/id={id}")
    public ResponseEntity<VotingPoll> findById(@PathVariable Long id) {
        VotingPoll obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<VotingPoll>> findAll() {
        List<VotingPoll> votingPollList = service.findAll();
        return ResponseEntity.ok().body(votingPollList);
    }


    @PostMapping
    public ResponseEntity<VotingPoll> insert(@RequestBody VotingPoll obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
