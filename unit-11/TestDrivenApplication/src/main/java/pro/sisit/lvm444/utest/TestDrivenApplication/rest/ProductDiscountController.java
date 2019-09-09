package pro.sisit.lvm444.utest.TestDrivenApplication.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.ProductDiscountService;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.ProductService;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClientUser;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.ClietUserService;
import pro.sisit.lvm444.utest.TestDrivenApplication.mockito.domain.Product;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/discount")
public class ProductDiscountController {


    @Autowired
    private ProductDiscountService productDiscountService;

    @Autowired
    private ProductService productRepositiory;

    @Autowired
    private ClietUserService clietUserService;

    @GetMapping(value="{id}")
    public String getDiscount(@PathVariable int id,@RequestParam int clientId) {

        Optional<ClientUser> clientUserOpt = clietUserService.find(clientId);

        ClientUser user = clientUserOpt.orElseThrow(() -> new RuntimeException(String.format("user with %d not found", clientId)));

        Optional<Product> productOptional = productRepositiory.find(id);

        Product product = productOptional.orElseThrow(() -> new RuntimeException(String.format("product with %d not found", id)));

        return String.valueOf(productDiscountService.calculateDiscount(product.getCost(),user));
    }


    /*@GetMapping(value="{id}")
    public String getDiscount(@PathVariable int id) {


        return "ok";
    }*/

}
