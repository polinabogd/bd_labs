package bgd.controller;

import bgd.domain.Address;
import bgd.dto.AddressDTO;
import bgd.mapper.AbstractMapper;
import bgd.mapper.AddressMapper;
import bgd.service.AbstractService;
import bgd.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/addresses")
@RestController
@AllArgsConstructor
public class AddressController extends AbstractController<Address, AddressDTO, Integer> {
    private final AddressService addressService;
    private final AddressMapper addressMapper;


    @Override
    protected AbstractService<Address, Integer> getService() {
        return addressService;
    }

    @Override
    protected AbstractMapper<Address, AddressDTO> getMapper() {
        return addressMapper;
    }
}
