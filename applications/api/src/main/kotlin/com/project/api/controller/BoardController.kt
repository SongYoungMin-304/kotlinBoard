package com.project.api.controller

import com.project.domain.dto.response.TestResponseDto

class BoardController {


    fun getBoards(): TestResponseDto
    {
        return TestResponseDto(1, "Board Name", "Board Description")
    }

}