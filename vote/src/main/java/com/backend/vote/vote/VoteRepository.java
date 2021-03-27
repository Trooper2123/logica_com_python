package com.backend.vote.vote;

import com.backend.vote.voting.VotingPoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface VoteRepository extends JpaRepository<Vote,Long> {

    @Query(value = "SELECT count (Vote.Id) FROM Vote v where v.votingPoll_id = :votingpoll_id and v.vote = :vote "
            ,nativeQuery = true)
    Integer countVotes(
        @Param("votingpoll_id") Long votingpoll_id , @Param("vote") Byte vote);
    }

