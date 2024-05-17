package dom.com.lutencu_octavian_siemens_internship.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommentDTO {
    private Long id;
    @NotNull
    private String comment;
    @NotNull
    private Long userId;
    @NotNull
    private Long hotelId;
}
