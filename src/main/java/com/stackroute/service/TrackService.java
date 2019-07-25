package com.stackroute.service;

import com.stackroute.Exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.Exceptions.TrackNotFoundExceptions;
import com.stackroute.domain.Track;

import java.util.List;

//import java.util.List;

public interface TrackService
{
    // Methods to implement CRUD.
    public Track saveTrack(Track track) throws TrackAlreadyExistsExceptions;
    public List<Track> getAllTracks();
    public void deleteTrack(int id);
    public Track updateTrack(Track track)throws TrackNotFoundExceptions;
    public List<Track> trackByName(String name);
}