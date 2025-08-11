package com.project.api.service

import org.springframework.stereotype.Component
import java.util.Collections
import java.util.LinkedList
import java.util.Queue

@Component
class Router(
        masterCardApiService: MasterCardApiService,
        visaCardApiService: VIsaCardApiService
) {
    private val handlerMap = mutableMapOf<CardNetwork, ApiService>()
    private val shuffledQueue: Queue<ApiService> = LinkedList()

    init {
        handlerMap[masterCardApiService.getType()] = masterCardApiService
        handlerMap[visaCardApiService.getType()] = visaCardApiService
        refillQueue()
    }

    private final fun refillQueue() {
        val tempList = mutableListOf<ApiService>()

        // 원하는 비율대로 채우기 (3:7)
        handlerMap[CardNetwork.MASTER_CARD]?.let {
            tempList.addAll(Collections.nCopies(3, it))
        }
        handlerMap[CardNetwork.VISA_CARD]?.let {
            tempList.addAll(Collections.nCopies(7, it))
        }

        // 랜덤하게 섞기
        tempList.shuffle()

        // 큐 교체
        shuffledQueue.clear()
        shuffledQueue.addAll(tempList)

        println("새로운 3:7 큐 생성됨: ${queuePreview()}")
    }

    fun getNext(): ApiService {
        if (shuffledQueue.isEmpty()) {
            refillQueue()
        }
        return shuffledQueue.poll()
    }

    private fun queuePreview(): List<String> {
        return shuffledQueue.map { it.getType().name }
    }
}
