package se331.lab.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.dao.ParticipantDao;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    final EventDao eventDao;
    final OrganizerDao organizerDao;
    final ParticipantDao participantsDao;
    @Override
    public Integer getEventSize(){
        return eventDao.getEventSize();
    }
    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page){
        return eventDao.getEvents(pageSize,page);
    }

    @Override
    public Event getEvent(Long id){
        return eventDao.getEvent(id);
    }
    @Override
    @Transactional
    public Event save(Event event){
        Organizer organizer = organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        return eventDao.save(event);
    }
    @Override
    public Page<Event> getEvents(String title, Pageable page){
        return eventDao.getEvents(title, page);
    }
}
