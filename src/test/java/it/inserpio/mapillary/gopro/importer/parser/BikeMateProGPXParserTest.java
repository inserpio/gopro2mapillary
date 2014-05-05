/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.inserpio.mapillary.gopro.importer.parser;

import it.inserpio.mapillary.gopro.importer.matcher.Image2GeoMatcher;
import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.parser.impl.BikeMateProGPXParser;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BikeMateProGPXParserTest
{
  @Test
  public void shouldParseBikeMateProGPXFile()
  {
    try
    {
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
      
      File GPXFile = new File("src/test/resources/2013-09-19 Asolo Off-Road.gpx");
      
      Assert.assertTrue(GPXFile.isFile());
      
      GPXParser gpxParser = new BikeMateProGPXParser();
      
      List<GPXDateTimePoint> gpxDateTimePoints = gpxParser.parse(GPXFile);
      
      
      double p1_lat = 45.789384;
      double p1_lon = 12.051548;
      
      Assert.assertEquals(p1_lat, gpxDateTimePoints.get(0).getLatitude (), 0);
      Assert.assertEquals(p1_lon, gpxDateTimePoints.get(0).getLongitude(), 0);
      Date date = dateFormat.parse("2013-09-18T09:10:20Z");
      Assert.assertEquals(date.getTime(), gpxDateTimePoints.get(0).getTimestamp());
      
      double p2_lat = 45.789388;
      double p2_lon = 12.051548;

      Assert.assertEquals(p2_lat, gpxDateTimePoints.get(1).getLatitude (), 0);
      Assert.assertEquals(p2_lon, gpxDateTimePoints.get(1).getLongitude(), 0);
      date = dateFormat.parse("2013-09-18T09:10:21Z");
      Assert.assertEquals(date.getTime(), gpxDateTimePoints.get(1).getTimestamp());
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }

  @Test
  public void shouldDetermineGPSImgDirection()
  {
    double p1_lat = 45.515705;
    double p1_lon = 12.212845;
    
    double p2_lat = 45.515681;
    double p2_lon = 12.212802;

    double degrees = Image2GeoMatcher.computeGPSImgDirection(new GPXDateTimePoint(p1_lon, p1_lat, 0), new GPXDateTimePoint(p2_lon, p2_lat, 0));
    
    Assert.assertEquals(29.167613375884418, degrees, 0);
  }
  
  @Test
  public void shouldParseVeniceTraining()
  {
    try
    {
      File GPXFile = new File("data/gpx", "2014-05-04-Venice.gpx");
      
      Assert.assertTrue(GPXFile.isFile());
      
      GPXParser gpxParser = new BikeMateProGPXParser();
      
      List<GPXDateTimePoint> gpxDateTimePoints = gpxParser.parse(GPXFile);
      
      System.out.println(gpxDateTimePoints.size());
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
}
