package ru.geekbrains.SpringLessonSix.input;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.SpringLessonSix.service.StatisticService;

@Component
@NoArgsConstructor
@Data
public class CommandAnalyser {

    @Autowired
    private StatisticService statisticService;

    public void analyse(String command){
        String[] commandLine= command.split(" ");
        if (commandLine.length<2){
            System.out.println("Invalid input.");
            return;
        }
        switch (commandLine[0]){
            case "product":
                getProduct(commandLine);
                break;
            case  "person":
                getPerson(commandLine);
                break;
            default:
                System.out.println("Command unrecognized.");

        }
    }

    public void getProduct(String[]commandLine){
        int id = Integer.parseInt(commandLine[1]);
        statisticService.printProduct(id);
    }
    public void getPerson(String[]commandLine){
        int id = Integer.parseInt(commandLine[1]);
        statisticService.printPerson(id);
    }
}
