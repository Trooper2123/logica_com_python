package com.backend.vote.vote;

import com.backend.vote.jsonDeserializer.UserJsonDeserializer;
import com.backend.vote.jsonDeserializer.VotingPollJsonDeserializer;
import com.backend.vote.user.User;
import com.backend.vote.voting.VotingPoll;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "tb_vote")
@Getter
public class Vote {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonDeserialize(using = UserJsonDeserializer.class)
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "votingpoll_id")
    @JsonDeserialize(using = VotingPollJsonDeserializer.class)
    private VotingPoll votingPoll_id;

    private byte vote;

}
