import lombok.*;
import java.util.List;
@Data
public class StudentRequest {
    private String studentId;
    private String name;
    private String email;
    private String program;
    private Integer yearLevel;
    private Boolean repeatOffender;
    private List integrityCases;
}
