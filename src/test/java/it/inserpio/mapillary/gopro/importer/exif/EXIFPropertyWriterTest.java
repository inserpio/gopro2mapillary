/*
 * Copyright 2012 the original author or authors.
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
package it.inserpio.mapillary.gopro.importer.exif;

import it.inserpio.mapillary.gopro.importer.parser.bean.Coordinates;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class EXIFPropertyWriterTest
{
  @Test
  public void shouldWriteEXIFProperties()
  {
    try
    {
      File source      = new File("src/test/resources", "IMG_2096.JPG");
      File destination = new File("target", "IMG_2096_MOD.JPG");
      
      EXIFPropertyWriter.setExifGPSTag(source, destination, new Coordinates(12.24, 45.66, 135));
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
}
