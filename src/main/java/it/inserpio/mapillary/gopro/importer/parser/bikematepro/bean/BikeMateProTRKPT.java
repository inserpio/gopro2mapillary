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

package it.inserpio.mapillary.gopro.importer.parser.bikematepro.bean;

/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public class BikeMateProTRKPT
{
  private double lat;
  private double lon;
  private String ele;
  private String magvar;
  private String hdop;
  private String vdop;
  private String time;
  
  public BikeMateProTRKPT()
  {
  }

  public double getLat()
  {
    return lat;
  }

  public void setLat(double lat)
  {
    this.lat = lat;
  }

  public double getLon()
  {
    return lon;
  }

  public void setLon(double lon)
  {
    this.lon = lon;
  }

  public String getEle()
  {
    return ele;
  }

  public void setEle(String ele)
  {
    this.ele = ele;
  }

  public String getMagvar()
  {
    return magvar;
  }

  public void setMagvar(String magvar)
  {
    this.magvar = magvar;
  }

  public String getHdop()
  {
    return hdop;
  }

  public void setHdop(String hdop)
  {
    this.hdop = hdop;
  }

  public String getVdop()
  {
    return vdop;
  }

  public void setVdop(String vdop)
  {
    this.vdop = vdop;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  @Override
  public String toString()
  {
    return "BikeMateProTRKPT [ele=" + ele + ", magvar=" + magvar + ", hdop=" + hdop + ", vdop=" + vdop + ", time=" + time + "]";
  }
}