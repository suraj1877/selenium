package com.w2a.logger;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class LoginHandler extends StreamHandler {
    @Override
    public void publish(LogRecord record) {
        super.publish(record);
    }

    @Override
    public void flush() {
        super.flush();
    }

    @Override
    public void close() {
        super.close();
    }
}
