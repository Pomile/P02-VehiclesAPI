//package com.udacity.pricing.api;
//
//import com.udacity.pricing.domain.price.Price;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Implements a REST-based controller for the pricing service.
// */
//@RestController
//@RequestMapping("/prices")
//public class PricingController {
//
//    /**
//     * Gets the price for a requested vehicle.
//     * @param vehicleId ID number of the vehicle for which the price is requested
//     * @return price of the vehicle, or error that it was not found.
//     */
//    @GetMapping(params = "vehicleId")
//    public Price get(@RequestParam Long vehicleId) {
//
//        System.out.print(vehicleId);
//        return new Price();
////        try {
////            return new Price();
////        } catch (PriceException ex) {
////            throw new ResponseStatusException(
////                    HttpStatus.NOT_FOUND, "Price Not Found", ex);
////        }
//
//    }
//}
