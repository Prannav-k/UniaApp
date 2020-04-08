package com.unia.states

import com.unia.contracts.EpidemicStatContract
import com.unia.states.InternalModels.EpidemicCount
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.Party
import java.util.*

@BelongsToContract(EpidemicStatContract::class)
data class EpidemicStatState(
        var epidemid:String,
        //Add they a name value pair and check it in contract if that name value pair is updated by tht country
        var count: MutableList<EpidemicCount>? = mutableListOf<EpidemicCount>(),
        var parties:MutableList<Party>,
        override val linearId: UniqueIdentifier= UniqueIdentifier(epidemid, UUID.randomUUID())
):LinearState {
    override val participants= parties
    fun updateNewCount(lst:MutableList<EpidemicCount>)= copy(count = lst)
    fun updateParticipants(party: Party)= copy( parties = (parties + party).toMutableList() )
}