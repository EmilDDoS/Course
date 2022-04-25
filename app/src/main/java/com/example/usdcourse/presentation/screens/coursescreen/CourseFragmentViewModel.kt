package com.example.usdcourse.presentation.screens.coursescreen

import androidx.lifecycle.ViewModel
import com.example.usdcourse.data.sharedpreferences.EMPTY_NUMBER
import com.example.usdcourse.domain.entity.CourseUSD
import com.example.usdcourse.domain.interactor.MonthlyCourseUseCase
import com.example.usdcourse.domain.interactor.SharedPrefUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.*

private const val FORMAT_DATE = "dd/MM/yyyy"

class CourseFragmentViewModel(
    private val monthlyCourseUseCase: MonthlyCourseUseCase,
    private val sharedPrefUseCase: SharedPrefUseCase
) : ViewModel() {

    private lateinit var disposable: Disposable
    private val format = SimpleDateFormat(FORMAT_DATE)

    private val _monthlyCourse = MutableStateFlow(listOf<CourseUSD>())
    val monthlyCourse: StateFlow<List<CourseUSD>>
        get() = _monthlyCourse.asStateFlow()

    private val _enteredNumber = MutableStateFlow(EMPTY_NUMBER)
    val enteredNumber: StateFlow<Float>
        get() = _enteredNumber.asStateFlow()

    fun getMonthlyCourse() {
        val currentDate = Date()
        val startDate = Calendar.getInstance()
        startDate.time = currentDate
        startDate.add(Calendar.MONTH, -1)

        val formatStartDate = format.format(startDate.time)
        val formatCurrentDate = format.format(currentDate.time)

        disposable = monthlyCourseUseCase.execute(formatStartDate, formatCurrentDate)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                _monthlyCourse.tryEmit(it)
            }

    }

    fun saveNumber(float: Float){
        sharedPrefUseCase.saveData(float)
        getNumber()
    }

    fun getNumber(){
        val number = sharedPrefUseCase.getData()
        _enteredNumber.tryEmit(number)
    }

    override fun onCleared() {
        super.onCleared()
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}