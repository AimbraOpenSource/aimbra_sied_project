package com.aimbra.sied.business.sied.apis;

import org.springframework.stereotype.Service;

@Service
public interface TextValidator {
    Boolean isValid();
    TextValidator whereValueIs(String value);
    TextValidator whereMessageErrorIs(String messageError);
    TextValidator whereRangeLengthIs(Integer minLength, Integer maxLength);
    TextValidator whereFixedLentghIs(Integer fixedLength);
    TextValidator isNull();
    TextValidator isEmpty();
    TextValidator isNotNull();
    TextValidator isNotEmpty();
    TextValidator isNotNullAndNotEmpty();
    TextValidator isNullOrEmpty();
    TextValidator hasInvalidLength();
    TextValidator sizeIsNotIqualsTo();
    TextValidator sizeIsIqualsTo();
    TextValidator testRegex(boolean result);
}
