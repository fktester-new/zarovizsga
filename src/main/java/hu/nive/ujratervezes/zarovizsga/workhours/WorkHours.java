package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        List<Work> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Work work = parseLine(line);
                result.add(work);
            }
            Collections.sort(result);
            return Collections.min(result).toString();
        } catch(IOException ioe){
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    private Work parseLine(String line){
        String[] temp = line.split(",");
        Work work = new Work(temp[0],Integer.parseInt(temp[1]), LocalDate.parse(temp[2]));
        return work;
    }
}
