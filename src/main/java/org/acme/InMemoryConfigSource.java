package org.acme;

import io.quarkus.runtime.annotations.StaticInitSafe;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@StaticInitSafe
public class InMemoryConfigSource implements ConfigSource {
    private static final Map<String, String> configuration = new HashMap<>();

    static {
        configuration.put("quarkus.datasource.db-kind", "postgresql");
        configuration.put("quarkus.datasource.jdbc.url" ,"url");
        configuration.put("quarkus.datasource.username" , "foo");
        configuration.put("quarkus.datasource.password" , "bar");
        configuration.put("quarkus.hibernate-orm.database.generation", "update");
    }

    @Override
    public int getOrdinal() {
        return 400;
    }

    @Override
    public Set<String> getPropertyNames() {
        return configuration.keySet();
    }

    @Override
    public String getValue(final String propertyName) {
        return configuration.get(propertyName);
    }

    @Override
    public String getName() {
        return InMemoryConfigSource.class.getSimpleName();
    }
}
