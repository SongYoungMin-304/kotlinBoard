package com.project.api.service

import org.springframework.stereotype.Service

@Service
class MasterCardApiService: ApiService{

    override fun getType(): CardNetwork {
        return CardNetwork.MASTER_CARD
    }

    override fun doSomething(): String {
        return "MasterCardApiService is doing something"
    }
}