package com.example.usdcourse.data.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Record")
data class RecordDto  @JvmOverloads constructor(
    @field:Attribute(name = "Date", required = false)
    var date: String = "",
    @field:Attribute(name = "Id", required = false)
    var id: String = "",
    @field:Element(name = "Nominal", required = false)
    var nominal: Int = 0,
    @field:Element(name = "Value", required = false)
    var value: String = ""
)