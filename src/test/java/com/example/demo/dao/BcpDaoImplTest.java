package com.example.demo.dao;

import com.example.demo.Controller.model.amount.ApiRequest;
import com.example.demo.Controller.model.amount.ApiResponse;
import com.example.demo.Controller.model.exchange.PostRequest;
import com.example.demo.Controller.model.exchange.TipoDeCambio;
import com.example.demo.model.entity.DataH2;
import com.example.demo.repository.DataRepository;
import io.reactivex.observers.TestObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class BcpDaoImplTest {

    @Mock
    private DataRepository dataRepository;

    @InjectMocks
    private BcpDaoImpl bcpDao;


    @Test
    public void montoFinalVenta() {

        DataH2 dataH2 = new DataH2();

        dataH2.setId("1");
        dataH2.setVenta(3.50);
        dataH2.setCompra(4.0);

        List<DataH2> dataH2List = new ArrayList<>();

        dataH2List.add(dataH2);

        Mockito.when(dataRepository.findAll()).thenReturn(dataH2List);


        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setMonto(5.0);
        apiRequest.setMonedaDestino("USD");
        apiRequest.setMonedaOrigen("SOL");

        TestObserver<ApiResponse> testObserver = new TestObserver<>();
        bcpDao.MontoFinal(apiRequest).subscribe(testObserver);
        testObserver.assertNoErrors();



    }

    @Test
    public void montoFinalCompra() {

        DataH2 dataH2 = new DataH2();

        dataH2.setId("1");
        dataH2.setVenta(3.50);
        dataH2.setCompra(4.0);

        List<DataH2> dataH2List = new ArrayList<>();



        dataH2List.add(dataH2);

        Mockito.when(dataRepository.findAll()).thenReturn(dataH2List);

        ApiRequest apiResponse = new ApiRequest();
        apiResponse.setMonto(5.0);
        apiResponse.setMonedaDestino("SOL");
        apiResponse.setMonedaOrigen("USD");

        TestObserver<ApiResponse> testObserver = new TestObserver<>();
        bcpDao.MontoFinal(apiResponse).subscribe(testObserver);
        testObserver.assertNoErrors();



    }



    @Test
    public void cambiarTipoDeCambio() {

        DataH2 dataH2 = new DataH2();

        dataH2.setId("1");
        dataH2.setVenta(3.50);
        dataH2.setCompra(4.0);

        Mockito.when(dataRepository.save(Mockito.any())).thenReturn(dataH2);


        PostRequest postRequest = new PostRequest();
        postRequest.setVenta(6.00);
        postRequest.setCompra(7.00);

        TipoDeCambio tipoDeCambio = new TipoDeCambio();
        tipoDeCambio.setTipoDeCambio(postRequest);

        TestObserver<TipoDeCambio> testObserver = new TestObserver<>();
        bcpDao.CambiarTipoDeCambio(tipoDeCambio).subscribe(testObserver);
        testObserver.assertNoErrors();
    }
}