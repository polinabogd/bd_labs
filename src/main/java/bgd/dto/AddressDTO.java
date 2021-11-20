package bgd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private Integer id;
    private String country;
    private String region;
    private String settlement;
    private String street;
    private Integer house;
}
