package jpabook.jpashop.repository.order.springdata;

import jpabook.jpashop.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderSpringDataRepository extends JpaRepository<Order,Long> {

    @Query(value = "select o from Order o join fetch o.member m join fetch o.delivery d",countQuery = "select count(o) from Order o")
    public Page<Order> findAllWithMemberDelivery(Pageable pageable);

//    public List<Order> findAllWithMemberDelivery(int offset, int limit) {
//        return  em.createQuery(
//                "select o from Order o " +
//                        "join fetch o.member m " +
//                        "join fetch o.delivery d",Order.class
//        ).setFirstResult(offset)
//                .setMaxResults(limit)
//                .getResultList();
//    }
}
