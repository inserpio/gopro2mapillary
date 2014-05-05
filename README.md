GoPro2Mapillary
===============

This app adds geo-spatial coordinates to GoPro Time-Lapse shots. Coordinates are taken from the corresponding GPX file.

Test
----

GoProTimeLapseShotsMapillaryImporterTest.shouldAddGpsCoordinatesTestDir gets GPX file contained into the directory src/test/resources/full/gpx
and adds GPS coordinates to all the images contained into the directory src/test/resources/full/images: modified images, uploadable to Mapillary, are
created into the directory src/test/resources/full/uploadable-images


Mapillary update process currently ends with this error: ERROR: Could not find valid EXIF Data.
Javascript console error message: Not valid TIFF data! (First offset not 8) 0 

Packaging
---------

maven clean package
