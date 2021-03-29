package com.backend.vote.voting;

import com.backend.vote.vote.VoteService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;

@Slf4j
@Data
@Entity
@Table(name = "tb_votingpoll")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    private Status status;

    private Result result;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdTime = LocalDateTime.now();

    public void setCloseTime(LocalDateTime closeTime) {
            if (closeTime.isAfter(openTime)) {
                this.closeTime = closeTime;
            } else {
                log.warn("Close time need to be greater than Open time");
            }
        }

    public void setOpenTime(LocalDateTime openTime) {
        if (!openTime.isBefore(createdTime)) {
            this.openTime = openTime;
        } else {
            log.warn("Open time can't be in the past");
        }
    }


    public Status setStatus(LocalDateTime closeTime) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (closeTime.isBefore(localDateTime)) {
            return Status.CLOSE;
        } else {
            return Status.OPEN;
        }
    }

    public Result setResult(Long id, byte vote) {
        VoteService voteService = new VoteService();
        if (getStatus().equals(Status.CLOSE)) {
            if (voteService.countVotes(id, (byte) 0) > voteService.countVotes(id, (byte) 1)) {
                return Result.REJECTED;
            } else {
                return Result.APPROVED;
            }
        } else {
            return Result.OPEN;
        }
    }
}