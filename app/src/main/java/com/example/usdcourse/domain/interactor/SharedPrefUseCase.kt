package com.example.usdcourse.domain.interactor

import com.example.usdcourse.domain.repository.SharedPrefRepository

class SharedPrefUseCase(private val sharedPrefRepository: SharedPrefRepository) {

    fun saveData(float: Float){
        sharedPrefRepository.saveDate(float)
    }

    fun getData(): Float{
        return sharedPrefRepository.getData()
    }
}