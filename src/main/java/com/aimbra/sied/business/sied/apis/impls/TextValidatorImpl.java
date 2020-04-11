package com.aimbra.sied.business.sied.apis.impls;

import com.aimbra.sied.business.sied.apis.TextValidator;
import com.aimbra.sied.domain.sied.exceptions.BadRequestException;

public class TextValidatorImpl implements TextValidator {
    private String value;
    private String messageError;
    private Integer minLength;
    private Integer maxLength;
    private Integer fixedLength;

    private TextValidatorImpl() {}

    public static TextValidator init() {
        return new TextValidatorImpl();
    }

    private void isLessThenZero(Integer value) {
        if (value < 0)
            throw new BadRequestException("The value is less than zero");
    }

    @Override
    public TextValidator whereFixedLentghIs(Integer fixedLength) {
        this.fixedLength = fixedLength;
        return this;
    }

    @Override
    public TextValidator whereValueIs(String value) {
        this.value = value;
        return this;
    }

    @Override
    public TextValidator whereMessageErrorIs(String messageError) {
        this.messageError = messageError;
        return this;
    }

    @Override
    public TextValidator whereRangeLengthIs(Integer minLength, Integer maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        return this;
    }

    @Override
    public Boolean isValid() {
        return true;
    }

    @Override
    public TextValidator isNull() {
        if (value == null) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is null");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator isEmpty() {
        if (value != null && value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is Empty");
        }
        messageError = null;
        return this;
    }


    @Override
    public TextValidator isNotNull() {
        if (value != null) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is not null");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator isNotEmpty() {
        if (!value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is not Empty");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator isNotNullAndNotEmpty() {
        if (value != null && !value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is not null and not Empty");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator isNullOrEmpty() {
        if (value == null || value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is null or Empty");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator hasInvalidLength() {
        if (value == null || minLength == null || maxLength == null) {
            throw new BadRequestException("Check the input parameters, please!");
        }
        isLessThenZero(minLength);
        isLessThenZero(maxLength);
        if (minLength > maxLength) {
            throw new BadRequestException("Range is wrong");
        }
        if (value.length() < minLength || value.length() > maxLength) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("The value must be between " + minLength + " and " + maxLength + " characters.");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator sizeIsNotIqualsTo() {
        if (fixedLength == null) {
            throw new BadRequestException("Fixed length is null!");
        }
        isLessThenZero(fixedLength);
        if (!fixedLength.equals(value.length())) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("The size is equals");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator sizeIsIqualsTo() {
        if (fixedLength == null) {
            throw new BadRequestException("Fixed length is null!");
        }
        isLessThenZero(fixedLength);
        if (fixedLength.equals(value.length())) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("The size is equals");
        }
        messageError = null;
        return this;
    }

    @Override
    public TextValidator testRegex(boolean result) {
        if (!result) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("Email not valid");
        }
        messageError = null;
        return this;
    }
}
