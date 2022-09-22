package com.sofka.docs;

import com.sofka.docs.values.LogHistoryId;

import java.util.HashSet;
import java.util.Set;

public class LogHistoryFactory {
    private final Set<LogHistory> logsHistory;

    public LogHistoryFactory() {
        this.logsHistory = new HashSet<LogHistory>();
    }
    public void addLogHistory(LogHistoryId logHistoryId) {
        logsHistory.add(new LogHistory(logHistoryId));
    }

    public Set<LogHistory> getLogsHistory() {
        return logsHistory;
    }
}
