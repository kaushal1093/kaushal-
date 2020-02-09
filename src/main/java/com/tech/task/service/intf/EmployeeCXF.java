
  package com.tech.task.service.intf;
  
  import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

  /**
   * 
   * @author C5107956
   *
   */
  @Path(value = "/techServices")
  public interface EmployeeCXF {
  
  @POST
  @Path(value ="/create")
  @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
  @Produces( MediaType.APPLICATION_JSON )
  public String createEmployees(String employee);
  
  @GET
  @Path(value ="/getAll")
  @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
  @Produces( MediaType.APPLICATION_JSON )
  public String getEmployees();
  
  
  }
 