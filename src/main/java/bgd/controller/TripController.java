package bgd.controller;

import bgd.domain.Trip;
import bgd.dto.TripDTO;
import bgd.mapper.AbstractMapper;
import bgd.mapper.TripMapper;
import bgd.service.AbstractService;
import bgd.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/trips")
@RestController
@AllArgsConstructor
public class TripController extends AbstractController<Trip, TripDTO, Integer> {
    private final TripService tripService;
    private final TripMapper tripMapper;


    @Override
    protected AbstractService<Trip, Integer> getService() {
        return tripService;
    }

    @Override
    protected AbstractMapper<Trip, TripDTO> getMapper() {
        return tripMapper;
    }
}
