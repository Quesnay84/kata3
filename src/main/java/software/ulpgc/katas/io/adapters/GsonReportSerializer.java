package software.ulpgc.katas.io.adapters;

import com.google.gson.GsonBuilder;
import software.ulpgc.katas.io.ports.ReportSerializer;
import software.ulpgc.katas.model.CastReport;

public record GsonReportSerializer() implements ReportSerializer {

    @Override
    public String serialize(CastReport report) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(report);
    }
}
