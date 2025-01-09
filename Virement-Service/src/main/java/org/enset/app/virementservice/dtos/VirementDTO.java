package org.enset.app.virementservice.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.enset.app.virementservice.enums.VirementType;

import java.util.Date;

@Data
public class VirementDTO {
    private Long Id;
    private Long beneficiaireId;
    private String sourceRIB;
    private Double amount;
    private String description;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date virementDate;
    private VirementType type;
}
