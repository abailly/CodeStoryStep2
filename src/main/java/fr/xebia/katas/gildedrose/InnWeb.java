/*
 * Copyright 2012 PolySpot, S.A.S. All Rights Reserved.
 * This software is the proprietary information of PolySpot, S.A.S. Use is subject to license terms.
 */
package fr.xebia.katas.gildedrose;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import org.apache.commons.io.IOUtils;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * 
 */
public class InnWeb {

  public static void main(String[] args) {
    try {
      HttpServer server = makeServer();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  static HttpServer makeServer() throws IOException {
    InetSocketAddress address = new InetSocketAddress(8080);
    HttpServer httpServer = HttpServer.create(address, 1);
    httpServer.setExecutor(null);
    HttpContext httpContext = httpServer.createContext("/update");
    httpContext.setHandler(innHandler());
    httpContext = httpServer.createContext("/page");
    httpContext.setHandler(pageHandler());
    httpServer.start();
    return httpServer;
  }

  /**
   * @return
   */
  private static HttpHandler pageHandler() {
    return new HttpHandler() {

      @Override
      public void handle(HttpExchange http) throws IOException {
        String string = IOUtils.toString(getClass().getResourceAsStream("/inn.html"));
        http.sendResponseHeaders(200, string.length());
        OutputStream os = http.getResponseBody();
        os.write(string.getBytes());
        os.flush();
      }

    };
  }

  /**
   * @return
   */
  private static HttpHandler innHandler() {
    return new HttpHandler() {

      Inn inn = new Inn();

      @Override
      public void handle(HttpExchange http) throws IOException {
        inn.updateQuality();
        StringBuilder sb = new StringBuilder("");

        for (Item item : inn.items) {
          sb.append(item.getName()).append(",").append(item.getQuality()).append(",").append(item.getSellIn());
          sb.append("\n");
        }
        http.sendResponseHeaders(200, sb.length());
        OutputStream os = http.getResponseBody();
        os.write(sb.toString().getBytes());
        os.flush();
      }
    };
  }
}
