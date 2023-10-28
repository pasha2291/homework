package com.solvd.mapid.main;

import com.solvd.mapid.entity.employee.Contact;
import com.solvd.mapid.entity.employee.Department;
import com.solvd.mapid.entity.employee.FullName;
import com.solvd.mapid.entity.staff.*;

public class MainOffice {
    public static void main(String[] args) {
        CEO ceo = new CEO(
                new FullName("Albert", "Pokryshkin", "Izmailovich"),
                new Contact("+375291111111"),
                30000.0
        );
        ChiefEngineer chiefEngineer = new ChiefEngineer(
                new FullName("Arbuz", "Lastochkin", "Ivanovich"),
                new Contact("+375292222222"),
                20000.0
        );
        ChiefLaborOfficer chiefLaborOfficer = new ChiefLaborOfficer(
                new FullName("Alla", "Porkyshkina", "Arbuzovna"),
                new Contact("+375293333333"),
                20000.0
        );
        Engineer engineer = new Engineer(
                4,
                new FullName("Mihail", "Pyatrys", "Alibegovich"),
                new Contact("+375294444444"),
                3000.0
        );
        Worker oleg = new Worker(
                5,
                new FullName("Oleg", "Oleshkevich", "Ibragimovich"),
                new Department(2, "Engineering", "office 902"),
                new Contact("+375337777777"),
                3,
                1800.0
        ) ;
        Worker alexander = new Worker(
                6,
                new FullName("Alexander", "Murevich", "Alexandrovich"),
                new Department(2, "Engineering", "office 902"),
                new Contact("+375338888888"),
                4,
                1700.0
        ) ;
    }
}
