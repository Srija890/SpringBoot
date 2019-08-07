package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

//Test cases for TrackService methods
@RunWith(SpringRunner.class)
public class TrackServiceTest {
	
	//Create a mock for UserRepository
	@Mock
	TrackRepository trackRepository;
	
	//Inject the mocks as dependencies into UserServiceImpl
	@InjectMocks
	TrackServiceImpl trackService;
	
	Track track;
	List<Track> list= null;
	
	@Before
	public void setUp(){
		//Initialising the mock object
		MockitoAnnotations.initMocks(this);
		track = new Track(101,"Revanth","good");
		list = new ArrayList<>();
		list.add(track);
	}
	
	@After
	public void tearDown() {
		track = null;
		list = null;
	}
	
//	Test for getAllTracks service method
	@Test
	public void getAllTracks() {
		
		trackRepository.save(track);
		//stubbing the mock to return specific data
		when(trackRepository.findAll()).thenReturn(list);
		List<Track> userlist = trackService.getAllTracks();
		Assert.assertEquals(list,userlist);
	}
	
//	Test for saveTrack service method
	@Test
	public void saveTrack() {
		when(trackRepository.save(track)).thenReturn(track);
		Assert.assertEquals(true,trackService.saveTrack(track));
		
		//verify here verifies that trackRepository save method is only called once
		verify(trackRepository,times(1)).save(track);
		
	}
	
	
//	Test for deleteTrack service method
	@Test
	public void deleteTrack()  {
		Track track1 = new Track(102,"Dhanunjay","Excellent");
		trackService.saveTrack(track);
		trackService.saveTrack(track1);
		Assert.assertTrue(trackService.deleteTrack(102));
		
		//verify here verifies that trackRepository deleteById method is only called once
		verify(trackRepository,times(1)).deleteById(track1.getId());
	}
	
//	Test for updateTrack service method
	@Test
	public void updateTrack() {
		when(trackRepository.save(track)).thenReturn(track);
		when(trackRepository.existsById(track.getId())).thenReturn(true);
		track.setComment("worst");
		Assert.assertTrue(trackService.updateTrack(101,track));
		//verify here verifies that trackRepository save method is only called once
		verify(trackRepository,times(1)).save(track);
	}
}


