package com.timber.timberyard.auth.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.timber.timberyard.auth.model.adapter.JodaDateTimeAdapter;
import com.timber.timberyard.auth.model.adapter.JodaLocalDateAdapter;
import com.timber.timberyard.auth.model.adapter.JodaMonthDayAdapter;

@Component
public class ExcludeNothingWithPrettyPrintingOnJsonSerializerGoogleGson {

	private final Gson gson;

    public ExcludeNothingWithPrettyPrintingOnJsonSerializerGoogleGson() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new JodaLocalDateAdapter());
        builder.registerTypeAdapter(DateTime.class, new JodaDateTimeAdapter());
        builder.registerTypeAdapter(MonthDay.class, new JodaMonthDayAdapter());
        builder.setPrettyPrinting();

        this.gson = builder.create();
    }

    public String serialize(final Object result) {
        return this.gson.toJson(result);
    }
}
