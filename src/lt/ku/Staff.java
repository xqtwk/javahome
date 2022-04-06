package lt.ku;
import java.util.*;


public class Staff {
    StaffMember[] staffList;
    public void addStaffMember(StaffMember staff){
        this.staffList = Arrays.copyOf(this.staffList, this.staffList.length + 1);
        this.staffList[staffList.length - 1] = staff;

    }

    public double payDay(){
        double result = 0;
        for(StaffMember staff : this.staffList){
            System.out.println(staff.name + " " + staff.surname + " " + staff.pay());
            result += staff.pay();
        }
        return result;
    }
}
