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

package it.inserpio.mapillary.gopro.importer.exif;

import it.inserpio.mapillary.gopro.importer.parser.bean.Coordinates;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.common.RationalNumber;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.exif.ExifRewriter;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.GpsTagConstants;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;
import org.apache.commons.imaging.util.IoUtils;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class EXIFPropertyWriter
{
  public static void setExifGPSTag(File jpegImageFile, File jpegImageOutputFile, Coordinates coordinates) throws IOException, ImageReadException, ImageWriteException
  {
    OutputStream os = null;
    
    boolean canThrow = false;
    
    try
    {
      TiffOutputSet outputSet = null;

      final IImageMetadata metadata = Imaging.getMetadata(jpegImageFile);
      final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
      
      if (jpegMetadata != null)
      {
        final TiffImageMetadata exif = jpegMetadata.getExif();

        if (exif != null)
        {
          outputSet = exif.getOutputSet();
        }
      }

      if (outputSet == null)
      {
        outputSet = new TiffOutputSet();
      }

      outputSet.setGPSInDegrees(coordinates.getLongitude(), coordinates.getLatitude());

      outputSet.getGPSDirectory().removeField(GpsTagConstants.GPS_TAG_GPS_IMG_DIRECTION_REF);
      outputSet.getGPSDirectory().add(GpsTagConstants.GPS_TAG_GPS_IMG_DIRECTION_REF, GpsTagConstants.GPS_TAG_GPS_DEST_BEARING_REF_VALUE_TRUE_NORTH);
      
      outputSet.getGPSDirectory().removeField(GpsTagConstants.GPS_TAG_GPS_IMG_DIRECTION);
      outputSet.getGPSDirectory().add(GpsTagConstants.GPS_TAG_GPS_IMG_DIRECTION, new RationalNumber[] { RationalNumber.valueOf(coordinates.getDirection()) });

      //outputSet.getRootDirectory().removeField(305);

      os = new FileOutputStream(jpegImageOutputFile);
      os = new BufferedOutputStream(os);

      new ExifRewriter().updateExifMetadataLossless(jpegImageFile, os, outputSet);
      
      canThrow = true;
    }
    finally
    {
      IoUtils.closeQuietly(canThrow, os);
    }
  }
}
