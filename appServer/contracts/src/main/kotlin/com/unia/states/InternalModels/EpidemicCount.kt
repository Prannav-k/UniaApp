package com.unia.states.InternalModels

import net.corda.core.identity.Party
import net.corda.core.serialization.CordaSerializable

@CordaSerializable
data class EpidemicCount(
        var country: Party,
        var active: Int,
        var recovered: Int,
        var total: Int
        //TODO Under observation
)