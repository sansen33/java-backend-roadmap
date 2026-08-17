package com.sansen.roadmap.user;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final AtomicLong idGenerator = new AtomicLong(0);
    private final Map<Long, User> users = new ConcurrentHashMap<>();

    public List<User> findAll() {
        return users.values().stream().sorted(Comparator.comparing(User::id)).toList();
    }

    public User findById(Long id) {
        User user = users.get(id);
        if (user == null) throw new IllegalArgumentException("user not found: " + id);
        return user;
    }

    public User create(CreateUserRequest request) {
        long id = idGenerator.incrementAndGet();
        User user = new User(id, request.name(), request.age());
        users.put(id, user);
        return user;
    }

    public void delete(Long id) {
        if (users.remove(id) == null) throw new IllegalArgumentException("user not found: " + id);
    }
}
