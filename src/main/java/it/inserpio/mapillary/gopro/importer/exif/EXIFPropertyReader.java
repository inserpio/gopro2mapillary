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

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class EXIFPropertyReader
{
  public static long getDateTimeOriginal(File imageFile) throws ImageReadException, IOException, ParseException
  {
    final IImageMetadata metadata = Imaging.getMetadata(imageFile);
    final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
    
    String dateTimeOriginal = jpegMetadata.getExif().getFieldValue(ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL)[0];
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    
    return dateFormat.parse(dateTimeOriginal).getTime();
  }
}
