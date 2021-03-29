package com.backend.vote.voting;

import com.backend.vote.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotingPollService {
    @Autowired
    private VotingPollRepository repository;

    public VotingPoll findById(Long id) {
        Optional<VotingPoll> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public List<VotingPoll> findAll() {
        return repository.findAll();
    }

    public VotingPoll insert(VotingPoll obj) {
        return repository.save(obj);
    }
}
