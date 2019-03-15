package api.repository;

public abstract class BaseRepository<T> {
    protected T model;
    protected static BaseRepository instance;

    private BaseRepository(){}

    public BaseRepository(T model) {
        this.model = model;
    }

    T getById(long id){
        return null;
    }
}
