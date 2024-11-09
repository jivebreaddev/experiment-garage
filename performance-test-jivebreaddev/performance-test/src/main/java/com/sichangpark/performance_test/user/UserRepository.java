package com.sichangpark.performance_test.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private static final Map<UUID, User> values = new ConcurrentHashMap<>();

    public void addUser() {
        UUID uuid = UUID.randomUUID();

        values.put(uuid, new User(uuid, "hello"));
    }
// dssd
    public List<User> findAll() {
        if (values.isEmpty()) {
            for (int i = 0; i < 100; i++) {
                addUser();
            }
        }

        return values.values()
                .stream()
                .toList();
    }

}
