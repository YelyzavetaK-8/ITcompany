import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EntityStore<T> {
    private final Map<Integer, T> entities = new HashMap<>();

    public void add(int id, T entity) {
        entities.put(id, entity);
    }

    public T getById(int id) {
        return entities.get(id);
    }

    public Collection<T> getAll() {
        return entities.values();
    }
}