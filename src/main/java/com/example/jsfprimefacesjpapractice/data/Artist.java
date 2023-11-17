package com.example.jsfprimefacesjpapractice.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"Artist\"")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll", query = "select a from Artist a")
})
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"ArtistId\"", nullable = false)
    private Integer id;

    @Size(max = 120)
    @Column(name = "\"Name\"", length = 120)
    private String name;

}