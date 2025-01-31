package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.lab.rest.security.user.User;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    @OneToMany(mappedBy = "organizer")
    @Builder.Default// Build the data provided in a default state
    List<Event> ownEvents = new ArrayList<>();
    @OneToOne
    User user;
    @ElementCollection
    List<String> image;
}
