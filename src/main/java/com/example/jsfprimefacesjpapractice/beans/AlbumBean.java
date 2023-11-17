package com.example.jsfprimefacesjpapractice.beans;

import com.example.jsfprimefacesjpapractice.dao.AlbumDao;
import com.example.jsfprimefacesjpapractice.data.Album;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AlbumBean implements Serializable {

    @EJB
    private AlbumDao albumDao = new AlbumDao();

    public List<Album> getAlbumList() {
        return albumDao.findAll();
    }
}
