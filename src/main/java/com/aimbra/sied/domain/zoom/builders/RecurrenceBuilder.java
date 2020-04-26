package com.aimbra.sied.domain.zoom.builders;

import com.aimbra.sied.domain.zoom.dtos.ZRecurrenceRequestDto;

public abstract class RecurrenceBuilder {
    public static ZRecurrenceRequestDto builder() {
        var recurrence = new ZRecurrenceRequestDto();
        recurrence.setType(1);
        return recurrence;
    }
}
