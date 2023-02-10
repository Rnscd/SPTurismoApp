package com.example.turismo.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.turismo.R

data class Turistico(
    @StringRes val nome: Int,
    @StringRes val sobre: Int,
    @DrawableRes val foto: Int
)
var turisticos = listOf<Turistico>(
    Turistico(R.string.aquario, R.string.saquario, R.drawable.aquario),
    Turistico(R.string.masp, R.string.smasp, R.drawable.masp),
    Turistico(R.string.beco, R.string.sbeco, R.drawable.beco),
    Turistico(R.string.berrini, R.string.sberrini, R.drawable.berrini),
    Turistico(R.string.catedral, R.string.scatedral, R.drawable.catedral),
    Turistico(R.string.copan, R.string.scopan, R.drawable.copan),
    Turistico(R.string.futebol, R.string.sfutebol, R.drawable.futebol),
    Turistico(R.string.ibirapuera, R.string.sibirapuera, R.drawable.ibirapuera),
    Turistico(R.string.ipiranga, R.string.sipiranga, R.drawable.ipiranga),
    Turistico(R.string.luz, R.string.sluz, R.drawable.luz),
    Turistico(R.string.masp, R.string.smasp, R.drawable.masp),
    Turistico(R.string.mercadao, R.string.smercadao, R.drawable.mercadao),
    Turistico(R.string.paulista, R.string.spaulista, R.drawable.paulista),
    Turistico(R.string.pinacoteca, R.string.spinacoteca, R.drawable.pinacoteca),
    Turistico(R.string.solar, R.string.ssolar, R.drawable.solar),



    )
