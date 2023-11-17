package com.example.jsfprimefacesjpapractice.dao;

import com.example.jsfprimefacesjpapractice.data.Artist;
import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ArtistDao {

    @Resource(name = "jdbc/chinook")
    private DataSource ds;

    public List<Artist> findAll() {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from \"Artist\"");
             ResultSet rs = ps.executeQuery()
        ) {
            List<Artist> result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                result.add(new Artist(id, name));
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Artist artist) {
        try (Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into \"Artist\" (\"Name\") values (?)")
        ){
            ps.setString(1, artist.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from \"Artist\" where \"ArtistId\" = ?")
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

