package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService
{
    // Methods to implement CRUD.
    public void saveTrack(Track track);
    public List<Track> getAllTracks();
    public void deleteTrack(int id);
    public void updateTrack(Track track);
}
