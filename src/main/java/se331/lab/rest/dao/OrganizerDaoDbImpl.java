package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class OrganizerDaoDbImpl implements OrganizerDao{
    final OrganizerRepository organizerRepository;
    @Override
    public Integer getOrganizerSize(){
        return  Math.toIntExact(organizerRepository.count());
    }
    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page){
        return organizerRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Organizer save(Organizer organizer){
        return organizerRepository.save(organizer);
    }
}
