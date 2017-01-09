package ua.crm.DB;

public interface UserService {
    CustomUser getUserByLogin(String login);
    void addUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
}
