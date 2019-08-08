package com.stackroute.service;
import com.stackroute.domain.Track;

import java.io.IOException;
import java.util.List;

public interface TrackService
{
    // Methods to implement CRUD.
    public Track saveTrack(Track track) throws Exception;
    public List<Track> getAllTracks();
    public Track deleteTrack(int id);
    public Track updateTrack(Track track) throws Exception;
    public List<Track> trackByName(String name);
    public void getUrlData() throws Exception;

}

