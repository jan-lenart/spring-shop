package com.janlenart.springshop

import com.janlenart.springshop.api.dto.OrderInfoDTO
import com.janlenart.springshop.bo.service.OrderService
import com.janlenart.springshop.web.controllers.OrderController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@WebMvcTest(controllers = [OrderController])
class SpringShopApplicationTest extends Specification {

    final String ORDER_REQUEST_CREATE_JSON = '{\n' +
            '"orderInfoDTO": {\n' +
            '"id": 1,\n' +
            '"orderDateTime": "2018-09-14 18:38:09",\n' +
            '"totalPriceCurrency": "PLN",\n' +
            '"customerDTO": {\n' +
            '"id": 1,\n' +
            '"name": "Stefan",\n' +
            '"surname": "Kowalski",\n' +
            '"pesel": "75110521456",\n' +
            '"addressDTO": {\n' +
            '"id": 1,\n' +
            '"city": "Grójec",\n' +
            '"street": "Główna",\n' +
            '"houseNr": 125,\n' +
            '"apartmentNr": 54\n' +
            '}\n' +
            '},\n' +
            '"itemDTOs": [\n' +
            '{\n' +
            '"id": 1,\n' +
            '"name": "Banana",\n' +
            '"description": "It is a banana",\n' +
            '"barcode": "BBB",\n' +
            '"price": 2.15,\n' +
            '"quantity": 300,\n' +
            '"priceCurrency": "PLN"\n' +
            '},\n' +
            '{\n' +
            '"id": 2,\n' +
            '"name": "Coconut",\n' +
            '"description": "It is a coconut",\n' +
            '"barcode": "CCC",\n' +
            '"price": 12.86,\n' +
            '"quantity": 1,\n' +
            '"priceCurrency": "PLN"\n' +
            '}\n' +
            ']\n' +
            '}\n' +
            '\n' +
            '}'

    @Autowired
    MockMvc mockMvc

    @Autowired
    OrderService orderService

    @TestConfiguration
    static class MockConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        OrderService orderService() {
            return detachedMockFactory.Mock(OrderService)
        }

    }

    def "test show order"() {

        when:
        orderService.showOrder(_) >> new OrderInfoDTO()

        def response = mockMvc.perform(get('/order/1')).andReturn().response

        then:
        1 * orderService.showOrder(1L)
        response.status == OK.value()
    }

    def "test create order"() {

        when:
        orderService.createOrder(_) >> new OrderInfoDTO()

        and:
        def response = mockMvc.perform(post('/order/new')
                .contentType(APPLICATION_JSON)
                .content(ORDER_REQUEST_CREATE_JSON)
        ).andReturn().response

        then:
        1 * orderService.createOrder(_)
        response.status == CREATED.value()

    }

    def "test pay for order"() {

        when:
        orderService.pay(1) >> new OrderInfoDTO()

        and:
        def response = mockMvc.perform(post('/order/pay')
                .contentType(APPLICATION_JSON)
                .content('1')
        ).andReturn().response

        then:
        1 * orderService.pay(1L)
        response.status == OK.value()
    }
}
