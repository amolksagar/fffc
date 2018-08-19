package com.octo.au.domain.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.octo.au.constants.Constants;

public class ValidatorUtil {
    public static final Validation <String> notNullString = GenericValidation.from(s -> s != null);
    public static final Validation <String> notEmptyString = GenericValidation.from(s -> !s.isEmpty());
    /*public static final Validation <String> noContainsCarraige = GenericValidation.from(s -> !s.toString().contains("\\r"));
    public static final Validation <String> noLineFeed = GenericValidation.from(s -> !s.toString().contains("\\n"));*/
    
    public static final Validation <Integer> notNullInteger = GenericValidation.from(s -> s != null);
    public static final Validation <Integer> greaterThanZero = GenericValidation.from(s -> s > 0);
    
    public static final Validation <String> stringMoreThan(int size) {
        return GenericValidation.from(s -> ((String) s).length() > size);
    };
    public static final Validation <String> stringLessThanEqualTo(int size) {
        return GenericValidation.from(s -> (((String) s).length() < size) || (((String) s).length() == size));
    };
    public static final Validation <String> stringBetween(int morethan, int lessThan) {
        return stringMoreThan(morethan).and(stringLessThanEqualTo(lessThan));
    };
    
    public static final Validation <Integer> integerMoreThan(int limit) {
        return GenericValidation.from(s -> s > limit);
    };
    public static final Validation <Integer> integerLessThan(int size) {
        return GenericValidation.from(s -> s < size);
    };
    public static final Validation <Integer> integerBetween(int morethan, int lessThan) {
        return integerMoreThan(morethan).and(integerLessThan(lessThan));
    };
    public static final Validation <String> isValidInteger() {
    	return GenericValidation.from(s -> s.matches("^-?[0-9]\\d*(\\.\\d+)?$"));
    };
    public static final Validation <String> noThousandsSeperator() {
    	return GenericValidation.from(s -> !(s.toString().contains(",")));
    };
    
    public static final Validation <String> isValidDate() {
    	return GenericValidation.from(s -> {
			try {
				LocalDate date = LocalDate.parse(s);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.STR_DEFAULT_SOURCE_DATEFORMAT);
				formatter.format(date).toString();
			} catch (Exception e) {
				return false;
			}
    		return true;
    	});
    };
}
