package com.stackroute.service;

import com.stackroute.Exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.Exceptions.TrackNotFoundExceptions;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    // Providing implementation for all methods of track
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsExceptions {
        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsExceptions("Track Already exist");
        }
        Track savetrack = trackRepository.save(track);

        if (savetrack == null) {
            throw new TrackAlreadyExistsExceptions("Track already present");
        }
        return savetrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundExceptions {
        if (trackRepository.existsById(track.getId())) {
            Track trackobj = trackRepository.findById(track.getId()).get();
            trackobj.setComment(track.getComment());
            trackRepository.save(trackobj);
            return trackobj;
        } else {
            throw new TrackNotFoundExceptions("Track not found");
        }
    }

    @Override
    public void deleteTrack(int id) {
        trackRepository.deleteById(id);
    }

    @Override
    public List<Track> trackByName(String name) {
        return trackRepository.trackByName(name);
    }


}