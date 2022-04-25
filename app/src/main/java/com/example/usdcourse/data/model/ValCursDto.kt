package com.example.usdcourse.data.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ValCurs", strict = false)
data class ValCursDto @JvmOverloads constructor(
    @field:Attribute(name = "ID")
    var id: String = "",
    @field:Attribute(name = "DateRange1", required = true, empty = "")
    var DateRange1: String = "",
    @field:Attribute(name = "DateRange2", required = true, empty = "")
    var DateRange2: String = "",
    @field:Attribute(name = "name", required = true, empty = "")
    var name: String = "",
    @field:ElementList(
        inline = true,
        name = "Record",
        entry = "Record",
        required = false,
        empty = true
    )
    var record: MutableList<RecordDto> = mutableListOf()
)