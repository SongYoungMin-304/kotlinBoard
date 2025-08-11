package com.project.api.service

import org.springframework.stereotype.Service

@Service
class VIsaCardApiService: ApiService
{
    override fun getType(): CardNetwork {
        return CardNetwork.VISA_CARD
    }
    override fun doSomething(): String {
        return "VisaCardApiService is doing something"
    }
}