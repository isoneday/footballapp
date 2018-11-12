package com.isoneday.footballappapi.mvp.model

import com.google.gson.annotations.SerializedName

data class ResponseLeague(

	@field:SerializedName("events")
	val events: List<EventsItem>? = null
)