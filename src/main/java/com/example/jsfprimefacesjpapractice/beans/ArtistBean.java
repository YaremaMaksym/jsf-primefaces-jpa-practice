package com.example.jsfprimefacesjpapractice.beans;

import com.example.jsfprimefacesjpapractice.dao.ArtistDao;
import com.example.jsfprimefacesjpapractice.data.Artist;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ArtistBean implements Serializable {

    @EJB
    private ArtistDao artistDao;

    @Getter @Setter
    private Artist artist = new Artist();

    public List<Artist> getArtistList() {
        return artistDao.findAll();
    }

    public void add() {
        artistDao.add(artist);
        artist = new Artist();
    }

    public void delete(int id) {
        artistDao.delete(id);
    }

    public String showAlbums(int artistId) {
        artist = artistDao.find(artistId);
        return "albums_by_artist";
    }
}
