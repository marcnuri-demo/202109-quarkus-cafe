package com.marcnuri.demo.quarkuscafe;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/resource")
public class Resource {

  @ConfigProperty(name = "environment", defaultValue = "unset")
  String environment;

  @ConfigProperty(name = "caffe", defaultValue = "n/a")
  String caffe;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Map<String, String> hello() {
    return Map.of("environment", environment, "caffe", caffe);
  }
}
