package software.ulpgc.katas.io.ports;

import software.ulpgc.katas.model.CastReport;

public interface ReportWriter {
    void write(CastReport report);
}
