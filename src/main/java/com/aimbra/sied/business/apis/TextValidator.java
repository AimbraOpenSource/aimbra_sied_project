package com.aimbra.sied.business.apis;

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
}
