package africa.semicolon.studentmanagementsys.controllers.requestsAndResponse;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {
    private String message;
    private String status;
    private Object data;
    private int result;
    private int statusCode;
}
