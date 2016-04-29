package DAO;

import java.util.List;

/* CRUD interfejs u kojem su definisane osnove operacije sa bazom 
 * Create, read, update, delete
 * mogu se dodati i neke tipe, da se vrati lista objekata
 * Interfejs se genericki, odnosno moze primati objekte bilo kojeg tipa
 */ 

public interface CRUD<T> {
	long create(T entity);
	void update(T entity);
	void delete(T entity);
	T getById(long id);
	List<T> getAll();
}
