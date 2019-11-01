package co.pragra.banking.rest.simplebankapi.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private int code;
    private String description;
}
