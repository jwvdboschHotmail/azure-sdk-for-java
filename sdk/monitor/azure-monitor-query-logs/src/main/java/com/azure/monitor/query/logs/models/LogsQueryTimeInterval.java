// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.monitor.query.logs.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Class to represent a time interval.
 * Time intervals are inclusive at the start time and exclusive at the end time.
 */
@Immutable
public final class LogsQueryTimeInterval {
    /**
     * Time interval of all time.
     */
    public static final LogsQueryTimeInterval ALL = new LogsQueryTimeInterval(OffsetDateTime.MIN, OffsetDateTime.MAX);

    /**
     * Time interval of the last 5 minutes.
     */
    public static final LogsQueryTimeInterval LAST_5_MINUTES = new LogsQueryTimeInterval(Duration.ofMinutes(5));

    /**
     * Time interval of the last 30 minutes.
     */
    public static final LogsQueryTimeInterval LAST_30_MINUTES = new LogsQueryTimeInterval(Duration.ofMinutes(30));

    /**
     * Time interval of the last hour.
     */
    public static final LogsQueryTimeInterval LAST_1_HOUR = new LogsQueryTimeInterval(Duration.ofHours(1));

    /**
     * Time interval of the last 4 hours.
     */
    public static final LogsQueryTimeInterval LAST_4_HOURS = new LogsQueryTimeInterval(Duration.ofHours(4));

    /**
     * Time interval of the last 12 hours.
     */
    public static final LogsQueryTimeInterval LAST_12_HOURS = new LogsQueryTimeInterval(Duration.ofHours(12));

    /**
     * Time interval of the last day.
     */
    public static final LogsQueryTimeInterval LAST_DAY = new LogsQueryTimeInterval(Duration.ofDays(1));

    /**
     * Time interval of the last 2 days.
     */
    public static final LogsQueryTimeInterval LAST_2_DAYS = new LogsQueryTimeInterval(Duration.ofDays(2));

    /**
     * Time interval of the last 3 days.
     */
    public static final LogsQueryTimeInterval LAST_3_DAYS = new LogsQueryTimeInterval(Duration.ofDays(3));

    /**
     * Time interval of the last 7 days.
     */
    public static final LogsQueryTimeInterval LAST_7_DAYS = new LogsQueryTimeInterval(Duration.ofDays(7));

    private static final ClientLogger LOGGER = new ClientLogger(LogsQueryTimeInterval.class);
    private static final String ERROR_MESSAGE = "%s is an invalid time interval. It must be in one of the "
        + "following ISO 8601 time interval formats: duration, startDuration/endTime, "
        + "startTime/endTime, startTime/endDuration";

    private final Duration duration;
    private final OffsetDateTime startTime;
    private final OffsetDateTime endTime;

    /**
     * Creates an instance of {@link LogsQueryTimeInterval} using the provided duration. The duration is the interval that starts
     * from the provided duration and ends at the current time.
     *
     * @param duration the duration for this query time span.
     */
    public LogsQueryTimeInterval(Duration duration) {
        this.duration = Objects.requireNonNull(duration, "'duration' cannot be null");
        this.startTime = null;
        this.endTime = null;
    }

    /**
     * Creates an instance of {@link LogsQueryTimeInterval} using the start and end {@link OffsetDateTime OffsetDateTimes}.
     *
     * @param startTime The start time of the interval.
     * @param endTime The end time of the interval.
     */
    public LogsQueryTimeInterval(OffsetDateTime startTime, OffsetDateTime endTime) {
        this.startTime = Objects.requireNonNull(startTime, "'startTime' cannot be null");
        this.endTime = Objects.requireNonNull(endTime, "'endTime' cannot be null");
        this.duration = null;
    }

    /**
     * Creates an instance of {@link LogsQueryTimeInterval} using the start and end duration of the interval.
     *
     * @param startTime The start time of the interval.
     * @param duration The end duration of the interval.
     */
    public LogsQueryTimeInterval(OffsetDateTime startTime, Duration duration) {
        this.startTime = Objects.requireNonNull(startTime, "'startTime' cannot be null");
        this.duration = Objects.requireNonNull(duration, "'duration' cannot be null");
        this.endTime = null;
    }

