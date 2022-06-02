package com.example.calometer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private int calories;
    private String name;
    private String richIn;
    private String date;

    //@ManyToMany(mappedBy = "items")

    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="user_item",
            joinColumns = @JoinColumn(
                    name="item_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="user_id",referencedColumnName = "id"))
    private Collection<User> users;

    public String getDateFromLocalDate() {
        return java.time.LocalDate.now().toString();
    }
}
