package ru.geekbrains.SpringLessonSix.input;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("userApp")
@Data
@NoArgsConstructor
public class Console {
    private boolean goOn = true;
    @Autowired
    private CommandAnalyser analyser;

    Scanner scanner = new Scanner(System.in);

    public void start(){
        while (goOn){
            System.out.println("Input command:");
            String command = scanner.nextLine();
            analyser.analyse(command);
        }
    }
}
