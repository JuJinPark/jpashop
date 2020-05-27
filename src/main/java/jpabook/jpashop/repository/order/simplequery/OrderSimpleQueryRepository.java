package jpabook.jpashop.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    //재사용성이 떨어지고 스펙이 리파지토리에 들어오고 정확이 데이터를 필요한것만 가지
    //고 와서 성능을 최적화 한다지만 그 효과 는 미비하다.
    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery(
                "select new jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id,m.name,o.orderDate,o.status,d.address) " +
                        "from Order o " +
                        "join  o.member m " +
                        "join  o.delivery d",OrderSimpleQueryDto.class
        ).getResultList();
    }
}
