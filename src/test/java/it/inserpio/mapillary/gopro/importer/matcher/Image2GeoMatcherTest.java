/*
 * Copyright 2014 the original author or authors.
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

package it.inserpio.mapillary.gopro.importer.matcher;

import it.inserpio.mapillary.gopro.importer.parser.bean.Coordinates;
import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.parser.impl.BikeMateProGPXParser;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class Image2GeoMatcherTest
{
  @Test
  public void shouldFindCoordinates()
  {
    try
    {
      File GPXFile = new File("data/gpx", "2014-05-04-Venice.gpx");
      File imageFile = new File("data/images", "G0010043.JPG");
    
      List<GPXDateTimePoint> gpxDateTimePoints = new BikeMateProGPXParser().parse(GPXFile);
    
      Coordinates coordinates = Image2GeoMatcher.findCoordinatesByImageOriginalDateTime(imageFile, gpxDateTimePoints, 0);
    
      //Longitude: 12.275616
      //Latitude: 45.465577
      //Time: 2014-05-04T17:01:17Z
  
      //Longitude: 12.275761
      //Latitude: 45.465568
      //Time: 2014-05-04T17:02:06Z
      
      System.out.println(coordinates);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
}
