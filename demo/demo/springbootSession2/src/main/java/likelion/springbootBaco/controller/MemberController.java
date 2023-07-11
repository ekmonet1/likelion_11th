package likelion.springbootBaco.controller;

import likelion.springbootBaco.domain.Address;
import likelion.springbootBaco.domain.Member;
import likelion.springbootBaco.dto.MemberDto;
import likelion.springbootBaco.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
 *@Controller
 * 특정 url로 요청을 보내면 어떠한 방식으로 처리할 지 정의한다.
 *@RequestMapping
 * 공동적인 members라는 요청을 MemberController와 매핑한다.
 * 클래스와 메서드 모두의 수준에서 사용할 수 있다.
 */
@Controller
@RequestMapping("members")
public class MemberController {
    /*
 *final field
 수정이 불가능하게 박아놓은 필드.
 상속 등을 금지하고 동일한 데이터를 가져야 할 때 사용한다.
 */
    private final MemberService memberService;

    /*
     * (스프링2 세션 이전 코드)
     *
     *     @Autowired
    public MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberService = memberServiceImpl;
    }

     *
     * 이 것은 생성자입니다.
     * @Autowired라는 어노테이션은 MemberController 객체를 실행해야 할 때 필요한 의존성을 주입해달라고 선언하기 위해 명시하는 어노테이션이며, 생성자 주입 방식을 선언하고 있습니다.
     * MemberController의 필드를 MemberService 타입으로 선언하였지만, 생성자 paramer에는 MemberServiceImpl이 주입되게 함으로써 느슨한 결합(Loosen Coupling)을 구현하였습니다.
     * @참고 : 실제로는 MemberController 생성자의 파라미터에 MemberServiceImpl이 아니라 MemberService로 쓰여있어도 스프링이 알아서 구현체 클래스의 인스턴스 (MemberServiceImpl memberserviceimpl)를 넣어주게 됩니다.
     *       즉, public MemberController(MemberService memberService) {this.memberService = memberService;} 와 같이 작성해도 에러가 없고, 이게 사실 정석입니다.
     *       아래처럼 작성해 둔 이유는, 실제로는 아래와 같이 동작한다는 것을 여러분 눈으로 먼저 보길 바랐던 제 마음이었습니다.
     *       지금, MemberController의 필드가 MemberService 타입의 데이터인데, 생성자로 주입되는 것은 MemberServiceImpl 타입이라는 것을 충분히 음미하시길 바랍니다.
     **/

    /*
    세션 이후 수정된 코드로 MemberService로 선언해도 에러가 뜨지 않는다. 실제로는 예시처럼 MemberServiceImpl이 주입된다.
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
     * @GetMapping
     * new의 GET 요청을 createForm에 맵핑한다.
     * @RequestMapping과 달리 메소드에만 적용한다.
     * @RequestMapping(value=new,method=RequestMethod.GET)과 같은말
     * url을 중복으로 쓰기 위해 사용한다.
     *
     * model.addAttribute()
     * new Member()을 memberForm으로 추가해주고 view에서 memberForm이라는 이름으로 저장횐 new Member()을 사용한다.
     */
    @GetMapping("new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberDto.Create());
        return "members/createMemberForm";
    }

    /*
     * new의 POST 요청을 create에 팹핑한다.
     * @RequestMapping과 달리 메소드에만 적용한다.
     * @RequestMapping(value=new,method=RequestMethod.POST)와 같은말
     * GetMapping과 마찬가지로 url을 중복으로 사용한다.
     *
     * 중간에 뭔가 빠진거같은데 member 받아야하지않나
     *
     * 입력받은 member을 저장하고 redirect로 다른 url 재요청
     **/
    @PostMapping("new")
    public String create(MemberDto.Create memberDto) {
        String name = memberDto.getName();
        String city = memberDto.getCity();
        String state = memberDto.getState();
        String street = memberDto.getStreet();
        String zipcode = memberDto.getZipcode();
        Address address = new Address(city, state, street, zipcode);
        Member member = Member.createMember(name, address);
        memberService.save(member);
        return "redirect:/";
    }

     /*@Get요정이 들어오면 memberService.findAll() 안의 리스트를 반환한다.
     * memberList라는 이름으로 리스트에 데이터를 추가한다.
     **/
    @GetMapping("")
    public String findAll(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList",memberList);
        return "members/memberList";
    }
}
