package com.example.demo.Controller;


import com.example.demo.Controller.model.amount.ApiRequest;
import com.example.demo.Controller.model.amount.ApiResponse;
import com.example.demo.Controller.model.exchange.TipoDeCambio;
import com.example.demo.dao.BcpDao;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

    @Autowired
    public BcpDao bcpDao;


    @GetMapping("/dota")
    public Observable<ApiResponse> apiResponse (@RequestBody ApiRequest apiRequest){


        return bcpDao.MontoFinal(apiRequest);


   }

    @PostMapping("")
    public Observable<TipoDeCambio> apiResponse (@RequestBody TipoDeCambio tipoDeCambio){


        return bcpDao.CambiarTipoDeCambio(tipoDeCambio);


    }

}