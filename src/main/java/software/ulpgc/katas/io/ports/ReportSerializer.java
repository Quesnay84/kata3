package software.ulpgc.katas.io.ports;

import software.ulpgc.katas.model.CastReport;

public interface ReportSerializer {
    String serialize(CastReport report);
}
