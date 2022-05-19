package com.cabBook.cabBook.service;

import com.cabBook.cabBook.model.Cab;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CabService {

    public static Map<Integer, Cab> cabs;
    public static List<Cab> cabsList;


    @PostConstruct
    public static void parse() {
        cabs = new HashMap<>();
        cabsList = new ArrayList<>();
        try {
            CSVReader reader =
                    new CSVReaderBuilder(new FileReader("C:\\Users\\mukul\\Desktop\\cab.csv")).
                            withSkipLines(1).
                            build();
            cabsList = reader.readAll().stream().map(data -> {
                Cab c1 = new Cab();
                c1.setLocationId(Integer.parseInt(data[0]));
                c1.setDriverName(data[1]);
                c1.setContactNumber(data[2]);
                c1.setVehicleType(data[3]);
                c1.setVehicleNumber(data[4]);
                c1.setAvailable(Boolean.parseBoolean(data[5]));
                return c1;
            }).collect(Collectors.toList());
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        cabsList.forEach(e -> cabs.put(e.getLocationId(), e));
    }


    static {
//        cabs = new HashMap<>();
//        Cab c1 = new Cab("Ashok", "98989898","Car", "HR-26 0091", true);
//        c1.setLocationId(100);
//        cabs.put(c1.getLocationId(), c1);
//        Cab c2 = new Cab("mani", "090909878","auto", "HR-26 7896", true);
//        c2.setLocationId(201);
//        cabs.put(c2.getLocationId(), c2);
//        Cab c3 = new Cab("lala", "09876534","car", "HR-26 2345", true);
//        c3.setLocationId(301);
//        cabs.put(c3.getLocationId(), c3);
//        Cab c4 = new Cab("ashih", "78902564","car", "HR-26 8798", false);
//        c4.setLocationId(11);
//        cabs.put(c4.getLocationId(), c4);
//        Cab c5 = new Cab("rahul", "987654","auto", "HR-26 6754", false);
//        c5.setLocationId(101);
//        cabs.put(c5.getLocationId(), c5);
//        Cab c6 = new Cab("duaa", "78990245","bike", "HR-26 7891", true);
//        c6.setLocationId(110);
//        cabs.put(c6.getLocationId(), c6);
//        Cab c7 = new Cab("hero", "87902453","bike", "HR-26 9898", false);
//        c7.setLocationId(102);
//        cabs.put(c7.getLocationId(), c7);
//        Cab c8 = new Cab("mohit", "87902453","auto", "HR-26 5678", true);
//        c8.setLocationId(150);
//        cabs.put(c8.getLocationId(), c8);
    }


    public void getCabs(Integer id) {
        parse();
        if (cabs.isEmpty()) {
            System.out.println("No cabs Available");
        }
        for (Map.Entry<Integer, Cab> entry : cabs.entrySet()) {
            if (entry.getValue().isAvailable()) {
                if (Math.abs(id - entry.getKey()) <= 100) {
                    System.out.println(entry.getValue());
                }
            }
        }
    }

    public List<Map.Entry<Integer, Cab>> getAllCabs() {
        parse();
        if (cabs.isEmpty()) {
            System.out.println("No Available cabs !");
        }
        return cabs.entrySet().stream().collect(Collectors.toList());
    }

//    public static void main(String... args) throws FileNotFoundException {
//
//        CabService cs = new CabService();
//        System.out.println(cs.getAllCabs());
//
//    }

}
