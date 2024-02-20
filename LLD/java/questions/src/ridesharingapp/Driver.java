package ridesharingapp;

import ridesharingapp.model.enums.Command;
import ridesharingapp.orchestrator.RideSharingApp;
import ridesharingapp.strategy.earliestending.EarliestEndingPreferenceStrategy;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Driver {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/anuragverma/IdeaProjects/learning-system-design/LLD/java/questions/src/ridesharingapp/input.txt";
        RideSharingApp rideSharingApp = new RideSharingApp(new EarliestEndingPreferenceStrategy());
        System.out.println("Ride sharing App");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while((line=br.readLine())!=null){
            try {
                String[] parts = line.split(" ");
                Command cmd = Command.valueOf(parts[0]);
                String origin, dest, userName;
                switch (cmd) {
                    case CREATE_USER:
                        String name = parts[1];
                        String gender = parts[2];
                        int age = Integer.parseInt(parts[3]);
                        rideSharingApp.createUser(name, gender, age);
                        break;
                    case ADD_USER_VEHICLE:
                        userName = parts[1];
                        String vehicleName = parts[2];
                        String regNo = parts[3];
                        int seats = Integer.parseInt(parts[4]);
                        rideSharingApp.addVehicle(userName, vehicleName, regNo, seats);
                        break;
                    case OFFER_RIDE:
                        origin = parts[1]; dest = parts[2];
                        long duration = Long.parseLong(parts[3]);
                        String startTime = parts[4]+" "+parts[5]; // dd/mm/yyyy 15:40
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                        LocalDateTime localDateTime = LocalDateTime.parse(startTime, dateTimeFormatter);
                        String owner = parts[6];
                        String ownerVehicle = parts[7];
                        rideSharingApp.offerRide(origin, dest, duration, localDateTime, owner, ownerVehicle);
                        break;
                    case TAKE_RIDE:
                        String takenBy = parts[1];
                        origin = parts[2]; dest = parts[3];
                        rideSharingApp.takeRide(takenBy, origin, dest);
                        break;
                    case SHOW_AVAILABLE_RIDES:
                        origin = parts[1]; dest = parts[2];
                        rideSharingApp.showAvailableRide(origin, dest);
                        break;
                    case SHOW_OFFERED_RIDE:
                        userName = parts[1];
                        rideSharingApp.showOfferedRide(userName);
                        break;
                    case SHOW_TAKEN_RIDE:
                        userName = parts[1];
                        rideSharingApp.showTakenRide(userName);
                        break;
                    case EXIT:
                        System.exit(0);

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
