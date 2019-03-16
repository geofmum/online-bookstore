package api.repository;

public interface IRepository<T> {
    T getById(long id);
}
