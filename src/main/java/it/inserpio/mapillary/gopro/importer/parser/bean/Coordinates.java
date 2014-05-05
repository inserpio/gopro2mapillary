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
 * @since May 4, 2014
 */
public class Coordinates
{
  private double longitude;
  private double latitude;
  private double direction;
  
  public Coordinates(double longitude, double latitude)
  {
    this.longitude = longitude;
    this.latitude  = latitude;
    this.direction = 0;
  }

  public Coordinates(double longitude, double latitude, double direction)
  {
    this.longitude = longitude;
    this.latitude  = latitude;
    this.direction = direction;
  }
  
  public double getLongitude()
  {
    return longitude;
  }

  public Coordinates setLongitude(double longitude)
  {
    this.longitude = longitude;
    
    return this;
  }

  public double getLatitude()
  {
    return latitude;
  }

  public Coordinates setLatitude(double latitude)
  {
    this.latitude = latitude;
    
    return this;
  }

  public double getDirection()
  {
    return this.direction;
  }
  
  public Coordinates setDirection(double direction)
  {
    this.direction = direction;
    
    return this;
  }

  @Override
  public String toString()
  {
    return "Coordinates [longitude=" + longitude + ", latitude=" + latitude + ", direction=" + direction + "]";
  }
}
