package com.example.demo.dao;

import com.example.demo.Controller.model.amount.ApiRequest;
import com.example.demo.Controller.model.amount.ApiResponse;
import com.example.demo.Controller.model.exchange.TipoDeCambio;
import com.example.demo.model.entity.DataH2;
import com.example.demo.Controller.model.exchange.PostRequest;
import com.example.demo.repository.DataRepository;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class BcpDaoImpl implements BcpDao {

    private static final String ID = "1";


    @Autowired
    private DataRepository dataRepository;


    @Override
    public Observable<ApiResponse> MontoFinal(ApiRequest apiRequest) {

        return Observable.fromIterable(dataRepository.findAll().stream()   
                    .map( x-> apiResponse(x,apiRequest))
                        .collect(Collectors.toList()))
                    .subscribeOn(Schedulers.io());

    }

    @Override
    public Observable<TipoDeCambio> CambiarTipoDeCambio(TipoDeCambio postRequest) {



        return Observable.just(dataRepository.save(dataH2(postRequest))).map(this::postRequest);
    }

    public ApiResponse apiResponse (DataH2 dataH2, ApiRequest apiRequest){

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setMonto(apiRequest.getMonto());
        apiResponse.setMonedaOrigen(apiRequest.getMonedaOrigen());
        apiResponse.setMonedaDestino(apiRequest.getMonedaDestino());

        if(apiRequest.getMonedaOrigen().equals("USD") && apiRequest.getMonedaDestino().equals("SOL"))
        {
            apiResponse.setTipoCambio(dataH2.getVenta());
            apiResponse.setMontoFinal(apiResponse.getTipoCambio() * apiRequest.getMonto());
        }

       else if(apiRequest.getMonedaOrigen().equals("SOL") && apiRequest.getMonedaDestino().equals("USD"))
        {
            apiResponse.setTipoCambio(dataH2.getCompra());
            apiResponse.setMontoFinal(apiResponse.getTipoCambio() * apiRequest.getMonto());
        }
        return apiResponse;
    }

    public TipoDeCambio postRequest (DataH2 dataH2){


        PostRequest postRequest = new PostRequest();
        postRequest.setVenta(dataH2.getVenta());
        postRequest.setCompra(dataH2.getCompra());

        TipoDeCambio tipoDeCambio = new TipoDeCambio();
        tipoDeCambio.setTipoDeCambio(postRequest);

        return tipoDeCambio;
    }

    public DataH2 dataH2 (TipoDeCambio tipoDeCambio) {


        DataH2 dataH2 = new DataH2();
        dataH2.setId(ID);
        dataH2.setVenta(tipoDeCambio.getTipoDeCambio().getVenta());
        dataH2.setCompra(tipoDeCambio.getTipoDeCambio().getCompra());



        return dataH2;
    }




}
