package com.example.bookshop;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class HibernateBookRepository implements BookRepository {

    private final EntityTransaction transaction;
    private final EntityManager entityManager;

    HibernateBookRepository(SessionFactory sessionFactory) {
        this.entityManager = sessionFactory.createEntityManager();
        this.transaction = entityManager.getTransaction();
    }

    @Override
    public void save(Book book) {
        try {
            transaction.begin();
            //zapis ksiazki do bazy
            entityManager.persist(book);
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            transaction.begin();
            return entityManager.createQuery("SELECT b FROM book b", Book.class).getResultList();
        } finally {
            transaction.commit();
        }
    }


    @Override
    public Book findBookByIsbn(long isbn) {
        try {
            transaction.begin();

            return entityManager.createQuery("SELECT b FROM book b WHERE b.isbn = :bookisbn", Book.class)
                    .setParameter("bookisbn", isbn)
                    .getSingleResult();

        } finally {
            transaction.commit();
        }
    }

    @Override
    public long deleteBookByIsbn(long isbn) {
        try {
            transaction.begin();
            Book book = entityManager.find(Book.class, isbn);
            entityManager.remove(book);
            return isbn;
        } finally {
            transaction.commit();
        }
    }

    @Override
    public Book updateBook(Book book) {
        try {
            transaction.begin();
            entityManager.merge(book);
            return book;
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Book> findBooksByCategory(String categorySearched) {
        try {
            transaction.begin();

            return entityManager.createQuery("SELECT b FROM book b WHERE b.booksCategory = :category", Book.class)
                    .setParameter("category", categorySearched)
                    .getResultList();
        } finally {
            transaction.commit();
        }
    }
}
