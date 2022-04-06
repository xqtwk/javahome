package lt.ku;

import java.util.ArrayList;

public class StaffMember {
    protected String name, surname, phone;
    static class Trainee extends StaffMember{ // Praktikantas
        public Trainee(){

        }
        public Trainee(String n, String s, String p){
            name = n; surname = s; phone = p;
        }

    }
    static class Employee extends StaffMember{ // Darbuotojas
        protected String socDraudimoNr;
        protected double atlyginimas;
        public Employee(){}
        public Employee(String n, String s, String p, String d, double w){
            name = n; surname = s; phone = p; socDraudimoNr = d; atlyginimas = w;
        }
        @Override
        public double pay() {
            return atlyginimas;
        }

        @Override
        public String to_String() {
            return super.to_String() + ", socDraudimoNr: " + socDraudimoNr + ", atlyginimas: " + pay();
        }
        static class Executive extends Employee{ // Vadovas
            protected double Bonus = 0;

            public Executive(){}

            public Executive(String n, String s, String p, String d, double w){
                name = n; surname = s; phone = p; socDraudimoNr = d; atlyginimas = w;
            }
            void awardBonus(double b){
                Bonus += b;
            }

            @Override
            public String to_String() {
                return super.to_String();
            }

            @Override
            public double pay() {
                atlyginimas += Bonus;
                setBonus(0);
                return super.pay();
            }

            public void setBonus(double n){
                Bonus = n;
            }
        }

        static class Hourly extends Employee{ // Valandininkas
            protected int hoursWorked;
            public Hourly(String n, String s, String p, String d, double w){
                name = n; surname = s; phone = p; socDraudimoNr = d; atlyginimas = w;
            }
            public void addHours(int hours){
                hoursWorked += hours;
            }

            @Override
            public double pay() {
                atlyginimas = atlyginimas * hoursWorked;
                hoursWorked = 0;
                return super.pay();
            }
        }
    }


       public static void main(String[] args) {
        /*
        StaffMember Lukas = new StaffMember("Lukas", "Ddd", "+37060162955");
        StaffMember.Employee Jonas = new Employee("o","b","123", "M41", 1000);
        StaffMember.Employee.Executive Arnas = new StaffMember.Employee.Executive("Arnas","Daras","+37060961291", "491k", 2000);
        StaffMember.Employee.Hourly Marius = new StaffMember.Employee.Hourly("Marius","Amas","+37064561222", "99999k", 20);
        // Marius.addHours(valandos) - prideti Mariui uzdirbtas valandas.
        System.out.println(Marius.to_String());*/
           Staff personnel = new Staff();
           personnel.staffList = new StaffMember[0];
          /* Employee employee1 = new Employee("Jonas", "Jonaitis",
                   "+37064446135","4561389764", 1500.99);
           Employee employee2 = new Employee("Petras", "Petraitis",
                   "+37069993605","1679461320", 400.99);
           Trainee trainee1 = new Trainee("Kazys", "Kazaitis", "+37062223608");
           Employee.Executive executive1 = new Employee.Executive("Vadovas", "Vadovaitis",
                   "+37062223490","4316971310", 5000);
           Employee.Hourly hourly1 = new Employee.Hourly("Vardenis", "Pavardenis", "+37065556983",
                   "7946130654", 10);
           Employee.Hourly hourly2 = new Employee.Hourly("Valandininkas", "Valandininkaitis", "+37061358961",
                   "9463168946", 20);*/
           Employee e1 = new StaffMember.Employee("Jonas","Jonauskas","37060961291", "M41", 1000);
           Employee e2 = new StaffMember.Employee("Lukas","Brg","370619634699", "4444N", 1100);
           Trainee t1 = new StaffMember.Trainee("Marius","Mariauskas","37065265986");
           Employee.Executive ex1 = new StaffMember.Employee.Executive("Arnas","Daras","+37060961291", "491k", 2000);
           Employee.Hourly h1 = new StaffMember.Employee.Hourly("Marius","Amas","+37064561222", "99999k", 20);
           Employee.Hourly h2 = new StaffMember.Employee.Hourly("Linas","Linavicius","+37064661999", "96U8B", 20);
           personnel.addStaffMember(e1);
           personnel.addStaffMember(e2);
           personnel.addStaffMember(t1);
           personnel.addStaffMember(ex1);
           personnel.addStaffMember(h1);
           personnel.addStaffMember(h2);
           ex1.awardBonus(150);
           h1.addHours(10);
           h2.addHours(20);

           System.out.println("Viso skirta darbo užmokesčiui: " + personnel.payDay());
           //System.out.println(Arrays.toString(personnel.staffList));

           //-----------------------
    }
    public StaffMember(){

    }
    public StaffMember(String n, String s, String p){
        this.name = n; this.surname = s; this.phone = p;
    }
    public String get_name(){
        return name;
    }
    public String get_surname(){
        return surname;
    }
    public String get_phone(){
        return phone;
    }
    public String to_String(){
        return "Name:" + get_name() + ", Surname: " + get_surname() + ", Phone:" + get_phone();
    }
    public double pay(){
        return 0;
    }
}
