package se331.lab.rest.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
