package ys09.data.jdbc;

import ys09.data.Limits;
import ys09.data.UserDAO;
import ys09.model.User;

import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {

    private final DataAccess dataAccess;

    public UserDAOImpl(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public List<User> getUsers(Limits limits) {
        List<User> users = dataAccess.getUsers(limits.getStart(), limits.getCount());
        limits.setTotal(dataAccess.countUsers());
        return users;
    }

    @Override
    public Optional<User> getById(long id) {
        return dataAccess.getUser(id);
    }
}
