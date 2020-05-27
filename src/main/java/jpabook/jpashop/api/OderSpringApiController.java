package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.repository.order.springdata.OrderSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OderSpringApiController {
    private final OrderSpringDataRepository orderSpringDataRepository;



    @GetMapping("/spring-api/v1/orders")
    public List<OrderApiController.OrderDto> ordersV3_page(
            @RequestParam(value = "offset",defaultValue = "0") int offset,
            @RequestParam(value = "limit",defaultValue ="100") int limit
    ){



        Page<Order> allWithMemberDelivery = orderSpringDataRepository.findAllWithMemberDelivery(PageRequest.of(offset, limit));
        List<Order> content = allWithMemberDelivery.getContent();

        for (Order order : content) {
            List<OrderItem> orderItems = order.getOrderItems();
            for (OrderItem orderItem : orderItems) {
                orderItem.getItem().getName();
            }
        }
        List<OrderApiController.OrderDto> collect = new ArrayList<>();
        return collect;
    }
}
