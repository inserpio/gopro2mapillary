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

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class EXIFPropertyReaderTest
{
  @Test
  public void shouldGetCameraDate()
  {
    try
    {
      File jpegImageFile = new File("src/test/resources", "IMG_2096.JPG");

      long dateTimeOriginal = EXIFPropertyReader.getDateTimeOriginal(jpegImageFile);
      
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
      
      Assert.assertEquals(dateFormat.parse("2012:12:01 19:02:07").getTime(), dateTimeOriginal);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
  
  @Test
  public void shouldPrintImageMetadata()
  {
    try
    {
      File jpegImageFile = new File("src/test/resources", "IMG_2096.JPG");
      
      final IImageMetadata metadata = Imaging.getMetadata(jpegImageFile);
      final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;

      System.out.println(jpegMetadata);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
  
  @Test
  public void shouldPrintImageMetadata2()
  {
    try
    {
      File jpegImageFile = new File("src/test/resources", "IMG_4303.JPG");
      
      final IImageMetadata metadata = Imaging.getMetadata(jpegImageFile);
      final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
      
      System.out.println(jpegMetadata);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
  
  @Test
  public void shouldPrintImageMetadata3()
  {
    try
    {
      File jpegImageFile = new File("src/test/resources", "CIMG6404.JPG");
      
      final IImageMetadata metadata = Imaging.getMetadata(jpegImageFile);
      final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
      
      System.out.println(jpegMetadata);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
  
  @Test
  @Ignore
  public void shouldPrintImageMetadata4()
  {
    try
    {
      File jpegImageFile = new File("src/test/resources/full/uploadable-images", "G0010043.JPG");
      
      final IImageMetadata metadata = Imaging.getMetadata(jpegImageFile);
      final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
      
      System.out.println(jpegMetadata);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      Assert.fail();
    }
  }
}
