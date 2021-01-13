package com.vaibhav.Agora.CustomRepositories;

import com.vaibhav.Agora.Common.Utils.Utilities;
import com.vaibhav.Agora.DTOEntities.BookDTO;
import com.vaibhav.Agora.Entities.Book;
import com.vaibhav.Agora.Entities.BookUnit;
import com.vaibhav.Agora.RequestEntities.BookSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@Component
public class BookCustomRepository {

    @Autowired
    BasicCustomRepository basicCustomRepository;

    private String BOOK_RETRIVEL_QUERY = "Select new BookDTO(b.bookId as bookId, b.title as title, " + "" +
            " b.authorId as authorId, b.category as category, b.genre as genre, b.publicationId as publicationId, b.edition as edition, " + "" +
            " b.language as language, b.authorId as authorId, b.authorId as authorId,  )  ";
    private String BOOK_FROM_CLAUSE = "From book b join b.bookUnits bu join b.ratings r";



    public List<BookDTO> getBooks(BookSearchRequest bookSearchRequest) {
        Map<String, Object> parameters = new HashMap<>();
        final String whereQuery = generateWhereQueryForBookSearch(bookSearchRequest, parameters);
        List<BookDTO> books = basicCustomRepository.getQueryResult(BOOK_RETRIVEL_QUERY + BOOK_FROM_CLAUSE + whereQuery, parameters, 1, 100, BookDTO.class);
        return books;
    }

//    public List<BookUnit> getBookUnits(BookSearchRequest bookSearchRequest) {
//
//    }

    private String generateWhereQueryForBookSearch(BookSearchRequest bookSearchRequest, Map<String, Object> parameters) {
        StringBuilder whereQuery = new StringBuilder(" where ");
        if (Utilities.isNotEmpty(bookSearchRequest.getBookIds())) {
            parameters.put("bookIds", bookSearchRequest.getBookUnitIds());
            whereQuery.append(" b.bookId in :(bookIds)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getAuthorIds())) {
            parameters.put("authorIds", bookSearchRequest.getAuthorIds());
            whereQuery.append(" b.authorId in :(authorIds)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getBookUnitIds())) {
            parameters.put("bookUnitIds", bookSearchRequest.getBookUnitIds());
            whereQuery.append(" b.bookUnitId in :(bookUnitIds)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getCategories())) {
            parameters.put("categories", bookSearchRequest.getCategories());
            whereQuery.append(" b.category in :(categories)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getGenres())) {
            parameters.put("genres", bookSearchRequest.getGenres());
            whereQuery.append(" b.genre in :(genres)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getEditions())) {
            parameters.put("editions", bookSearchRequest.getEditions());
            whereQuery.append(" b.edition in :(editions)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getPublications())) {
            parameters.put("publications", bookSearchRequest.getBookUnitIds());
            whereQuery.append(" b.publication in :(publications)");
        }

        if (Utilities.isNotEmpty(bookSearchRequest.getTitles())) {
            parameters.put("titles", bookSearchRequest.getTitles());
            whereQuery.append(" b.titles in :(titles)");
        }

        if (Objects.nonNull(bookSearchRequest.isAvailable())) {
            parameters.put("isAvailable", bookSearchRequest.isAvailable());
            whereQuery.append(" bu.isAvailable is :isAvailable");
        }

        if (Objects.nonNull(bookSearchRequest.isReserved())) {
            parameters.put("isReserved", bookSearchRequest.isReserved());
            whereQuery.append(" bu.isReserved is :isReserved");
        }

        if (Objects.nonNull(bookSearchRequest.getRating())) {
            parameters.put("rating", bookSearchRequest.getRating());
            whereQuery.append(" b.rating > :rating");
        }

        if (Objects.nonNull(bookSearchRequest.getRating())) {
            parameters.put("addedDate", bookSearchRequest.getAddedDate());
            whereQuery.append(" b.added_date > :addedDate");
        }

        return whereQuery.toString();
    }
}
