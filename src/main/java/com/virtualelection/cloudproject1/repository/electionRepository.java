package com.virtualelection.cloudproject1.repository;


import com.virtualelection.cloudproject1.Model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository


public interface electionRepository extends JpaRepository<Election, Integer> {
}
