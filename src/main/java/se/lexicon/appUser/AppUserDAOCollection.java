package se.lexicon.appUser;

import java.util.Collection;

public class AppUserDAOCollection implements AppUserDAO {
    Collection<AppUser> appUsers;

    public AppUserDAOCollection(Collection<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    @Override
    public AppUser persist(AppUser appUser) {
        if (!appUsers.contains(appUser)) {
            appUsers.add(appUser);
            return appUser;
        }
        return null;
    }

    @Override
    public AppUser findByUserName(String useName) {
        for (AppUser a : appUsers) {
            if (a.getUseName().equals(useName)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUsers;
    }

    @Override
    public void remove(String useName) {
        AppUser appUser = findByUserName(useName);
        if (appUser == null) {
            System.out.println("not found");
        } else {
            appUsers.remove(appUser);
            System.out.println("removed");
        }
    }
}
