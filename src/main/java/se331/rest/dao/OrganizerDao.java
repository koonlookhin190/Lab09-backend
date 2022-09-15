package se331.rest.dao;
import se331.rest.entity.Organizer;
import org.springframework.data.domain.Page;

public interface OrganizerDao {
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);

    Organizer saveOrgan(Organizer organizer);
}


