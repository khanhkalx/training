package com.faceNet.manegementSystem.Untils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateUtil {
    public static final String FULL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String LEGAL_DATE_FORMAT = "yyyyMMdd";
    public static final String MOBILE_DATE_FORMAT = "ddMMyyyy";
    public static final String FULL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DDMMYYYYHHMMSS = "ddMMyyyyHHmmss";
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ofPattern("d/M/yyyy", Locale.ENGLISH))  // định dạng d/M/yyyy với "/"
            .appendOptional(DateTimeFormatter.ofPattern("d-M-yyyy", Locale.ENGLISH))  // định dạng d-M-yyyy với "-"
            .toFormatter();
    public static final String readableDateFormat = "dd/MM/yyyy";
    private static final List<String> DATE_FORMATS = new ArrayList<String>() {{
        add("yyyy-MM-dd");
        add("dd/MM/yyyy");
        add("MM/dd/yyyy");
        add("yyyy/MM/dd");
        add("dd-MM-yyyy");
        add("MM-dd-yyyy");
        add("yyyy.MM.dd");
        add("dd.MM.yyyy");
        add("MM.dd.yyyy");
        // Thêm các định dạng khác nếu cần
    }};


    private DateUtil() {
    }

    public static LocalDateTime convertStringToDateTime(
            final String dateFormat, final String date) {
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern(dateFormat);
        return LocalDateTime.parse(date, dateTimeFormatter);
    }

    public static Date localDateToDate(final LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String convertDateToString(
            final String dateFormat, final LocalDateTime date) {
        if (date == null) return null;
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern(dateFormat);
        return date.format(dateTimeFormatter);
    }

    public static String convertDateToString(
            final String dateFormat, final LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter.ofPattern(dateFormat);
        return date.format(dateTimeFormatter);
    }

    public static String convertDateStringToString(String input, String formatIn, String formatOut) {
        return convertDateToString(formatOut, convertStringToLocalDate(formatIn, input));
    }

    public static String convertDateToString(
            final String dateFormat, final Date date) {
        return convertDateToString(dateFormat, convertDateToLocalDateTime(date));
    }

    public static LocalDate convertStringToLocalDate(
            final String dateFormat, final String date) {
        if (StringUtils.isNotEmpty(date)) {
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormatter.ofPattern(dateFormat);
            return LocalDate.parse(date, dateTimeFormatter);
        }
        return null;
    }

    public static long timeDiff(ChronoUnit chronoUnit,
                                LocalDateTime date1,
                                LocalDateTime date2) {
        return chronoUnit.between(date1, date2);
    }


    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date convertStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        try {
            if (dateString != null && !dateString.isEmpty()) {
                return dateFormat.parse(dateString);
            }
            return null;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date convertDataStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        try {
            if (dateString != null && !dateString.isEmpty()) {
                String[] parts = dateString.split("#");
                String dateToParse = parts.length > 1 ? parts[1] : dateString;
                return dateFormat.parse(dateToParse);
            }
            return null;
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date checkDate(String date, String pattern) {
        if (StringUtils.isNotEmpty(date)) {
            return convertStringToDate(date, pattern);
        }
        return null;
    }

    public static boolean isValidDateFormat(String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString, FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static Date convertStringToDateForAllPattern(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }

        for (String format : DATE_FORMATS) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                return sdf.parse(dateString);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }

    public static String convertDate(String inputDate, String inputPattern) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
