package com.octo.au.exception;

/**
 * @author Amol Kshirsagar
 *
 */
public class CustomException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public CustomException(String message) {
    super(message);
  }
  
  public CustomException(String message,Throwable e) {
	    super(message);
	  }
}