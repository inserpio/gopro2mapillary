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

import java.util.List;

/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public class BikeMateProTRK
{
  private String name;
  private List<BikeMateProTRKSEG> trksegs;
  
  public BikeMateProTRK()
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

  public List<BikeMateProTRKSEG> getTrksegs()
  {
    return trksegs;
  }

  public void setTrksegs(List<BikeMateProTRKSEG> trksegs)
  {
    this.trksegs = trksegs;
  }

  @Override
  public String toString()
  {
    return "BikeMateProTRK [name=" + name + ", trksegs=" + trksegs + "]";
  }
}