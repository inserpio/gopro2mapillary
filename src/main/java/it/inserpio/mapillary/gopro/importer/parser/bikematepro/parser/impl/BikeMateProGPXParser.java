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

package it.inserpio.mapillary.gopro.importer.parser.bikematepro.parser.impl;

import it.inserpio.mapillary.gopro.importer.parser.GPXParser;
import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.bean.BikeMateProGPX;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.transformer.BikeMateProGPXTransformer;
import it.inserpio.mapillary.gopro.importer.parser.exception.GPXParsingException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.castor.CastorMarshaller;

/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public class BikeMateProGPXParser implements GPXParser
{
  /* (non-Javadoc)
   * @see it.inserpio.mapillary.gopro.importer.GPXParser#parse(java.io.File)
   */
  @Override
  public List<GPXDateTimePoint> parse(File GPXFile) throws GPXParsingException, XmlMappingException, IOException, ParseException
  {
    CastorMarshaller castorMarshaller = new CastorMarshaller();
    
    Resource mappingLocation = new ClassPathResource("bike-mate-pro-mapping.xml");

    castorMarshaller.setMappingLocation(mappingLocation);
    castorMarshaller.afterPropertiesSet();
    
    Source GPXSource = new StreamSource(new FileInputStream(GPXFile));
  
    BikeMateProGPX bikeMateProGPX = (BikeMateProGPX) castorMarshaller.unmarshal(GPXSource);
    
    return BikeMateProGPXTransformer.translate(bikeMateProGPX);
  }
}
