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

package it.inserpio.mapillary.gopro.importer.matcher.exception;

/**
 * @author Lorenzo Speranzoni
 * @since May 4, 2014
 */
public class CoordinatesNotFoundException extends Exception
{
  private static final long serialVersionUID = 1L;

  public CoordinatesNotFoundException()
  {
    super();
  }
  
  public CoordinatesNotFoundException(String message)
  {
    super(message);
  }
  
  public CoordinatesNotFoundException(Throwable throwable)
  {
    super(throwable);
  }
  
  public CoordinatesNotFoundException(String message, Throwable throwable)
  {
    super(message, throwable);
  }
}
