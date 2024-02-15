package parkinglot.model.ticket;

import parkinglot.model.enums.VehicleType;
import parkinglot.model.exceptions.UnableToParseTicketStringException;

public class TicketParser {

    public static Ticket parseTicket(String ticketStr) throws UnableToParseTicketStringException {
        String[] parts = ticketStr.split("_");
        if(parts.length!=4){
            throw new UnableToParseTicketStringException("invalid ticket provided: "+ticketStr);
        }
        return new Ticket(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), VehicleType.valueOf(parts[3]));
    }
}
