package bgd.mapper;

import bgd.domain.Address;
import bgd.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper extends AbstractMapper<Address, AddressDTO>{
    @Override
    public AddressDTO mapObjectToDto(Address address) {
        if (address == null) return null;

        AddressDTO.AddressDTOBuilder addressDtoBuilder = AddressDTO.builder();
        addressDtoBuilder.id(address.getId());
        addressDtoBuilder.country(address.getCountry());
        addressDtoBuilder.region(address.getRegion());
        addressDtoBuilder.settlement(address.getSettlement());
        addressDtoBuilder.street(address.getStreet());
        addressDtoBuilder.house(address.getHouse());

        return addressDtoBuilder.build();
    }
}