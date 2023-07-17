package dev.syntax.boot.restapi.domain;

import dev.syntax.boot.restapi.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// REST 요청을 받을 수 있는 Controller
@RestController // @Controller + @ResponseBody
// 경로 맵핑
@RequestMapping("/coffees") // 일반적으로 복수형태로 사용(REST API 명세 작성 규칙 참고)
public class CoffeeRestController {

    // 전체 Coffee 목록을 담고 있는 DB 데이터라고 가정
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeRestController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    /*
     * 지금까지의 반환타입
     * 1. ModelAndView - 박지윤
     * 2. String - 백재원
     * 3. JSON Object - 박진영
     * 4. DTO - 황철원
     * 5. ResponseEntity - 이준희
     */

    // 전체 Coffee 목록 조회 (GET: localhost:8080/coffees)
    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffeeService.findAll();
    }

    // 하나의 Coffee 등록 (POST: localhost:8080/coffees)
    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee) {// @RequestBody - JSON to Java Object
        System.out.println(coffee);
        coffeeService.save(coffee);

        return coffee;
    }

    // PutMapping
    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        System.out.println(id);
        System.out.println(coffee);

        Coffee beforeCoffee = coffeeService.findById(id);

        beforeCoffee.setName(coffee.getName());
        coffeeService.save(beforeCoffee);

        System.out.println(beforeCoffee);
        return ResponseEntity.status(HttpStatus.OK).body(beforeCoffee);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteCoffee(@PathVariable String id) {
        coffeeService.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

