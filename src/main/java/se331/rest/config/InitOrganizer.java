package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Organizer;
import se331.rest.repository.OrganizerRepository;

@Component
public class InitOrganizer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .organizerName("Hin Krit")
                .address("Chiang Mai")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizerName("JoJo Yasintorn")
                .address("Chiang Mai")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizerName("Poom Nitipoom")
                .address("Chiang Mai")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizerName("Sin Paduakkiat")
                .address("Chiang Mai")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizerName("Mark Mark")
                .address("Chiang Mai")
                .build());
        organizerRepository.save(Organizer.builder()
                .organizerName("Jame Jame")
                .address("Chiang Mai")
                .build());

    }
}
