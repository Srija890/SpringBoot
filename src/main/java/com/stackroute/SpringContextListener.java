package com.stackroute;

import com.stackroute.Exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringContextListener extends ApplicationStartRunner{

  @Value("${track1.id}")
  private String id;
  @Value("${track1.name}")
  private String tname;
  @Value("${track1.comment}")
  private String tcmnt;

  Track track=new Track();
  @Autowired
  TrackService trackservice;

  @Override
  public void run(String... args) throws Exception
  {

  // Invoking the method at the start up of the spring application.


   /* try {
      trackservice.saveTrack(new Track(32,"srija","New Data"));
      trackservice.saveTrack(new Track(45,"sweety","New Data"));
      trackservice.saveTrack(new Track(63,"swathi","New Data"));
    } catch (TrackAlreadyExistsExceptions e) {
      e.printStackTrace();
    }*/

  }

}