    /**
     * Creates an instance of {@link LogsQueryTimeInterval} using the start and end duration of the interval.
     *
     * @param duration The duration of the interval.
     * @param endTime The end time of the interval.
     */
    LogsQueryTimeInterval(Duration duration, OffsetDateTime endTime) {
        this.endTime = Objects.requireNonNull(endTime, "'endTime' cannot be null");
        this.duration = Objects.requireNonNull(duration, "'duration' cannot be null");
        this.startTime = null;
    }

    /**
     * Returns the duration of this {@link LogsQueryTimeInterval} instance.
     *
     * @return the duration of this {@link LogsQueryTimeInterval} instance.
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Returns the start time of this {@link LogsQueryTimeInterval} instance.
     *
     * @return the start time of this {@link LogsQueryTimeInterval} instance.
     */
    public OffsetDateTime getStartTime() {
        if (startTime != null) {
            return startTime;
        }
        // This check is not required as the constructor would not allow duration and endtime to be null if
        // startTime is null. But spotbugs raises an error for not checking null here.
        if (duration != null && endTime != null) {
            return endTime.minusNanos(duration.toNanos());
        }
        return null;
    }

    /**
     * Returns the end time of this {@link LogsQueryTimeInterval} instance.
     *
     * @return the end time of this {@link LogsQueryTimeInterval} instance.
     */
    public OffsetDateTime getEndTime() {
        if (endTime != null) {
            return endTime;
        }
        if (startTime != null && duration != null) {
            return startTime.plusNanos(duration.toNanos());
        }
        return null;
    }

    /**
     * This method takes an ISO 8601 formatted time interval string and returns an instance of {@link LogsQueryTimeInterval}.
     *
     * @param value The ISO 8601 formatted time interval string.
     * @return An instance of {@link LogsQueryTimeInterval}.
     * @throws IllegalArgumentException if {@code value} is not in the correct format.
     */
    public static LogsQueryTimeInterval parse(String value) {
        Objects.requireNonNull(value);

        String[] parts = value.split("/");
        if (parts.length == 1) {
            // duration
            Duration duration = parseDuration(parts[0]);
            if (duration == null || parts[0].length() + 1 == value.length()) {
                // input strings like "PT24H/" are invalid
                throw LOGGER.logExceptionAsError(new IllegalArgumentException(String.format(ERROR_MESSAGE, value)));
            }

            return new LogsQueryTimeInterval(duration);
        }

        if (parts.length == 2) {
            Duration startDuration = parseDuration(parts[0]);
            OffsetDateTime startTime = parseTime(parts[0]);

            Duration endDuration = parseDuration(parts[1]);
            OffsetDateTime endTime = parseTime(parts[1]);

            if (startDuration != null && endTime != null) {
                return new LogsQueryTimeInterval(startDuration, endTime);
            }
            if (startTime != null && endTime != null) {
                return new LogsQueryTimeInterval(startTime, endTime);
            }
            if (startTime != null && endDuration != null) {
                return new LogsQueryTimeInterval(startTime, endDuration);
            }
        }
        throw LOGGER.logExceptionAsError(new IllegalArgumentException(String.format(ERROR_MESSAGE, value)));
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (duration != null && endTime != null) {
            sb.append("duration: ").append(duration).append(", ").append("end time: ").append(endTime);
        } else if (startTime != null && endTime != null) {
            sb.append("start time: ").append(startTime).append(", ").append("end time: ").append(endTime);
        } else if (startTime != null && duration != null) {
            sb.append("start time: ").append(startTime).append(", ").append("duration: ").append(duration);
        } else {
            sb.append("duration: ").append(duration);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LogsQueryTimeInterval that = (LogsQueryTimeInterval) o;

        return Objects.equals(this.duration, that.duration)
            && Objects.equals(this.startTime, that.startTime)
            && Objects.equals(this.endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, startTime, endTime);
    }

    private static OffsetDateTime parseTime(String value) {
        try {
            return OffsetDateTime.parse(value);
        } catch (Exception exception) {
            return null;
        }
    }

    private static Duration parseDuration(String value) {
        try {
            return Duration.parse(value);
        } catch (Exception exception) {
            return null;
        }
    }
}
