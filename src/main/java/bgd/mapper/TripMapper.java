package bgd.mapper;

import bgd.domain.Trip;
import bgd.dto.TripDTO;
import org.springframework.stereotype.Component;

@Component
public class TripMapper extends AbstractMapper<Trip, TripDTO>{
    @Override
    public TripDTO mapObjectToDto(Trip trip) {
        if (trip == null) return null;

        TripDTO.TripDTOBuilder tripDtoBuilder = TripDTO.builder();
        tripDtoBuilder.id(trip.getId());
        tripDtoBuilder.type(trip.getType());
        tripDtoBuilder.name(trip.getName());
        tripDtoBuilder.addressID(trip.getAddressID());

        return tripDtoBuilder.build();
    }
}