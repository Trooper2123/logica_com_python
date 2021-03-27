package com.backend.vote.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository repository;


    public Vote insert(Vote vote) {
        return repository.save(vote);
    }

    public Integer countVotes(Long votePollId, Byte vote){
        return repository.countVotes(votePollId,vote);
    }
}
