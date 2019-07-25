package com.stackroute;

import com.stackroute.Exceptions.TrackAlreadyExistsExceptions;
import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent>
{
  @Autowired
  TrackService trackservice;

  public SpringContextListener(TrackService trackservice) {
    this.trackservice = trackservice;

  }

  // Invoking the method at the start up of the spring application.

  public void onApplicationEvent(ContextRefreshedEvent event)
  {
    try {
      trackservice.saveTrack(new Track(32,"srija","New Data"));
      trackservice.saveTrack(new Track(45,"sweety","New Data"));
      trackservice.saveTrack(new Track(63,"swathi","New Data"));
    } catch (TrackAlreadyExistsExceptions e) {
      e.printStackTrace();
    }

  }

}
