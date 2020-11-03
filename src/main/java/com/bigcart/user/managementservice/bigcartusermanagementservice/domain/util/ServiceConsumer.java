package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.util;

import java.net.URISyntaxException;

public interface ServiceConsumer {
    public void sendNotification(Email email) throws URISyntaxException;
}
