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

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.springframework.oxm.XmlMappingException;
import org.springframework.util.Assert;

import it.inserpio.mapillary.gopro.importer.exif.EXIFPropertyWriter;
import it.inserpio.mapillary.gopro.importer.matcher.Image2GeoMatcher;
import it.inserpio.mapillary.gopro.importer.matcher.exception.CoordinatesNotFoundException;
import it.inserpio.mapillary.gopro.importer.parser.GPXParser;
import it.inserpio.mapillary.gopro.importer.parser.bean.Coordinates;
import it.inserpio.mapillary.gopro.importer.parser.bean.GPXDateTimePoint;
import it.inserpio.mapillary.gopro.importer.parser.bikematepro.parser.impl.BikeMateProGPXParser;
import it.inserpio.mapillary.gopro.importer.parser.exception.GPXParsingException;
import it.inserpio.mapillary.gopro.importer.upload.UploadToMapillary;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class GoProTimeLapseShotsMapillaryImporter
{
  public static final void main(String[] args)
  {
    try
    {
      Assert.isTrue(args.length == 2, "\n\nYou need to provide 2 arguments:\n\n[1] GPX absolute file name;\n[2] Absolute directory name containing GoPro Time-Lapse Shots.\n\n");
      
      uploadToMapillary(args[0], args[1]);
      
      System.exit(0);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      
      System.exit(-1);
    }
  }

  /**
   * @param bikeMateProGPXFileName
   * @param goProImagesDirectoryName
   * @throws ParseException 
   * @throws IOException 
   * @throws GPXParsingException 
   * @throws XmlMappingException 
   * @throws CoordinatesNotFoundException 
   * @throws ImageReadException 
   * @throws ImageWriteException 
   */
  public static void uploadToMapillary(String bikeMateProGPXFileName, String goProImagesDirectoryName) throws XmlMappingException, GPXParsingException, IOException, ParseException, ImageReadException, CoordinatesNotFoundException, ImageWriteException
  {
    // Get Date-Time Points from GPX file
    // ------------------------------------------------------------------------------------------
    GPXParser gpxParser = new BikeMateProGPXParser();
  
    List<GPXDateTimePoint> gpxDateTimePoints = gpxParser.parse(new File(bikeMateProGPXFileName));
    
    File goProImagesDirectory = new File(goProImagesDirectoryName);
    
    Assert.isTrue(goProImagesDirectory.isDirectory());
    
    File destinationDirectory = new File(goProImagesDirectory.getParent() + File.separator + "uploadable-images");
    
    if (!destinationDirectory.exists())
    {
      destinationDirectory.mkdir();
    }
    
    File[] imageFiles = goProImagesDirectory.listFiles();
    
    // It sets gps coordinates for every GoPro time-lapse shot and upload to Mapillary
    // ------------------------------------------------------------------------------------------
    for (int imageIndex = 0; imageIndex < imageFiles.length; imageIndex++)
    {
      File imageFile = imageFiles[imageIndex];
      
      System.out.println("Managing image " + imageFile);
      
      Coordinates coordinates = Image2GeoMatcher.findCoordinatesByImageOriginalDateTime(imageFile, gpxDateTimePoints, 0);
      
      File modifiedImageFile = new File(destinationDirectory, imageFile.getName());
      
      EXIFPropertyWriter.setExifGPSTag(imageFile, modifiedImageFile, coordinates);
      
      UploadToMapillary.upload(modifiedImageFile, "", "", ""); // TODO upload not yet implemented
    }
  }
}
