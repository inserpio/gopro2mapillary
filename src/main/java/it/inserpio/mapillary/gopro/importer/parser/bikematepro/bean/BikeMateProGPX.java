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
public class BikeMateProGPX
{
  private String name;
  private String desc;
  private String author;
  private String time;
  private String bounds;
  private BikeMateProTRK trk;
  
  public BikeMateProGPX()
  {
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDesc()
  {
    return desc;
  }

  public void setDesc(String desc)
  {
    this.desc = desc;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getTime()
  {
    return time;
  }

  public void setTime(String time)
  {
    this.time = time;
  }

  public String getBounds()
  {
    return bounds;
  }

  public void setBounds(String bounds)
  {
    this.bounds = bounds;
  }

  public BikeMateProTRK getTrk()
  {
    return trk;
  }

  public void setTrk(BikeMateProTRK trk)
  {
    this.trk = trk;
  }

  @Override
  public String toString()
  {
    return "BikeMateProGPX [name=" + name + ", desc=" + desc + ", author=" + author + ", time=" + time + ", bounds=" + bounds + ", trk=" + trk + "]";
  }
}