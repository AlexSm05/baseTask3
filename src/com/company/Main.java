package com.company;
// В текстовом файле построчно записаны данные о людях в формате “Имя Возраст”. Например:
// Петр 28
// Дмитрий 26
// Василий 17
// Игорь 32

// Необходимо создать класс, представляющий сущность человека (с полями для имени и возраста, соответственно), которые будет хранить данные о каждом человеке, представленном в файле. Считать файл, сохранить все полученные объекты в список. Далее требуется:
// Вывести всех людей в порядке возрастания их возраста.
// Вывести, сколько раз каждое имя встречалось в списке, начиная от самых частых.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String fileHumans = "E://Human.txt";

        ArrayList<Human> humans = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileHumans));

        String line = reader.readLine();
            while (line!=null){
                Human h1= new Human().saveInArray(line);
                humans.add(h1);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        Collections.sort(humans);
        for (Human human1:humans) {
            System.out.println(human1.toString());
        }

        Map<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
       for (Human h:humans) {
            list.add(h.getName());
       }

        for (String s:list) {
            map.put(s,Collections.frequency(list,s));
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
