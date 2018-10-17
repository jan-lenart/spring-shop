package com.janlenart.springshop.bo.service

import com.janlenart.springshop.api.OrderCommand
import com.janlenart.springshop.api.dto.*
import com.janlenart.springshop.api.exceptions.ResourceNotFoundException
import com.janlenart.springshop.bo.domain.OrderFactory
import com.janlenart.springshop.bo.domain.OrderInfo
import com.janlenart.springshop.bo.domain.OrderStatus
import com.janlenart.springshop.bo.repository.OrderRepository
import spock.lang.Specification

class OrderServiceTest extends Specification {

    OrderRepository orderRepository = Mock(OrderRepository)

    private OrderService service

    private AddressDTO addressDTO
    private CustomerDTO customerDTO
    private OrderInfoDTO OrderInfoDTO
    private OrderCommand orderCommand
    private OrderInfo orderInfo

    void setup() {
        this.service = new OrderService(orderRepository)
        this.addressDTO = new AddressDTO.Builder().build()
        this.customerDTO = new CustomerDTO.Builder().addressDTO(addressDTO).build()
        this.OrderInfoDTO = new OrderInfoDTO.OrderInfoDTOBuilder().customerDTO(customerDTO).build()
        Set<ItemDTO> itemDTOS = new HashSet<>()
        OrderInfoDTO.setItemDtos(itemDTOS)
        this.orderCommand = new OrderCommand(OrderInfoDTO)
        this.orderInfo = OrderFactory.createOrderInfo(orderCommand)
    }

    def "test showOrder throws exception"() {
        when:
        orderRepository.findById(_) >> Optional.empty()

        this.service.showOrder(1l)

        then:
        thrown(ResourceNotFoundException)
        0 * OrderDTOFactory.createOrderInfoDto(_)

    }

    def "test pay"() {
        when:
        orderRepository.findById(_) >> Optional.of(orderInfo)

        OrderDTOFactory.createOrderInfoDto(_) >> new OrderInfoDTO()
        this.service.pay(1l)

        then:
        orderInfo.status == OrderStatus.PAID

    }

    def "test pay throws exception"() {
        when:
        orderRepository.findById(_) >> Optional.empty()

        this.service.pay(1l)

        then:
        thrown(ResourceNotFoundException)
        0 * orderInfo.pay()
    }

}
