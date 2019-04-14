package com.virtualelection.cloudproject1.Controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.virtualelection.cloudproject1.Model.Election;
import com.virtualelection.cloudproject1.repository.electionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class electionController {


    @Autowired

    private electionRepository electionRepository;


    @GetMapping("/Election")

    public List<Election> getAllUsers() {

        return electionRepository.findAll();

    }

    @GetMapping("/Election/{id}")

    public ResponseEntity<Election> getUsersById(@PathVariable(value = "id") Long electionId)

            throws ResourceNotFoundException {

        Election election =

                electionRepository

                        .findById(electionId)

                        .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

        return ResponseEntity.ok().body(election);

    }

    @PostMapping("/Election")

    public Election createElection(@Valid @RequestBody Election election) {

        return electionRepository.save(election);


    }
    @PutMapping("/Election/{id}")

    public ResponseEntity<Election> updateElection(

            @PathVariable(value = "id") Long electionId, @Valid @RequestBody Election electionDetails)

            throws ResourceNotFoundException {

        Election election =

                electionRepository

                        .findById(electionId)

                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + electionId));

        election.setTitle(electionDetails.getTitle());
        election.setEndTime(electionDetails.getEndTime());
        election.setStartTime(electionDetails.getStartTime());
        election.setListOfChoice(electionDetails.getListOfChoice());
        election.setNumberOfVotes(electionDetails.getNumberOfVotes());
        final Election updatedElection = electionRepository.save(election);

        return ResponseEntity.ok(updatedElection);

    }


    @DeleteMapping("/Election/{id}")

    public Map<String, Boolean> deleteElection(@PathVariable(value = "id") Long electionId) throws Exception {

        Election election =

                electionRepository

                        .findById(electionId)

                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + electionId));

        electionRepository.delete(election);

        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", Boolean.TRUE);

        return response;

    }

}