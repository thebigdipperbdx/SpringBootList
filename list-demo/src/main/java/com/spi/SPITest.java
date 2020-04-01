package com.spi;

import com.service.MessageService;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author yanyugang
 * @description Service Provider Interface,是一种服务发现机制。
 * sun.misc.Service
 * java.util.ServiceLoader
 * @date 2019-11-01 14:15
 */
public class SPITest {
    public static void main(String[] args){
        Iterator<MessageService> providers=Service.providers(MessageService.class);
        while (providers.hasNext()) {
            MessageService service=providers.next();
            System.out.println(service.getMessage());
        }
        System.out.println("--------------------------------");

        ServiceLoader<MessageService> load=ServiceLoader.load(MessageService.class);
        Iterator<MessageService> iterator=load.iterator();
        while (iterator.hasNext()) {
            MessageService service=iterator.next();
            System.out.println(service.getMessage());
        }
    }
}
