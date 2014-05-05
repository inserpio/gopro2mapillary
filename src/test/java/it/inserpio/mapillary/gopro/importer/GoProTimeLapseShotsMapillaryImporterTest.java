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

package it.inserpio.mapillary.gopro.importer;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class GoProTimeLapseShotsMapillaryImporterTest
{
  @Test
  public void shouldAddGpsCoordinatesTestDir()
  {
    try
    {
      String bikeMateProGPXFileName  = "/Users/lorenzo/Progetti/Larus/red/mapillary/gopro2mapillary/software/gopro-importer/src/test/resources/full/gpx/2014-05-04-Venice.gpx";
      String goProImagesDirectoryName = "/Users/lorenzo/Progetti/Larus/red/mapillary/gopro2mapillary/software/gopro-importer/src/test/resources/full/images";
      
      GoProTimeLapseShotsMapillaryImporter.uploadToMapillary(bikeMateProGPXFileName, goProImagesDirectoryName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
  
  @Test
  @Ignore
  public void shouldAddGpsCoordinatesDataDir()
  {
    try
    {
      String bikeMateProGPXFileName  = "/Users/lorenzo/Progetti/Larus/red/mapillary/gopro2mapillary/software/gopro-importer/data/gpx/2014-05-04-Venice.gpx";
      String goProImagesDirectoryName = "/Users/lorenzo/Progetti/Larus/red/mapillary/gopro2mapillary/software/gopro-importer/data/images";
      
      GoProTimeLapseShotsMapillaryImporter.uploadToMapillary(bikeMateProGPXFileName, goProImagesDirectoryName);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
}
