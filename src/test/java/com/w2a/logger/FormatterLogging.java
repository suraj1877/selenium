package com.w2a.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FormatterLogging extends Formatter {
    @Override
    public String format(LogRecord record) {
        return new Date(record.getMillis()) + "::" + record.getThreadID() + ":" + record.getMessage()+"\n";
    }
}
