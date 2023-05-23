import javax.swing.*;
import java.util.HashMap;

public class Logins {

    static HashMap<String,String> loginInfoUsers = new HashMap<String,String>();
    static HashMap<String,String> loginInfoEmployees = new HashMap<String,String>();

    Logins(){ //Pradiniai prisijungimo duomenys

        loginInfoUsers.put("vartotojas@email.com", "namas123");
        loginInfoEmployees.put("darbuotojas@email.com", "namas123");

    }

    public static void addLogin(int id, String email, String password){ //id 1 - Vartotojas, id 2 - Gaudytojas
    //Prideda naują paskyrą

        if(id==1){ //Vartotojui
            loginInfoUsers.put(email,password);
        }
        else if (id==2){ //Gaudytojui
            loginInfoEmployees.put(email,password);
        }
        else{
            JOptionPane.showMessageDialog(null,"Why is the ID not 1 or 2????"); //Debug
        }

    }

    protected static HashMap<String,String> getLoginsUsers(){ //Suteikia vartotoju hashmap (nepanaudotas)
        return loginInfoUsers;
    }

    protected HashMap<String,String> getLoginsEmployees(){ //suteikia gaudytoju hashmap (nepanaudotas)
        return loginInfoEmployees;
    }

    protected static boolean checkLogin(int id, String email, String password ){ //Tikrina ar prisijungimo duomenys teisingi

        boolean answer = false;


        //Jei el.paštas ir slaptažodis atitinka egzistuojančiai paskyrai, pažymimas atsakymas "true"
        if(id==1){ //Vartotojas
            if(loginInfoUsers.containsKey(email)){
                if(loginInfoUsers.get(email).equals(password)){
                    answer = true;
                }
            }
        }

        if(id==2){ //Gaudytojas
            if(loginInfoEmployees.containsKey(email)){
                if(loginInfoEmployees.get(email).equals(password)){
                    answer = true;
                }
            }
        }
        return answer;
    }


}
