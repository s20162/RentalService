package com.LichySoft.RentalService.Service;


import com.LichySoft.RentalService.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {


    private RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id){
        String urlRequest = "http://localhost:8080/movieController/movies/";
        return restTemplate.getForObject(urlRequest + id, Movie.class);
    }

    public void returnMovie(Long id){
        String urlRequest = "http://localhost:8080/movieController/changeAvailable/";
        restTemplate.put(urlRequest + id, Movie.class);
    }
}