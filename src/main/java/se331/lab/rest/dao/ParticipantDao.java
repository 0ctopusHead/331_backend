package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Participant;

import java.util.List;

public interface ParticipantDao {
    Page<Participant> getParticipant(Pageable pageRequest);


   List<Participant> findById(Long id);
}
