package com.stackroute.controller;

import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="api/v1")
public class TrackController
{
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    private TrackRepository trackRepository;
    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService)
    {
        this.trackService = trackService;
    }


    // Implementing POST method
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistException
    {
        ResponseEntity responseEntity;
        try{
            Track save=trackService.saveTrack(track);
            responseEntity=new ResponseEntity(save, HttpStatus.CREATED);
        }
        catch (TrackAlreadyExistException e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

    // Implementing GET method
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks()
    {
        System.out.println("inside");
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    // Implementing PUT method
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException
    {
        ResponseEntity responseEntity;
        try{
           Track update= trackService.updateTrack(track);
            responseEntity=new ResponseEntity(update, HttpStatus.CREATED);
        }
        catch (TrackNotFoundException e)
        {
            responseEntity=new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    // Implementing DELETE method
    @DeleteMapping(value="/track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try {
          Track delete=  trackService.deleteTrack(id);
            responseEntity = new ResponseEntity(delete, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
