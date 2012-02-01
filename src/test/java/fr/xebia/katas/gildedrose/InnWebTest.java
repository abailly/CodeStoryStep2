/*
 * Copyright 2012 PolySpot, S.A.S. All Rights Reserved.
 * This software is the proprietary information of PolySpot, S.A.S. Use is subject to license terms.
 */
package fr.xebia.katas.gildedrose;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 */
public class InnWebTest {

  @Test
  public void server_can_update_an_inn() throws Exception {
    InnWeb.makeServer();

    WebResource resource = Client.create().resource("http://localhost:8080/update");
    String response = resource.get(String.class);
    System.err.println(response);
    response = resource.get(String.class);
    System.err.println(response);
    response = resource.get(String.class);
    System.err.println(response);
  }

}
