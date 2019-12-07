package io.zipcoder.tc_spring_poll_application.controller;

import dtos.VoteResult;
import io.zipcoder.tc_spring_poll_application.domain.Vote;
import io.zipcoder.tc_spring_poll_application.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputeResultsController {

    private VoteRepository voteRepository;

    @Autowired
    public ComputeResultsController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public ResponseEntity<?> computeResult(@RequestParam Long pollId)   {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);

        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }
}
