package com.hr.api.domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Always use this or a extented version of this 
 * when returning the result of any kind of validation.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResult {
    
    private boolean successful;
    private String error;
}
