package main.java.com.utils;

import main.java.com.models.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class DataUtilitaire {
    private static final List<Utilisateur> utilisateurs = new ArrayList<>();

    public static List<Utilisateur> getAllUser() {
        if (utilisateurs.size() <= 0 ) {
            utilisateurs.add(new Utilisateur(1L, "nom1", "prenom1", "login1", "password1"));
            utilisateurs.add(new Utilisateur(2L, "nom2", "prenom2", "login2", "password2"));
            utilisateurs.add(new Utilisateur(3L, "nom3", "prenom3", "login3", "password3"));
            utilisateurs.add(new Utilisateur(4L, "nom4", "prenom4", "login4", "password4"));
            utilisateurs.add(new Utilisateur(5L, "nom5", "prenom5", "login5", "password5"));
        }
        return utilisateurs;
    }

    public static Utilisateur login(UserLoginModel userLoginModel) {
       return utilisateurs.stream()
                .filter(user ->
                        user.getLogin().equals(userLoginModel.getLogin())
                        && user.getPassword().equals(userLoginModel.getPassword()))
                .findAny()
                .orElse(null);
//               comme equivalent on peut avoir
        /*for (Utilisateur u : utilisateurs) {
            if (u.getLogin().equals(userLoginModel.getLogin()) && u.getPassword().equals(userLoginModel.getPassword())) {
                return u;
            }
        }*/
    }

    public static boolean addUser(Utilisateur utilisateur) {
        try {
            utilisateur.setId(Long.valueOf("" + utilisateurs.size()+1));
            utilisateurs.add(utilisateur);
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

}
