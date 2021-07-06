package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.config.ExchangeRatesConfig;
import com.kodilla.restaurantbackend.domain.CreatedRateDto;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.RatesDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExchangeRatesClientTestSuite {
    @InjectMocks
    private ExchangeRatesClient exchangeRatesClient;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ExchangeRatesConfig exchangeRatesConfig;

    @Test
    void testShouldFetchExchangeRates() throws URISyntaxException {
        //Given
        when(exchangeRatesConfig.getExchangeRatesLatestEndpoint()).thenReturn("http://test.com");
        when(exchangeRatesConfig.getExchangeRatesAppKey()).thenReturn("test");
        when(exchangeRatesConfig.getExchangeRatesBase()).thenReturn("test");
        when(exchangeRatesConfig.getExchangeRatesSymbols()).thenReturn("test");
        RatesDto rateDto = new RatesDto(1.0, 2.0, 3.0);
        ExchangeRatesLatestDto exchangeRatesLatestDto = new ExchangeRatesLatestDto(true, 123, "eur", "2021-07-02", rateDto);
        URI url = new URI("http://test.com?access_key=test&base=test&symbols=test");
        when(restTemplate.getForObject(url, ExchangeRatesLatestDto.class)).thenReturn(exchangeRatesLatestDto);
        //When
        ExchangeRatesLatestDto fetchExchangeRates = exchangeRatesClient.getExchangeRateLatest();
        //Then
        assertEquals(123, fetchExchangeRates.getTimestamp());
        assertEquals("eur", fetchExchangeRates.getBase());
        assertEquals("2021-07-02", fetchExchangeRates.getDate());
        assertEquals(1.0, fetchExchangeRates.getRatesDto().getPln());
        assertEquals(2.0, fetchExchangeRates.getRatesDto().getUsd());
        assertEquals(3.0, fetchExchangeRates.getRatesDto().getGbp());

    }
    @Test
    public void shouldCreateRate() throws URISyntaxException {
        //Given
        when(exchangeRatesConfig.getExchangeRatesLatestEndpoint()).thenReturn("http://test.com");
        when(exchangeRatesConfig.getExchangeRatesAppKey()).thenReturn("test");
        when(exchangeRatesConfig.getExchangeRatesBase()).thenReturn("test");
        when(exchangeRatesConfig.getExchangeRatesSymbols()).thenReturn("test");
        RatesDto ratesDto = new RatesDto(1.0,2.0, 3.9);
        URI url = new URI("http://test.com?access_key=test&base=test&symbols=test");
        CreatedRateDto createdRateDto = new CreatedRateDto(2.0, 3.0, 4.0);
        when(restTemplate.postForObject(url, null, CreatedRateDto.class)).thenReturn(createdRateDto);
        //When
        CreatedRateDto newRate = exchangeRatesClient.createNewRate(ratesDto);
        //Then
        assertEquals(2.0, newRate.getPln());
        assertEquals(3.0, newRate.getUsd());
        assertEquals(4.0, newRate.getGbp());
    }
}
