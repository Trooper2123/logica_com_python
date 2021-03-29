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
        VotingPoll votingPoll = VotingPoll.builder()
                .subject(obj.getSubject())
                .openTime(obj.getOpenTime())
                .closeTime(obj.getCloseTime())
                .status(obj.setStatus(obj.getCloseTime()))
                .createdTime(obj.getCreatedTime()).build();
                obj = service.insert(votingPoll);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(votingPoll.getId()).toUri();
        return ResponseEntity.created(uri).body(votingPoll);
    }

}
