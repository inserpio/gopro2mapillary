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

package it.inserpio.mapillary.gopro.importer.parser.bean;

/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public class GPXDateTimePoint
{
  private double longitude;
  
  private double latitude;
  
  private long timestamp;
  
  /**
   * 
   */
  public GPXDateTimePoint(double longitude, double latitude, long timestamp)
  {
    this.longitude = longitude;
    this.latitude  = latitude;
    this.timestamp = timestamp;
  }

  public double getLongitude()
  {
    return longitude;
  }

  public void setLongitude(double longitude)
  {
    this.longitude = longitude;
  }

  public double getLatitude()
  {
    return latitude;
  }

  public void setLatitude(double latitude)
  {
    this.latitude = latitude;
  }

  public long getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp(long timestamp)
  {
    this.timestamp = timestamp;
  }

  public Coordinates asCoordinates()
  {
    return new Coordinates(this.longitude, this.latitude);
  }
  
  @Override
  public String toString()
  {
    return "GPXDateTimePoint [longitude=" + longitude + ", latitude=" + latitude + ", timestamp=" + timestamp + "]";
  }
}
