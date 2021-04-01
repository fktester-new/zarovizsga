package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            //return findMinHour(result).toString();
            return findMinHourByComparator(result).toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file!", ioe);
        }
    }

    private Work parseLine(String line) {
        String[] temp = line.split(",");
        return new Work(temp[0], Integer.parseInt(temp[1]), LocalDate.parse(temp[2]));

    }

    private Work findMinHour(List<Work> works) {
        if (works == null) {
            throw new IllegalArgumentException("There is no work to evaluate!");
        }
        int minHour = 25;
        Work minWork = null;
        for (Work work : works) {
            if (work.getWorkHours() < minHour) {
                minHour = work.getWorkHours();
                minWork = work;
            }
        }
        return minWork;
    }

    private Work findMinHourByComparator(List<Work> works) {
        if (works == null) {
            throw new IllegalArgumentException("There is no work to evaluate!");
        }
        return Collections.min(works, new Comparator<Work>() {
                    @Override
                    public int compare(Work o1, Work o2) {
                        return o1.getWorkHours() - o2.getWorkHours();
                    }
                }

        );
    }
}
