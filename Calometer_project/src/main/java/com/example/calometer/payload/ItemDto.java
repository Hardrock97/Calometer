package com.example.calometer.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class ItemDto {

    private int id;
    private int calories;
    private String name;
    private String richIn;
    private String date;

    public String getDateFromLocalDate() {
        return java.time.LocalDate.now().toString();
    }
}
