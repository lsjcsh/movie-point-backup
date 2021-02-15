package movie;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long>{


}