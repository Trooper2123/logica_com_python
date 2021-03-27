package com.backend.vote.vote;

import com.backend.vote.user.User;
import com.backend.vote.voting.Voting;

import javax.persistence.*;

@Entity
@Table(name = "tb_vote")
public class Vote {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "voting_id")
    private Voting voing;

    private Integer vote;

}
