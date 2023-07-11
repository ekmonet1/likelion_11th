package likelion.springbootBaco.controller;

import likelion.springbootBaco.domain.Item;
import likelion.springbootBaco.domain.Member;
import likelion.springbootBaco.domain.Order;
import likelion.springbootBaco.service.ItemService;
import likelion.springbootBaco.service.MemberService;
import likelion.springbootBaco.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("orders")//orders로 시작하는 url만 받겠다.
public class OrderController { //의존성이 크다 -> 여러가지가 들어가이따
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("order")
    public String createForm(Model model) {
        List<Member> members = memberService.findAll();
        List<Item> items = itemService.findAll();
        model.addAttribute("members", members);
        model.addAttribute("items", items);
        return "order/orderForm";
    }

    @PostMapping("order")
    public String order(@RequestParam("memberId") Long memberId, //파라미터를 받는 방법 - 예시로 만들어서 주신대
                        @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {
        orderService.createOrder(memberId, itemId, count); //order를 생성. order를 service로직에 포함시켰기 때문에
        return "redirect:/orders";
    }

    @GetMapping("")
    public String orderList(Model model) {
        List<Order> orderList = orderService.findOrderList();
        model.addAttribute("orders", orderList);
        return "order/orderList";
    }

    @PostMapping("{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) { //요청받는 방법 중 하나. to be continued..
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
