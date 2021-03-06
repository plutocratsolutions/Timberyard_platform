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
public class ExcludeNothingWithPrettyPrintingOffJsonSerializerGoogleGson {

	
	private final Gson gson;

    public ExcludeNothingWithPrettyPrintingOffJsonSerializerGoogleGson() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDate.class, new JodaLocalDateAdapter());
        builder.registerTypeAdapter(DateTime.class, new JodaDateTimeAdapter());
        builder.registerTypeAdapter(MonthDay.class, new JodaMonthDayAdapter());

        this.gson = builder.create();
    }

    public String serialize(final Object result) {
        String returnedResult = null;
        final String serializedResult = this.gson.toJson(result);
        if (!"null".equalsIgnoreCase(serializedResult)) {
            returnedResult = serializedResult;
        }
        return returnedResult;
    }
}
