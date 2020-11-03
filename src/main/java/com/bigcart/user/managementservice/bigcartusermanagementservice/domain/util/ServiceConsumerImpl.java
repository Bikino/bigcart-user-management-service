package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.util;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ServiceConsumerImpl implements ServiceConsumer{
    private RestTemplate restTemplate;

    public ServiceConsumerImpl()
    {
        restTemplate = new RestTemplate();
    }
    public void sendNotification(Email email) throws URISyntaxException {
        URI uri = new URI("http://localhost:8006/notify/");
        restTemplate.postForObject(uri, email, Email.class);
    }
}
