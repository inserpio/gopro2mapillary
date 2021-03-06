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

package it.inserpio.mapillary.gopro.importer.parser.exception;


/**
 * @author Lorenzo Speranzoni
 * @since May 3, 2014
 */
public class GPXParsingException extends Exception
{
  private static final long serialVersionUID = 1L;
  
  public GPXParsingException()
  {
    super();
  }
  
  public GPXParsingException(String message)
  {
    super(message);
  }
  
  public GPXParsingException(Throwable throwable)
  {
    super(throwable);
  }
  
  public GPXParsingException(String message, Throwable throwable)
  {
    super(message, throwable);
  }
}
