package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;

import java.util.List;

public interface ParticipantRepository  extends JpaRepository<Participant, Long> {
}
