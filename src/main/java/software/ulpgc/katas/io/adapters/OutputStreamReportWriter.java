package software.ulpgc.katas.io.adapters;

import software.ulpgc.katas.io.ports.ReportSerializer;
import software.ulpgc.katas.io.ports.ReportWriter;
import software.ulpgc.katas.model.CastReport;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

public record OutputStreamReportWriter(OutputStream output, ReportSerializer serializer) implements ReportWriter {

    @Override
    public void write(CastReport report) {
        try{
            output.write(serializer.serialize(report).getBytes(StandardCharsets.UTF_8));
            output.flush();
        } catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
