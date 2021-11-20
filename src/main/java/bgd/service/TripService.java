package bgd.service;

import bgd.domain.Trip;
import bgd.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TripService extends AbstractService<Trip, Integer> {
    public TripRepository tripRepository;

    @Override
    protected JpaRepository<Trip, Integer> getRepository() {
        return tripRepository;
    }
}