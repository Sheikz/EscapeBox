package com.escape.controller;

import com.escape.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Sheikz on 8/26/2016.
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(RoomNotFound.class)
    public ResponseEntity<String> roomNotFound(RoomNotFound e) {
        return new ResponseEntity<String>("Room not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RunNotFound.class)
    public ResponseEntity<String> runNotFound(RunNotFound e) {
        return new ResponseEntity<String>("Run not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ScenarioNotFound.class)
    public ResponseEntity<String> scenarioNotFound(ScenarioNotFound e) {
        return new ResponseEntity<String>("Scenario not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ScenarioNotDefined.class)
    public ResponseEntity<String> scenarioNotDefined(ScenarioNotDefined e){
        return new ResponseEntity<String>("Scenario not defined: "+e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RunForbiddenAction.class)
    public ResponseEntity<String> runForbiddenAction(RunForbiddenAction e){
        return new ResponseEntity<String>("Forbidden action: "+e.getMessage(), HttpStatus.FORBIDDEN);
    }

}
