package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.entity.*;

import java.util.List;
@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    EventDTO getEventDto(Event event);
    List<EventDTO> getEventsDto(List<Event> events);
    OrganizerDTO getOrganizerDTO(Organizer organizer);
    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    ParticipantDTO getParticipantDTO(Participant participant);

    List<ParticipantDTO> getParticipantDTO(List<Participant> participants);
    @Mapping(target = "roles", source = "user.roles")
    OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);
}