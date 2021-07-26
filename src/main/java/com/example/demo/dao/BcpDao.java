package com.example.demo.dao;

import com.example.demo.Controller.model.amount.ApiRequest;
import com.example.demo.Controller.model.amount.ApiResponse;
import com.example.demo.Controller.model.exchange.TipoDeCambio;
import io.reactivex.Observable;


public interface BcpDao {

    public Observable<ApiResponse> MontoFinal(ApiRequest apiRequest);

    public Observable<TipoDeCambio> CambiarTipoDeCambio(TipoDeCambio postRequest);
}
