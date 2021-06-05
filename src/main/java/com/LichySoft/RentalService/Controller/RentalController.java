package com.LichySoft.RentalService.Controller;

import com.LichySoft.RentalService.Model.Movie;
import com.LichySoft.RentalService.Service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RentalController {

    private RentalService rentalService;

    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMyMovie(@PathVariable Long id){
        return  ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/setAvailable/{id}")
    public ResponseEntity<Void> setAvailable(@PathVariable Long id){
        rentalService.returnMovie(id);
        return  ResponseEntity.ok().build();
    }

}