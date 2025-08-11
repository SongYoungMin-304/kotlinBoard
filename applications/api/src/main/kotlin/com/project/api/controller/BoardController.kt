package com.project.api.controller

import com.project.api.service.Router
import com.project.domain.dto.response.TestResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
        private val router: Router
) {

    @GetMapping("/api/boards")
    fun getBoards(): TestResponseDto
    {
        return TestResponseDto(1, "Board Name", "Board Description")
    }

    @GetMapping("/api/submit")
    fun submit(): String{
        val apiService = router.getNext()
        return apiService.doSomething()
    }

}