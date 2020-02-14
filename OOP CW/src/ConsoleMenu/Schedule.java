package ConsoleMenu;

import java.math.BigDecimal;
import java.util.Date;

public class Schedule {
    private Date pickUpDate;
    private Date dropOffDate;

    public Schedule(Date pickUpDate, Date dropOffDate) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
    public int NumberOfRentedDays(){
        return 0;
    }
    public BigDecimal calculatePaymentForRentedDays(){
        return null;
    }
}
