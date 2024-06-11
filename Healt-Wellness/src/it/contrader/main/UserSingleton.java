package it.contrader.main;

import it.contrader.model.User;
public class UserSingleton {

        private static User user = null;
        private int id;

        private String username, password, usertype;

        private UserSingleton() {
        }

        public static User getInstance() {
            if (user == null) {
                user = new User();
                return user;
            } else return user;
        }

        @Override
        public String toString() {
            return id + "\t" + username + "\t\t" + password + "\t\t" + usertype;
        }
    }



