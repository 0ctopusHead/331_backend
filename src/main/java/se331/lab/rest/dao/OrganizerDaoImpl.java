package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123L)
                .organizer("Kat Laydee")
                .address("Meow Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(456L)
                .organizer("Fern Pollin")
                .address("Floral City")
                .build());
        organizerList.add(Organizer.builder()
                .id(789L)
                .organizer("Carey Wales")
                .address("Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(1001L)
                .organizer("Dawg Dahd")
                .address("Woof Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(1002L)
                .organizer("Kahn Opiner")
                .address("Tin City")
                .build());
        organizerList.add(Organizer.builder()
                .id(1003L)
                .organizer("Brody Kill")
                .address("Highway 50")
                .build());
    }
    @Override
    public Integer getOrganizerSize(){
        return  organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page){
      pageSize = pageSize == null ? organizerList.size():pageSize;
      page = page == null ? 1 : page;
      int firstIndex = (page - 1) * pageSize;
      return new PageImpl<Organizer>(organizerList.subList(firstIndex, firstIndex + pageSize), PageRequest.of(page, pageSize), organizerList.size());
    }
    @Override
    public Organizer save(Organizer organizer){
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
