package com.niit.project.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT,reason = "Empty Vessel")
public class EmptyProjectException extends Exception{
}
