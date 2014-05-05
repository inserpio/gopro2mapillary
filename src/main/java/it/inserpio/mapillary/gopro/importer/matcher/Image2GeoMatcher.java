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

import it.inserpio.mapillary.gopro.importer.exif.EXIFPropertyReader;
import it.inserpio.mapillary.gopro.importer.matcher.exception.CoordinatesNotFoundException;
import it.inserpio.mapillary.gopro.importer.parser.bean.Coordinates;
import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.imaging.ImageReadException;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class Image2GeoMatcher
{
  /**
   * TODO deltaInMillis still unused: to sync gopro - phone time
   * 
   * @param imageFile
   * @param gpxDateTimePoints
   * @param deltaInMillis
   * @return
   * @throws ImageReadException
   * @throws IOException
   * @throws ParseException
   * @throws CoordinatesNotFoundException 
   */
  public static Coordinates findCoordinatesByImageOriginalDateTime(File imageFile, List<GPXDateTimePoint> gpxDateTimePoints, long deltaInMillis) throws ImageReadException, IOException, ParseException, CoordinatesNotFoundException
  {
    long imageDateTimeOriginal = EXIFPropertyReader.getDateTimeOriginal(imageFile);
    
    int points = gpxDateTimePoints.size();
    
    for (int point = 0; point < points; point++)
    {
      GPXDateTimePoint gpxDateTimePoint  = gpxDateTimePoints.get(point);
      
      GPXDateTimePoint gpxDateTimePoint1 = null;
      GPXDateTimePoint gpxDateTimePoint2 = null;
      
      if (point == points - 1)
      {
        gpxDateTimePoint1 = gpxDateTimePoints.get(point - 1);
        gpxDateTimePoint2 = gpxDateTimePoint;
      }
      else
      {
        gpxDateTimePoint1 = gpxDateTimePoint;
        gpxDateTimePoint2 = gpxDateTimePoints.get(point + 1);
      }
      
      if (imageDateTimeOriginal >= gpxDateTimePoint.getTimestamp())
      {
        return gpxDateTimePoint.asCoordinates().setDirection(computeGPSImgDirection(gpxDateTimePoint1, gpxDateTimePoint2));
      }
    }
    
    throw new CoordinatesNotFoundException("Coordinates not found for date-time point " + imageDateTimeOriginal);
  }
  
  /**
   * Determine GPSImgDirection
   * 
   * @param dateTimePoint1
   * @param dateTimePoint2
   * @return
   */
  public static double computeGPSImgDirection(GPXDateTimePoint dateTimePoint1, GPXDateTimePoint dateTimePoint2)
  {
    double deltaY = dateTimePoint1.getLatitude () - dateTimePoint2.getLatitude ();
    double deltaX = dateTimePoint1.getLongitude() - dateTimePoint2.getLongitude();
    
    double degrees = Math.toDegrees(Math.atan2(deltaY, deltaX));

    if (degrees < 0)
    {
      degrees = 360 + degrees;
    }
    
    return degrees;
  }
}
