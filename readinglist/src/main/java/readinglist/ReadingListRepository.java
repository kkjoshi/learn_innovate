package readinglist;

/**
 * Created by joshika on 5/26/2016.
 */

    import java.util.List;
    import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);

}