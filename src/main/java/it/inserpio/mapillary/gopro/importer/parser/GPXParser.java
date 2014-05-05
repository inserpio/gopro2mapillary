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

package it.inserpio.mapillary.gopro.importer.parser;

import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;
import it.inserpio.mapillary.gopro.importer.parser.exception.GPXParsingException;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.oxm.XmlMappingException;

/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public interface GPXParser
{
  List<GPXDateTimePoint> parse(File GPXFile) throws GPXParsingException, XmlMappingException, IOException, ParseException;
  
}
