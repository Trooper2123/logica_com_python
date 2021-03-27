package com.backend.vote.voting;

import com.backend.vote.vote.VoteService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Data
@Entity
@Table(name = "tb_votingpoll")
public class VotingPoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String subject;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime openTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime closeTime;

    private enum status {OPEN, CLOSE}

    ;

    private enum result {APPROVED, REJECTED}

    ;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdTime = LocalDateTime.now();

    public void setCloseTime(LocalDateTime closeTime) {
        if (closeTime.isBefore(createdTime)) {
            this.closeTime = closeTime;
        } else {
            log.warn("Close time need to be greater than Open time");
        }
    }

    public void setOpenTime(LocalDateTime openTime) {
        if (!openTime.isAfter(createdTime)) {
            this.openTime = openTime;
        } else {
            log.warn("Open time can't be in the past");
        }
    }


    public status setStatus(LocalDateTime closeTime) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (closeTime.isAfter(localDateTime)) {
            return status.CLOSE;
        } else {
            return status.OPEN;
        }
    }

    public result getResult(Long id, byte vote) {
        VoteService voteService = new VoteService();
        if (voteService.countVotes(id, (byte) 0) > voteService.countVotes(id, (byte) 1))
        {
            return result.REJECTED;
        }else{
            return result.APPROVED;
        }
    }
}