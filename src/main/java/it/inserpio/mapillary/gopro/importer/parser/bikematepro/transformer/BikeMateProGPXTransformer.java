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

package it.inserpio.mapillary.gopro.importer.parser.bikematepro.transformer;

import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.bean.BikeMateProGPX;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.bean.BikeMateProTRKPT;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.bean.BikeMateProTRKSEG;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.Assert;

/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public class BikeMateProGPXTransformer
{
  public static List<GPXDateTimePoint> translate(BikeMateProGPX bikeMateProGPX) throws ParseException
  {
    List<GPXDateTimePoint> result = null;
    
    Assert.notNull(bikeMateProGPX);
    Assert.notNull(bikeMateProGPX.getTrk());
    
    if (CollectionUtils.isNotEmpty(bikeMateProGPX.getTrk().getTrksegs()))
    {
      for (BikeMateProTRKSEG bikeMateProTRKSEG : bikeMateProGPX.getTrk().getTrksegs())
      {
        result = new ArrayList<GPXDateTimePoint>();
        
        for (BikeMateProTRKPT bikeMateProTRKPT : bikeMateProTRKSEG.getTrkpts())
        {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
          
          Date date = dateFormat.parse(bikeMateProTRKPT.getTime());
          
          result.add(new GPXDateTimePoint(bikeMateProTRKPT.getLon(), bikeMateProTRKPT.getLat(), date.getTime()));
        }      
      }
    }
    
    return result;
  }
}
